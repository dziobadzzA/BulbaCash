package com.service.bulbacash.presentation.ui.course

import com.service.bulbacash.domain.usecases.CourseDateUseCase
import com.service.bulbacash.domain.usecases.CourseTodayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val courseTodayUseCase: CourseTodayUseCase,
    private val courseDateUseCase: CourseDateUseCase
) {
}