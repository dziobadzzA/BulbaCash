package com.service.bulbacash.presentation.ui.course

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseFragmentBinding
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.presentation.ui.course.adapter.CourseAdapter
import com.service.bulbacash.presentation.ui.course.adapter.CourseListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment: Fragment(R.layout.course_fragment), CourseListener {

    private var binding: CourseFragmentBinding? = null

    private val viewModel: CourseViewModel by viewModels()
    private var adapter: CourseAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CourseFragmentBinding.bind(view)
        adapter = CourseAdapter(this)

        binding?.apply {
            listBucket.adapter = adapter
            viewModel.getAllCourseToday()
        }

        lifecycleScope.launchWhenCreated {
            viewModel.buckets.collect {
                adapter?.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun clickItemCourseDate(bucket: BucketRate, onDate: String) {
        viewModel.getItemCourseDate(bucket = bucket, onDate = onDate)
    }

    override fun clickItemCourseGraph(bucket: BucketRate) {
       // TODO get graph
    }
}