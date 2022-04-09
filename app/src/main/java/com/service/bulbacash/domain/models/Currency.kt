package com.service.bulbacash.domain.models


data class Currency(
    val Cur_ID: Int,
    val Cur_ParentID: Int,
    val Cur_Code: String,
    val Cur_Abbreviation: String,
    val Cur_Name: String,
    val Cur_QuotName: String,
    val Cur_NameMulti: String,
    val Cur_Scale: Int,
    val Cur_Periodicity: Boolean,
    val Cur_DateStart: String,
    val Is_Cur_DateEnd: Boolean
)
