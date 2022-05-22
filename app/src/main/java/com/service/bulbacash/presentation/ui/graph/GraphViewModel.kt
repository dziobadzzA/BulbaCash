package com.service.bulbacash.presentation.ui.graph

import android.content.Context
import com.jjoe64.graphview.series.DataPoint
import androidx.lifecycle.ViewModel
import com.service.bulbacash.domain.models.RateShort
import com.service.bulbacash.domain.usecases.CoursePeriodUseCase
import com.service.bulbacash.di.DatePeriod
import com.service.bulbacash.di.TemplateEqualsValue
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val coursePeriodUseCase: CoursePeriodUseCase,
    private val datePeriod: DatePeriod,
    private val templateEqualsValue: TemplateEqualsValue
): ViewModel() {

    private var ID = MutableStateFlow<Long?>(null)
    private var startTime: String? = null
    private var endTime: String? = null

    private var _listRateShortX = MutableStateFlow(listOf<RateShort>())
    val listRateShortX = _listRateShortX.asStateFlow()

    private var _listRateShortY = MutableStateFlow(listOf<RateShort>())
    val listRateShortY = _listRateShortY.asStateFlow()

    fun getIDBuckets(id: Long) {
        ID.value = id
    }

    fun setStartAndEndDatePeriod(
        yearStart: Int, monthStart: Int, dayStart: Int, yearEnd: Int,
        monthEnd: Int, dayEnd: Int
    ) {
        startTime = datePeriod.setDatePeriod(year = yearStart, month = monthStart, day = dayStart)
        endTime = datePeriod.setDatePeriod(year = yearEnd, month = monthEnd, day = dayEnd)
    }

    private fun checkList(x: Int, y: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            _listRateShortX.value = coursePeriodUseCase.invoke(
                id = x,
                onStartDate = startTime ?: "",
                onEndDate = endTime ?: ""
            )
            _listRateShortY.value = coursePeriodUseCase.invoke(
                id = y,
                onStartDate = startTime ?: "",
                onEndDate = endTime ?: ""
            )
        }
    }

    fun checkPoint() {
        checkList(431, 451)
    }

    fun convertRateShortToPointList(list: List<RateShort>): List<DataPoint> {
        val arrayList = mutableListOf<DataPoint>()
        if (list.isNotEmpty()) {
            for (i in list.indices)
                arrayList.add(DataPoint(i.toDouble(), list[i].Cur_OfficialRate))
        }
        return arrayList.toList()
    }

    fun checkListXY(line: CheckLine): Boolean {
        return when (line) {
            CheckLine.X -> listRateShortX.value.isNotEmpty()
            CheckLine.Y -> listRateShortY.value.isNotEmpty()
        }
    }

    fun returnListPoint(line: CheckLine): List<RateShort> {
        return when (line) {
            CheckLine.X -> listRateShortX.value
            CheckLine.Y -> listRateShortY.value
        }
    }

    fun returnMaxDay(): Double {
        val x = listRateShortX.value.size
        val y = listRateShortY.value.size
        return templateEqualsValue.templateReturnMaxValue(x = x.toDouble(), y = y.toDouble())
    }

    fun returnMaxValue(): Double {
        val x: RateShort = Collections.max(listRateShortX.value)
        val y: RateShort = Collections.max(listRateShortY.value)
        return templateEqualsValue.templateReturnMaxValue(
            x = x.Cur_OfficialRate,
            y = y.Cur_OfficialRate
        ) + 1
    }

    fun returnMinValue(): Double {
        val x: RateShort = Collections.min(listRateShortX.value)
        val y: RateShort = Collections.min(listRateShortY.value)
        return templateEqualsValue.templateReturnMaxValue(
            x = x.Cur_OfficialRate,
            y = y.Cur_OfficialRate
        )
    }

}