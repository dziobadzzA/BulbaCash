package com.service.bulbacash.presentation.ui.stencil.item.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.service.bulbacash.databinding.StencilBinding
import com.service.bulbacash.domain.models.ItemStencil

class ItemStencilAdapter(private val listener: ItemStencilListener):
    ListAdapter<ItemStencil, ItemStencilViewHolder>(ItemStencilDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStencilViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StencilBinding.inflate(layoutInflater, parent, false)
        return ItemStencilViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ItemStencilViewHolder, position: Int) {
        holder.bind(getItem(holder.layoutPosition))
    }

}