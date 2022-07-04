package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.Stencil

interface StencilRepository {
    fun saveStencil(stencil: Stencil)
    fun deleteStencil(stencil: Stencil)
}