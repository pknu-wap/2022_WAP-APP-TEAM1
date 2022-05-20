package com.wap.storemanagement.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivityScheduleBinding
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.home.ScheduleViewModel
import com.wap.storemanagement.ui.schedule.composeview.AddEditScheduleTopAppBar
import com.wap.storemanagement.ui.schedule.composeview.CheckDateView
import com.wap.storemanagement.ui.schedule.composeview.SaveButton
import com.wap.storemanagement.ui.schedule.composeview.ScheduleView
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class AddEditScheduleActivity : BaseActivity<ActivityScheduleBinding>(R.layout.activity_schedule) {

    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.composeScheduleTopAppbar.setContent { AddEditScheduleTopAppBar() }
        setCheckDateView()
        setScrollScheduleView()
        binding.composeScheduleSaveButton.setContent { SaveButton() }
    }

    private fun setCheckDateView() {
        binding.composeScheduleCheckDate.setContent {
            CheckDateView(selectDay = scheduleViewModel.currentDate)
        }
    }

    private fun setScrollScheduleView() {
        binding.composeScheduleScrollSchedule.setContent {
            // ScheduleView(schedules = FakeFactory.createSchedules())
            ScheduleView(schedules = scheduleViewModel.getCurrentDateSchedules())
        }
    }
}
