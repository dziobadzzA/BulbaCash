package com.service.bulbacash.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TemplateEqualsValue {

    fun templateReturnMaxValue(x: Double, y: Double): Double {
        return if (x > y) {
            x
        } else if (x < y){
            y
        } else {
            x
        }
    }

    @Provides
    fun provideTemplateEqualsValue(): TemplateEqualsValue = TemplateEqualsValue

}
