package com.service.bulbacash.presentation.ui.graph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jjoe64.graphview.series.LineGraphSeries
import com.service.bulbacash.R
import com.service.bulbacash.databinding.CourseGraphLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

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

        binding?.apply {

            val points =  LineGraphSeries(
                viewModel.convertRateShortToPointList(
                    viewModel.returnListPoint(line = line)).toTypedArray()
            )
            //graph.removeAllSeries()
            setSettingsLine()
            graph.addSeries(points)

        }
    }

    private fun setSettingsLine() {
        setSettingLineX(viewModel.returnMaxDay())
        setSettingLineY(viewModel.returnMaxValue())
    }

    private fun setSettingLineX(maxDay: Double) {
        binding?.apply {
            graph.viewport.isXAxisBoundsManual = true
            graph.viewport.setMinX(0.0)
            graph.viewport.setMaxX(maxDay)
        }
    }

    private fun setSettingLineY(maxValue: Double) {
        binding?.apply {
            graph.viewport.isYAxisBoundsManual = true
            graph.viewport.setMinY(0.0)
            graph.viewport.setMaxY(maxValue)
        }
    }

}