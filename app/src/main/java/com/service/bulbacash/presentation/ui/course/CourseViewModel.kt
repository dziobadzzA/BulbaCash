package com.service.bulbacash.presentation.ui.course

import androidx.lifecycle.ViewModel
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
    private val courseDateUseCase: CourseDateUseCase
):ViewModel() {

    private var _buckets = MutableStateFlow<MutableList<BucketRate>>(mutableListOf())
    val buckets = _buckets.asStateFlow()

    fun getAllCourseToday() {
        for (i in 0 until _buckets.value.size) {
           CoroutineScope(Dispatchers.Default).launch {
               val response = updateBucket(item = _buckets.value[i])
               _buckets.value[i] = response
           }
        }
    }

    private suspend fun updateBucket(item: BucketRate):BucketRate
        = withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
            item.firstElement  = item.firstElement?.let { updateElementRateInBucket(item = it) }
            item.secondElement = item.secondElement?.let{ updateElementRateInBucket(item = it) }
            item
        }

    private suspend fun updateBucket(item: BucketRate, onDate: String): BucketRate
            = withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
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
        val index = _buckets.value.indexOf(bucket)
        CoroutineScope(Dispatchers.Default).launch {
             val response = updateBucket(_buckets.value[index], onDate)
            _buckets.value[index] = response
        }
    }


}