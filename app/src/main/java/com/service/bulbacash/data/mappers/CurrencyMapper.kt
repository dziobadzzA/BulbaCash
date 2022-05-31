package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.api.pojo.CurrencyPojo
import com.service.bulbacash.data.db.entity.CurrencyEntity
import com.service.bulbacash.di.Helper
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.utill.Mapper

class CurrencyPojoToCurrency(private val mapHelper: Helper) : Mapper<CurrencyPojo, Currency> {
    override fun map(from: CurrencyPojo): Currency {

        val isCurDateEnd = (System.currentTimeMillis() - mapHelper.parseCurrencyDate(from.Cur_DateEnd).millis
                < mapHelper.intervalDay)

        return Currency(
            Cur_ID = from.Cur_ID,
            Cur_ParentID = from.Cur_ParentID,
            Cur_Code = from.Cur_Code,
            Cur_Abbreviation = from.Cur_Abbreviation,
            Cur_Name = from.Cur_Name,
            Cur_QuotName = from.Cur_QuotName,
            Cur_NameMulti = from.Cur_NameMulti,
            Cur_Scale = from.Cur_Scale,
            Cur_Periodicity = from.Cur_Periodicity,
            Cur_DateStart = from.Cur_DateStart,
            Is_Cur_DateEnd = isCurDateEnd
        )
    }
}

class CurrencyEntityToCurrency: Mapper<CurrencyEntity, Currency> {

    override fun map(from: CurrencyEntity): Currency {

        return Currency(
            Cur_ID = from.Cur_ID,
            Cur_ParentID = from.Cur_ParentID,
            Cur_Code = from.Cur_Code,
            Cur_Abbreviation = from.Cur_Abbreviation,
            Cur_Name = from.Cur_Name,
            Cur_QuotName = from.Cur_QuotName,
            Cur_NameMulti = from.Cur_NameMulti,
            Cur_Scale = from.Cur_Scale,
            Cur_Periodicity = from.Cur_Periodicity,
            Cur_DateStart = from.Cur_DateStart,
            Is_Cur_DateEnd = from.Is_Cur_DateEnd
        )

    }
}