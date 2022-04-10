package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.api.pojo.CurrencyPojo
import com.service.bulbacash.data.utils.Helper
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.utill.Mapper


class CurrencyPojoToCurrency : Mapper<CurrencyPojo, Currency> {
    override fun map(from: CurrencyPojo): Currency {

        val isCurDateEnd = (System.currentTimeMillis() - Helper.format.parseDateTime(from.Cur_DateEnd).millis
                < Helper.intervalDay)

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