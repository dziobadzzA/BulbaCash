package com.service.bulbacash.data.api.pojo

import com.squareup.moshi.Json

data class RateShortPojo(
    @Json(name = "Cur_ID") val Cur_ID: Int,
    @Json(name = "Date") val Date: String,
    @Json(name = "Cur_OfficialRate") val Cur_OfficialRate: Double
)