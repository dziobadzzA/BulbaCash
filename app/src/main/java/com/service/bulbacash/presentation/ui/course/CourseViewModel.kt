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


    val list = listOf(BucketRate(
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
        )
    ))

    private var _buckets = MutableStateFlow(list.toMutableList())
    val buckets = _buckets.asStateFlow()

    private var oldBucket = mutableListOf<BucketRate>()
    private var newBucket = mutableListOf<BucketRate>()

    fun getAllCourseToday() {

        newBucket.clear()
        oldBucket = _buckets.value
        _buckets.value = mutableListOf()

        for (i in 0 until oldBucket.size) {
            CoroutineScope(Dispatchers.IO).launch {
                newBucket.add(updateBucket(item = oldBucket[i]))

                if (i == oldBucket.size - 1)
                    _buckets.value = newBucket
            }
        }
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
        val index =  _buckets.value.indexOf(bucket)
        oldBucket =  _buckets.value
        newBucket = oldBucket
        _buckets.value = mutableListOf()

        CoroutineScope(Dispatchers.IO).launch {
            newBucket[index] = updateBucket(newBucket[index], mapHelper.parseCurrentDate(onDate))
            _buckets.value = newBucket
        }
    }

    private fun diffOldNewBucket() {

    }

}