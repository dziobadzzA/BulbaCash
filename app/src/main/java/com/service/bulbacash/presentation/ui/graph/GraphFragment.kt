package com.service.bulbacash.presentation.ui.graph

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseGraphLayoutBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class GraphFragment: Fragment(R.layout.course_graph_layout) {

    private var binding: CourseGraphLayoutBinding? = null
    private val viewModel: GraphViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CourseGraphLayoutBinding.bind(view)

        lifecycleScope.launchWhenCreated {
            val bundle = GraphFragmentArgs.fromBundle(requireArguments())
            viewModel.getIDBuckets(bundle.idBucket)
        }

        binding?.apply {

            viewModel.setStartAndEndDatePeriod(
                yearStart = startTime.year,
                monthStart = startTime.month,
                dayStart = startTime.dayOfMonth - 1,
                yearEnd = endTime.year,
                monthEnd = endTime.month,
                dayEnd = endTime.dayOfMonth
            )
            viewModel.checkPoint()

            startTime.init(startTime.year, startTime.month, startTime.dayOfMonth-1
            ) { _, year, monthOfYear, dayOfMonth ->
                viewModel.setStartAndEndDatePeriod(
                    yearStart = year,
                    monthStart = monthOfYear,
                    dayStart = dayOfMonth,
                    yearEnd = endTime.year,
                    monthEnd = endTime.month,
                    dayEnd = endTime.dayOfMonth
                )
                viewModel.checkPoint()
            }

            endTime.init(endTime.year, endTime.month, endTime.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                viewModel.setStartAndEndDatePeriod(
                    yearStart = startTime.year,
                    monthStart = startTime.month,
                    dayStart = startTime.dayOfMonth,
                    yearEnd = year,
                    monthEnd = monthOfYear,
                    dayEnd = dayOfMonth
                )
                viewModel.checkPoint()
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.listRateShortX.collect {
                checkAndDrawPoints(line = CheckLine.X)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.listRateShortY.collect {
               checkAndDrawPoints(line = CheckLine.Y)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun checkAndDrawPoints(line: CheckLine) {
        if (viewModel.checkListXY(line))
            drawPoints(line=line)
    }

    private fun drawPoints(line: CheckLine){

        with(Dispatchers.Main) {
            binding?.apply {

                val points =  LineGraphSeries(
                    viewModel.convertRateShortToPointList(
                        viewModel.returnListPoint(line = line)).toTypedArray()
                )
                //graph.removeAllSeries()
                setSettingsLine()
                when(line) {
                    CheckLine.X -> {
                        setStyleX(series = points)
                    }
                    CheckLine.Y -> {
                        setStyleY(series = points)
                    }
                }
                graph.addSeries(points)

            }
        }

    }

    private fun setSettingsLine() {
        setSettingLineX(viewModel.returnMaxDay())
        setSettingLineY(viewModel.returnMinValue(), viewModel.returnMaxValue())
    }

    private fun setSettingLineX(maxDay: Double) {
        binding?.apply {
            graph.viewport.isXAxisBoundsManual = true
            graph.viewport.setMinX(0.0)
            graph.viewport.setMaxX(maxDay)
        }
    }

    private fun setSettingLineY(minValue: Double, maxValue: Double) {
        binding?.apply {
            graph.viewport.isYAxisBoundsManual = true
            graph.viewport.setMinY(minValue)
            graph.viewport.setMaxY(maxValue)
        }
    }

    private fun setStyleX(series: LineGraphSeries<DataPoint>) {
        series.color = Color.GREEN
        series.backgroundColor = R.color.backX
        series.isDrawDataPoints = true
        series.dataPointsRadius = 2F
        series.thickness = 2
    }

    private fun setStyleY(series: LineGraphSeries<DataPoint>) {
        series.color = Color.RED
        series.backgroundColor = R.color.backY
        series.isDrawDataPoints = true
        series.dataPointsRadius = 2F
        series.thickness = 2
    }

}