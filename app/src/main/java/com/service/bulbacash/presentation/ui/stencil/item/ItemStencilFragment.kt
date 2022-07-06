package com.service.bulbacash.presentation.ui.stencil.item

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.service.bulbacash.R
import com.service.bulbacash.databinding.ItemsStencilLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemStencilFragment: Fragment(R.layout.items_stencil_layout) {

    private var binding: ItemsStencilLayoutBinding? = null
    private val viewModel: ItemStencilViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ItemsStencilLayoutBinding.bind(view)

        binding?.apply {
            valEd.onItemSelectedListener = viewModel.mapAdapterCountries
                .getListenerToSpinner(imageView = imageIcon)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.list.collect {
                if (it.isNotEmpty()) {
                    addItemsToList(
                        list = viewModel.mapAdapterCountries.getListText(),
                        startImage = viewModel.mapAdapterCountries.getListWithIcon(it[0])
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

    private fun addItemsToList(list: List<String>, startImage: Int) {
        binding?.apply {
            val adapter = ArrayAdapter(requireContext().applicationContext,
                android.R.layout.simple_spinner_item, list)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            valEd.adapter = adapter
            imageIcon.setImageResource(startImage)
        }
    }

}