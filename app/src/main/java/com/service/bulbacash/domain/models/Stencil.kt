package com.service.bulbacash.domain.models

data class Stencil(
    val id: Int,
    val nameStencil: String,
    val listItems: List<ItemStencil>
)
