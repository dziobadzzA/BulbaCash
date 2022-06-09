package com.service.bulbacash.presentation.ui.buckets

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
            btnAddBucket.setOnClickListener {

            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.list.collect {
                if (it.isNotEmpty()) {
                    addItemsToList(
                        list = viewModel.getListTextCountries(),
                        firstImage = viewModel.getImageIcon(it[0]),
                        secondImage = viewModel.getImageIcon(it[0])
                    )
                }
            }
        }

        viewModel.getCurrency()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun addItemsToList(list: List<String>, firstImage: Int, secondImage:Int) {
        binding?.apply {
            val adapter = ArrayAdapter(requireContext().applicationContext,
                android.R.layout.simple_spinner_item, list)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerFirst.adapter = adapter
            spinnerSecond.adapter = adapter
            imageFirst.setImageResource(firstImage)
            imageSecond.setImageResource(secondImage)
        }
    }

}