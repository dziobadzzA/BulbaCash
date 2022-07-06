package com.service.bulbacash.presentation.ui.stencil.item.adapter

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.service.bulbacash.domain.models.ItemStencil

class ItemStencilDiffCallback: DiffUtil.ItemCallback<ItemStencil>() {

    override fun areItemsTheSame(oldItem: ItemStencil, newItem: ItemStencil): Boolean {
        return  oldItem.Cur_ID == newItem.Cur_ID
    }

    override fun areContentsTheSame(oldItem: ItemStencil, newItem: ItemStencil): Boolean {
        return oldItem == newItem
    }

    @Nullable
    @Override
    override fun getChangePayload(oldItem: ItemStencil, newItem: ItemStencil): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}