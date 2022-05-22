package com.service.bulbacash.presentation.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.lang.Exception

@Module
@InstallIn(SingletonComponent::class)
object DatePeriod  {

    fun setDatePeriod(year:Int, month: Int, day: Int):String  = "${year}-${month}-${day}"

    fun getPartOfDate(string: String, part: Int):Int? {
        return try {
            string.split('-')[part].toInt()
        } catch (e:Exception) {
            null
        }
    }

    @Provides
    fun provideDatePeriod(): DatePeriod = DatePeriod
}