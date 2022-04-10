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
            // TODO time
            listener.clickItemCourseDate(bucket = bucket, "")
        }

        binding.buttonGraphics.setOnClickListener {
            listener.clickItemCourseGraph(bucket = bucket)
        }

        binding.apply {
            firstCoefficientBy.text = bucket.firstElement?.Cur_OfficialRate.toString()
            secondCoefficientBy.text  = bucket.secondElement?.Cur_OfficialRate.toString()
            firstElement.text = "${bucket.firstElement?.Cur_Scale}  ${bucket.firstElement?.Cur_Name}"
            secondElement.text ="${bucket.secondElement?.Cur_Scale}  ${bucket.secondElement?.Cur_Name}"
        }

    }

}