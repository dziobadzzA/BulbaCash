package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.api.pojo.RatePojo
import com.service.bulbacash.data.api.pojo.RateShortPojo
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.models.RateShort
import com.service.bulbacash.domain.utill.Mapper

class RatePojoToRate : Mapper<RatePojo, Rate> {
    override fun map(from: RatePojo): Rate {
        return Rate(
            Cur_ID = from.Cur_ID,
            Date = from.Date,
            Cur_Abbreviation = from.Cur_Abbreviation,
            Cur_Scale = from.Cur_Scale,
            Cur_Name = from.Cur_Name,
            Cur_OfficialRate = from.Cur_OfficialRate
        )
    }
}

class RateShortPojoToRateShort : Mapper<RateShortPojo, RateShort> {
    override fun map(from: RateShortPojo): RateShort {
        return RateShort(
            Cur_ID = from.Cur_ID,
            Date = from.Date,
            Cur_OfficialRate = from.Cur_OfficialRate
        )
    }
}