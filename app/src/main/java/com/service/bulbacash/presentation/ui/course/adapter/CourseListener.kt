package com.service.bulbacash.presentation.ui.course.adapter

import com.service.bulbacash.domain.models.BucketRate

interface CourseListener {
    fun clickItemCourseDate(bucket: BucketRate, onDate:String)
    fun clickItemCourseGraph(bucket: BucketRate)
}