package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.ItemStencilEntity
import com.service.bulbacash.data.db.entity.StencilEntity
import com.service.bulbacash.domain.models.ItemStencil
import com.service.bulbacash.domain.models.Stencil
import com.service.bulbacash.domain.utill.Mapper

class StencilEntityToStencil(
    private val bulbaCashDAO: BulbaCashDAO,
    private val mapperItemStencilEntityToItemStencil: ItemStencilEntityToItemStencil) {

     suspend fun map(from: StencilEntity): Stencil {
        val listItems = bulbaCashDAO.getListItemsStencil(stencil_id = from.id)
        return Stencil(
            nameStencil = from.nameStencil,
            listItems = mapperItemStencilEntityToItemStencil.mapList(listItems)
        )
    }
}

class ItemStencilEntityToItemStencil: Mapper<ItemStencilEntity, ItemStencil> {
    override fun map(from: ItemStencilEntity): ItemStencil {
        return ItemStencil(
            Cur_ID = from.Cur_ID,
            costName = from.CostName
        )
    }
}

class ItemStencilToItemStencilEntity: Mapper<ItemStencil, ItemStencilEntity> {
    override fun map(from: ItemStencil): ItemStencilEntity {
        return ItemStencilEntity(
            Cur_ID = from.Cur_ID,
            CostName = from.costName
        )
    }
}

class StencilToStencilEntity: Mapper<Stencil, StencilEntity> {
    override fun map(from: Stencil): StencilEntity {
        return StencilEntity(
            nameStencil = from.nameStencil
        )
    }
}