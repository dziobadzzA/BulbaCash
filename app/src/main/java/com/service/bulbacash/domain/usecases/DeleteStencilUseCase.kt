package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.models.Stencil
import com.service.bulbacash.domain.repositories.StencilRepository

class DeleteStencilUseCase (private val repository: StencilRepository) {
    suspend operator fun invoke(stencil: Stencil) = repository.deleteStencil(stencil=stencil)
}