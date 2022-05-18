package com.service.bulbacash.presentation.utils

import java.lang.Exception

object DatePeriod  {

    fun setDatePeriod(year:Int, month: Int, day: Int):String  = "${year}-${month}-${day}"

    fun getPartOfDate(string: String, part: Int):Int? {
        return try {
            string.split('-')[part].toInt()
        } catch (e:Exception) {
            null
        }
    }

}