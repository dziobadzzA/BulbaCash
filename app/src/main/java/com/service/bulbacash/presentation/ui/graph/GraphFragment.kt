package com.service.bulbacash.presentation.ui.graph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseGraphLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphFragment: Fragment(R.layout.course_graph_layout) {

    private var binding: CourseGraphLayoutBinding? = null
    private val viewModel: GraphViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CourseGraphLayoutBinding.bind(view)

        binding?.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}