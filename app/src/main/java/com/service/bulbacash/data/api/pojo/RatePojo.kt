package com.service.bulbacash.data.api.pojo

import com.squareup.moshi.Json

data class RatePojo(
    @Json(name = "Cur_ID") val Cur_ID: Int,
    @Json(name = "Date") val Date: String,
    @Json(name = "Cur_Abbreviation") val Cur_Abbreviation: String,
    @Json(name = "Cur_Scale") val Cur_Scale: Int,
    @Json(name = "Cur_Name") val Cur_Name: String,
    @Json(name = "Cur_OfficialRate") val Cur_OfficialRate: Double
)