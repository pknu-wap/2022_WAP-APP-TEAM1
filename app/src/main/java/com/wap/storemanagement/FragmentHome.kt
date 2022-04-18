package com.wap.storemanagement

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.wap.base.BaseFragment
import com.wap.storemanagement.databinding.FragmentHomeBinding
import com.wap.storemanagement.ui.home.ScheduleViewModel
import com.wap.storemanagement.ui.home.composeview.OffMemberView
import com.wap.storemanagement.ui.home.composeview.ScheduleCards
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: ScheduleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeHomeOffMember.setContent {
            OffMemberView()
        }

        setScheduleView()

        setDateClickListener()
    }

    private fun setScheduleView() {
        viewModel.schedules.observe(requireActivity()) { schedules ->
            binding.composeHomeSchedule.setContent {
                ScheduleCards(schedules = schedules)
            }
        }
    }

    private fun setDateClickListener() {
        binding.calendarHomeCalendar.setOnDateChangedListener{ widget, date, selected ->
            if(selected)
                viewModel.fetchSchedules(date)
        }
    }
}