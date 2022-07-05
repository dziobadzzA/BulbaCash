package com.service.bulbacash.presentation.ui.stencil.item

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.AdapterWorkBuckets
import com.service.bulbacash.di.MapperCountries
import com.service.bulbacash.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ItemStencilViewModel @Inject constructor(
    private val saveStencilUseCase: SaveStencilUseCase,
    private val deleteStencilUseCase: DeleteStencilUseCase,
    private val mapMapperCountries: MapperCountries,
    private val mapAdapterWorkBuckets: AdapterWorkBuckets
): ViewModel() {

}