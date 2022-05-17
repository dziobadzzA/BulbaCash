package com.service.bulbacash.presentation.ui.graph

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.Helper
import com.service.bulbacash.domain.usecases.CoursePeriodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(
    private val coursePeriodUseCase: CoursePeriodUseCase,
    private val mapHelper: Helper
): ViewModel() {

    private var _ID_buckets = MutableStateFlow<Long?>(null)
    private val ID_buckets = _ID_buckets.asStateFlow()

    fun getIDBuckets(id:Long) {
        _ID_buckets.value = id
    }

}