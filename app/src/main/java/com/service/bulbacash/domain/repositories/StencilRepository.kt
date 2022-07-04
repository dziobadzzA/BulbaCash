package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.Stencil

interface StencilRepository {
    suspend fun saveStencil(stencil: Stencil)
    suspend fun deleteStencil(stencil: Stencil)
}