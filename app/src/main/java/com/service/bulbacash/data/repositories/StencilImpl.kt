package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.domain.models.Stencil
import com.service.bulbacash.domain.repositories.StencilRepository
import javax.inject.Inject

class StencilImpl @Inject constructor(
    private val bulbaCashDAO: BulbaCashDAO):StencilRepository
{
    override suspend fun saveStencil(stencil: Stencil) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStencil(stencil: Stencil) {
        TODO("Not yet implemented")
    }

    override suspend fun getListStencil(): List<Stencil> {
        TODO("Not yet implemented")
    }

}