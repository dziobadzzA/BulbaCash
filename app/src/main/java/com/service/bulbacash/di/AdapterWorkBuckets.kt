package com.service.bulbacash.di

import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import com.service.bulbacash.presentation.ui.buckets.WorkBucketsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterWorkBuckets {

    fun getAdapterWorkBuckets(imageView: ImageView, viewModel: WorkBucketsViewModel) = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(adapterView: AdapterView<*>?, view: View,
            i: Int, l: Long) {
            imageView.setImageResource(viewModel.getImageIcon(viewModel.list.value[i]))
        }

        override fun onNothingSelected(adapterView: AdapterView<*>?) {
            return
        }

    }

    @Provides
    fun provideAdapterWorkBuckets(): AdapterWorkBuckets = AdapterWorkBuckets

}