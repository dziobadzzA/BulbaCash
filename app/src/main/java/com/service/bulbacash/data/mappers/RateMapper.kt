package com.service.bulbacash.data.mappers

import androidx.room.ColumnInfo
import com.service.bulbacash.data.api.pojo.RatePojo
import com.service.bulbacash.data.api.pojo.RateShortPojo
import com.service.bulbacash.data.db.entity.RateEntity
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.models.RateShort
import com.service.bulbacash.domain.utill.Mapper
import org.joda.time.DateTime

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

class RateEntityToRate: Mapper<RateEntity, Rate> {
    override fun map(from: RateEntity): Rate {
        return Rate(
            Date = DateTime.now().toString(),
            Cur_ID = from.Cur_ID,
            Cur_Abbreviation = from.Cur_Abbreviation,
            Cur_Scale = from.Cur_Scale,
            Cur_Name = from.Cur_Name,
            Cur_OfficialRate = from.Cur_OfficialRate
        )
    }
}