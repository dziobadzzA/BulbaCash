package com.service.bulbacash.data.utils

import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

object Helper {
    val format: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    const val intervalDay = 86400000L
}