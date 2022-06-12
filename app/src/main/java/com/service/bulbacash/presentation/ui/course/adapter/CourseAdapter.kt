package com.service.bulbacash.presentation.ui.course.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.service.bulbacash.databinding.BucketBinding
import com.service.bulbacash.di.MapperCountries
import com.service.bulbacash.domain.models.BucketRate

class CourseAdapter(private val listener: CourseListener,
                    private val mapMapperCountries: MapperCountries):
    ListAdapter<BucketRate, CourseViewHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BucketBinding.inflate(layoutInflater, parent, false)
        return CourseViewHolder(binding, listener, mapMapperCountries)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(holder.layoutPosition))
    }
}