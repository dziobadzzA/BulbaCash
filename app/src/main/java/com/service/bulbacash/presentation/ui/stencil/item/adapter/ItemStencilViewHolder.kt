package com.service.bulbacash.presentation.ui.stencil.item.adapter

import androidx.recyclerview.widget.RecyclerView
import com.service.bulbacash.databinding.StencilBinding
import com.service.bulbacash.domain.models.ItemStencil

class ItemStencilViewHolder(
    private val binding: StencilBinding,
    private val listener: ItemStencilListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(itemStencil: ItemStencil) {

    }

}