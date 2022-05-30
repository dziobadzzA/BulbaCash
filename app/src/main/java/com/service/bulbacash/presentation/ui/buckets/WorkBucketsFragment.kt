package com.service.bulbacash.presentation.ui.buckets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.service.bulbacash.R
import com.service.bulbacash.databinding.WorkBucketsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkBucketsFragment: Fragment(R.layout.work_buckets_fragment){

    private var binding: WorkBucketsFragmentBinding? = null
    private val viewModel: WorkBucketsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WorkBucketsFragmentBinding.bind(view)


        binding?.apply {

        }

        viewModel.getCurrency()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}