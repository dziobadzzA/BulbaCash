package com.service.bulbacash.presentation.ui.graph

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.Helper
import com.service.bulbacash.domain.usecases.CourseDateUseCase
import com.service.bulbacash.domain.usecases.CourseTodayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(
    private val courseTodayUseCase: CourseTodayUseCase,
    private val courseDateUseCase: CourseDateUseCase,
    private val mapHelper: Helper
): ViewModel() {
}