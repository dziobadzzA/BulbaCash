package com.service.bulbacash.presentation.ui.buckets

import androidx.lifecycle.ViewModel
import com.service.bulbacash.domain.usecases.GetAllBucketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkBucketsViewModel @Inject constructor(
    private val getAllBucketsUseCase: GetAllBucketsUseCase,
):ViewModel() {
}