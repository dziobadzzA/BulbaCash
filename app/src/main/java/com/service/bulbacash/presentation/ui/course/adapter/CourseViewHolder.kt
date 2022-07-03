package com.service.bulbacash.presentation.ui.course.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.service.bulbacash.R
import com.service.bulbacash.databinding.BucketBinding
import com.service.bulbacash.di.MapperCountries
import com.service.bulbacash.domain.models.BucketRate
import javax.inject.Inject

class CourseViewHolder @Inject constructor(
    private val binding: BucketBinding,
    private val listener: CourseListener,
    private val mapMapperCountries: MapperCountries
):RecyclerView.ViewHolder(binding.root) {

    fun bind(bucket: BucketRate) {

        binding.buttonDatetime.setOnClickListener {
            listener.clickItemCourseDate(bucket = bucket)
        }

        binding.buttonGraphics.setOnClickListener {
            listener.clickItemCourseGraph(bucket = bucket)
        }

        binding.apply {
            firstCoefficientBy.text = bucket.firstElement?.Cur_OfficialRate.toString()
            secondCoefficientBy.text  = bucket.secondElement?.Cur_OfficialRate.toString()
            firstElement.text = "${bucket.firstElement?.Cur_Scale}  ${bucket.firstElement?.Cur_Name}"
            secondElement.text ="${bucket.secondElement?.Cur_Scale}  ${bucket.secondElement?.Cur_Name}"
            coefficient.text = "%.3f".format(bucket.coeffiecient)
            bannerCourse(bucket.typeFirst, firstLine)
            bannerCourse(bucket.typeFirst, secondLine)
            bucket.firstElement?.Cur_ID?.let { mapMapperCountries.getIconCountries(cur_ID= it) }
                ?.let { firstBanner.setImageResource(it) }
            bucket.secondElement?.Cur_ID?.let { mapMapperCountries.getIconCountries(cur_ID = it) }
                ?.let { imageView.setImageResource(it) }
        }
    }

    private fun bannerCourse(id: Int, view: View) {
        when(id) {
            0 -> view.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            1 -> view.setBackgroundResource(R.drawable.ic_baseline_horizontal_rule_24)
            2 -> view.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
        }
    }

}