package com.service.bulbacash.domain.models

import com.service.bulbacash.di.TemplateEqualsValue

data class RateShort(
    val Cur_ID: Int,
    val Date: String,
    val Cur_OfficialRate: Double,
    val mapTemplateEqualsValue: TemplateEqualsValue
) : Comparable<RateShort> {

    override fun compareTo(other: RateShort): Int {
        return mapTemplateEqualsValue.templateReturnMaxValue(x=this.Cur_OfficialRate,
            y=other.Cur_OfficialRate).toInt()
    }

}
