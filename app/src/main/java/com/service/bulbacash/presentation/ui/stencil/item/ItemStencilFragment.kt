package com.service.bulbacash.presentation.ui.stencil.item

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}