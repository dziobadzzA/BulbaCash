package com.service.bulbacash.presentation.ui.course.adapter

import com.service.bulbacash.domain.models.BucketRate

interface CourseListener {
    fun clickItemCourseDate(bucket: BucketRate)
    fun clickItemCourseGraph(bucket: BucketRate)
    fun deleteBucket(ID: Int)
}