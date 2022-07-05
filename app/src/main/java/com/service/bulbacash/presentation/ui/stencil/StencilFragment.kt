package com.service.bulbacash.presentation.ui.stencil

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.service.bulbacash.R
import com.service.bulbacash.databinding.StencilFragmentBinding
import com.service.bulbacash.presentation.ui.course.CourseFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StencilFragment: Fragment(R.layout.stencil_fragment) {

    private var binding: StencilFragmentBinding? = null
    // private val viewModel:  by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = StencilFragmentBinding.bind(view)
        binding?.apply {
            floatingActionButton.setOnClickListener {
                findNavController().navigate(
                    StencilFragmentDirections.actionNavTemplatesToItemStencilFragment()
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}