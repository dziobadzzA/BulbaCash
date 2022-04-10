package com.service.bulbacash.presentation.ui.course.adapter

import androidx.recyclerview.widget.RecyclerView
import com.service.bulbacash.databinding.BucketBinding
import com.service.bulbacash.domain.models.BucketRate

class CourseViewHolder(
    private val binding: BucketBinding,
    private val listener: CourseListener
):RecyclerView.ViewHolder(binding.root) {

    fun bind(bucket: BucketRate) {

        binding.buttonDatetime.setOnClickListener {
            listener.clickItemCourseDate(bucket = bucket)
        }

        binding.buttonGraphics.setOnClickListener {
            listener.clickItemCourseGraph(bucket = bucket)
        }

    }

}