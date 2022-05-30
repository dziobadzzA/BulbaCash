package com.service.bulbacash.presentation.ui.course

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.Helper
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.usecases.CourseDateUseCase
import com.service.bulbacash.domain.usecases.CourseTodayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val courseTodayUseCase: CourseTodayUseCase,
    private val courseDateUseCase: CourseDateUseCase,
    private val mapHelper: Helper
):ViewModel() {

    private val list = listOf(BucketRate(
        firstElement = Rate(
            Cur_ID = 431,
            Date = "2022-04-10T00:00:00",
            Cur_Abbreviation = "USD",
            Cur_Scale = 1,
            Cur_Name = "Доллар США",
            Cur_OfficialRate = 2.80
        ),
        secondElement = Rate(
            Cur_ID = 451,
            Date = "2022-04-10T00:00:00",
            Cur_Abbreviation = "EUR",
            Cur_Scale = 1,
            Cur_Name = "Евро",
            Cur_OfficialRate = 3.00
        ),
        0.93,
        1,
        1, 0
    ))

    private var _buckets = MutableStateFlow(list.toMutableList()) // MutableStateFlow(mutableListOf<BucketRate>())
    val buckets = _buckets.asStateFlow()

    private val oldBuckets = mutableListOf<BucketRate>()

    fun getAllCourseToday() {

        // temp for storage value in time-process
        insertAndClearOldValue(oldBuckets, buckets.value)
        // null list items
        _buckets.value = mutableListOf()

        val newBuckets = mutableListOf<BucketRate>()

        for (i in oldBuckets.indices) {
            CoroutineScope(Dispatchers.IO).launch {
                newBuckets.add(updateBucket(oldBuckets[i]))
                if (i == oldBuckets.size - 1) {
                    diffOldNewBucket(newBuckets, oldBuckets)
                    _buckets.value = newBuckets
                }
            }
        }

    }

    private fun insertOldValue(list:MutableList<BucketRate>, whatDo: MutableList<BucketRate>) {
        for (item in whatDo) {
            list.add(item.copy())
        }
    }

    private fun clearOldValue(list:MutableList<BucketRate>) {
        list.clear()
    }

    private fun insertAndClearOldValue(list:MutableList<BucketRate>, whatDo: MutableList<BucketRate>) {
        clearOldValue(list = list)
        insertOldValue(list = list, whatDo)
    }

    private suspend fun updateBucket(item: BucketRate):BucketRate
        = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            item.firstElement  = item.firstElement?.let { updateElementRateInBucket(item = it) }
            item.secondElement = item.secondElement?.let{ updateElementRateInBucket(item = it) }
            item
        }

    private suspend fun updateBucket(item: BucketRate, onDate: String): BucketRate
            = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
        item.firstElement  = item.firstElement?.let { updateElementRateInBucket(item = it, onDate = onDate) }
        item.secondElement = item.secondElement?.let{ updateElementRateInBucket(item = it, onDate = onDate) }
        item
    }

    private suspend fun updateElementRateInBucket(item: Rate): Rate?
        = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            item.let { courseTodayUseCase.invoke(it.Cur_ID) }
        }

    private suspend fun updateElementRateInBucket(item: Rate, onDate: String): Rate?
            = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
        item.let { courseDateUseCase.invoke(it.Cur_ID, onDate) }
    }

    fun getItemCourseDate(bucket: BucketRate, onDate: String) {

        val index =  buckets.value.indexOf(bucket)
        val newBuckets = buckets.value.toMutableList()

        insertAndClearOldValue(oldBuckets, buckets.value)
        _buckets.value = mutableListOf()

        CoroutineScope(Dispatchers.IO).launch {
            if (index >= 0) {
                newBuckets[index] = updateBucket(newBuckets[index], mapHelper.parseCurrentDate(onDate))
            }
            diffOldNewBucket(newBuckets, oldBuckets)
            _buckets.value = newBuckets
        }
    }

    private fun diffOldNewBucket(currentBuckets: MutableList<BucketRate>, oldBuckets: MutableList<BucketRate>) {
        for (i in currentBuckets.indices) {
            // decide typeFirst
            currentBuckets[i].typeFirst = choiceMethod(current = currentBuckets[i].firstElement!!,
                old = oldBuckets[i].firstElement!!)
            // decide typeSecond
            currentBuckets[i].typeSecond = choiceMethod(current = currentBuckets[i].secondElement!!,
                old = oldBuckets[i].secondElement!!)
            // decide coefficient
            currentBuckets[i].coeffiecient = currentBuckets[i].firstElement?.Cur_OfficialRate!! /
                    currentBuckets[i].secondElement?.Cur_OfficialRate!!
        }
    }

    private fun choiceMethod(current: Rate, old: Rate): Int {
        return when {
            current.Cur_OfficialRate > old.Cur_OfficialRate ->  { 2 }
            current.Cur_OfficialRate < old.Cur_OfficialRate ->  { 0 }
            current.Cur_OfficialRate == old.Cur_OfficialRate -> { 1 }
            else -> { 0 }
        }
    }

}