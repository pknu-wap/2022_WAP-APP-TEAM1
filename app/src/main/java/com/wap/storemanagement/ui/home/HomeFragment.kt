package com.wap.storemanagement.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.wap.base.BaseFragment
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.FragmentHomeBinding
import com.wap.storemanagement.ui.home.composeview.OffMemberView
import com.wap.storemanagement.ui.home.composeview.ScheduleCards
import com.wap.storemanagement.ui.schedule.AddEditScheduleActivity
import dagger.hilt.android.AndroidEntryPoint

@RequiresApi(Build.VERSION_CODES.O)
@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

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
        val intent = Intent(context, AddEditScheduleActivity::class.java)

        viewModel.currentDataSchedules.observe(requireActivity()) { schedules ->
            binding.composeHomeSchedule.setContent {
                ScheduleCards(schedules = schedules) {
                    startActivity(intent)
                }
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