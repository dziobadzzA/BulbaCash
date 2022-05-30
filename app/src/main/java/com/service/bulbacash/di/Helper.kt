package com.service.bulbacash.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

@Module
@InstallIn(SingletonComponent::class)
object Helper {

    val format: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    const val intervalDay = 86400000L

    fun currentDate(): String {
        val currentDate = DateTime.now()
        return "${currentDate.year}-${currentDate.monthOfYear}-${currentDate.dayOfMonth}T00:00:00"
    }

    fun parseCurrentDate(time:String): String {
        val currentDate = time.split('-')
        return if (currentDate.size == 3)
            "${currentDate[0]}-${currentDate[1]}-${currentDate[2]}T00:00:00"
        else
            ""
    }

    @Provides
    fun provideHelper(): Helper = Helper

}

