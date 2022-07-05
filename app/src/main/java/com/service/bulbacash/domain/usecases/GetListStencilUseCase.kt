package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.StencilRepository

class GetListStencilUseCase (private val repository: StencilRepository) {
    suspend operator fun invoke() = repository.getListStencil()
}