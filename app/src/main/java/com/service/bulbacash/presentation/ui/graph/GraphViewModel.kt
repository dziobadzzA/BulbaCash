package com.service.bulbacash.presentation.ui.graph

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.Helper
import com.service.bulbacash.domain.usecases.CoursePeriodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(
    private val coursePeriodUseCase: CoursePeriodUseCase,
    private val mapHelper: Helper
): ViewModel() {

}