package com.service.bulbacash.presentation.ui.course

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseFragmentBinding
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.presentation.ui.course.adapter.CourseAdapter
import com.service.bulbacash.presentation.ui.course.adapter.CourseListener
import com.service.bulbacash.presentation.ui.graph.GraphFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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
            lifecycleScope.launchWhenCreated {
                viewModel.buckets.collect {
                    adapter?.submitList(it)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun clickItemCourseDate(bucket: BucketRate) {
        val date: Calendar = Calendar.getInstance()
        val picker = DatePickerDialog(
            requireContext(), { _, year, month, day ->
                viewModel.getItemCourseDate(bucket = bucket, onDate = "${year}-${month+1}-${day}")
            },
            date.get(Calendar.YEAR),
            date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH),
        )
        picker.datePicker.maxDate = System.currentTimeMillis()
        picker.show()
    }

    override fun clickItemCourseGraph(bucket: BucketRate) {
        findNavController().navigate(
           CourseFragmentDirections.actionCourseFragmentToGraphFragment()
        )
    }

}