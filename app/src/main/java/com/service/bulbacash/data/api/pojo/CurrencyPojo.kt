package com.service.bulbacash.data.api.pojo

import com.squareup.moshi.Json

data class CurrencyPojo(
    @Json(name = "Cur_ID") val Cur_ID: Int,
    @Json(name = "Cur_ParentID") val Cur_ParentID: Int,
    @Json(name = "Cur_Code") val Cur_Code: String,
    @Json(name = "Cur_Abbreviation") val Cur_Abbreviation: String,
    @Json(name = "Cur_Name") val Cur_Name: String,
    @Json(name = "Cur_Name_Bel") val Cur_Name_Bel: String,
    @Json(name = "Cur_Name_Eng") val Cur_Name_Eng: String,
    @Json(name = "Cur_QuotName") val Cur_QuotName: String,
    @Json(name = "Cur_QuotName_Bel") val Cur_QuotName_Bel: String,
    @Json(name = "Cur_QuotName_Eng") val Cur_QuotName_Eng: String,
    @Json(name = "Cur_NameMulti") val Cur_NameMulti: String,
    @Json(name = "Cur_Name_BelMulti") val Cur_Name_BelMulti: String,
    @Json(name = "Cur_Name_EngMulti") val Cur_Name_EngMulti: String,
    @Json(name = "Cur_Scale") val Cur_Scale: Int,
    @Json(name = "Cur_Periodicity") val Cur_Periodicity: Boolean,
    @Json(name = "Cur_DateStart") val Cur_DateStart: String,
    @Json(name = "Cur_DateEnd") val Cur_DateEnd: String
)
