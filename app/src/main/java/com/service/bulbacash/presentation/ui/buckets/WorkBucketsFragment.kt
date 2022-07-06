package com.service.bulbacash.presentation.ui.buckets

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.service.bulbacash.R
import com.service.bulbacash.databinding.WorkBucketsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkBucketsFragment: Fragment(R.layout.work_buckets_fragment){

    private var binding: WorkBucketsFragmentBinding? = null
    private val viewModel: WorkBucketsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WorkBucketsFragmentBinding.bind(view)


        binding?.apply {

            btnAddBucket.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    if (viewModel.addBucket(
                            firstID=spinnerFirst.selectedItemId,
                            secondID = spinnerSecond.selectedItemId)
                    )
                        Toast.makeText(requireContext(), "Good add bucket", Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(requireContext(), "Not add bucket", Toast.LENGTH_LONG).show()
                }
            }

            swipeRefreshLayout.setOnRefreshListener {
                viewModel.getNewPartToBuckets()
                swipeRefreshLayout.isRefreshing = false
            }

            spinnerFirst.onItemSelectedListener = viewModel.mapAdapterCountries
                .getListenerToSpinner(imageView = imageFirst)

            spinnerSecond.onItemSelectedListener = viewModel.mapAdapterCountries
                .getListenerToSpinner(imageView = imageSecond)

        }

        lifecycleScope.launchWhenCreated {
            viewModel.list.collect {
                if (it.isNotEmpty()) {
                    addItemsToList(
                        list = viewModel.mapAdapterCountries.getListText(),
                        firstImage = viewModel.mapAdapterCountries.getListWithIcon(it[0]),
                        secondImage = viewModel.mapAdapterCountries.getListWithIcon(it[0])
                    )
                }
            }
        }

        viewModel.getListForSpinner()

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