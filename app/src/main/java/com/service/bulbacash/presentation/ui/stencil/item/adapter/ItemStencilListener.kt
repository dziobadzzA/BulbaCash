package com.service.bulbacash.presentation.ui.stencil.item.adapter

import com.service.bulbacash.domain.models.ItemStencil

interface ItemStencilListener {
    fun clickEditItemStencil(itemStencil: ItemStencil)
    fun clickDeleteItemStencil(itemStencil: ItemStencil)
}