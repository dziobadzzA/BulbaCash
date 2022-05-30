package com.service.bulbacash.presentation.ui.course.adapter

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.service.bulbacash.domain.models.BucketRate

class CourseDiffCallback: DiffUtil.ItemCallback<BucketRate>() {

    override fun areItemsTheSame(oldItem: BucketRate, newItem: BucketRate): Boolean {
        return  oldItem.ID == newItem.ID
    }

    override fun areContentsTheSame(oldItem: BucketRate, newItem: BucketRate): Boolean {
        return oldItem == newItem
    }

    @Nullable
    @Override
    override fun getChangePayload(oldItem: BucketRate, newItem: BucketRate): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}