package com.service.bulbacash.presentation.ui.course

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment: Fragment(R.layout.course_fragment) {

    private var binding: CourseFragmentBinding? = null

    private val viewModel: CourseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CourseFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}