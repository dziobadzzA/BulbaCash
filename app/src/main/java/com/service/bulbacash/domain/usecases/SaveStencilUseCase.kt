package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.models.Stencil
import com.service.bulbacash.domain.repositories.StencilRepository

class SaveStencilUseCase(private val repository: StencilRepository) {
    suspend operator fun invoke(stencil: Stencil) = repository.saveStencil(stencil=stencil)
}