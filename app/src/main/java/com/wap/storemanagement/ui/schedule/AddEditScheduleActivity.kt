package com.wap.storemanagement.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivityScheduleBinding
import com.wap.storemanagement.ui.home.ScheduleViewModel
import com.wap.storemanagement.ui.schedule.composeview.*
import com.wap.storemanagement.ui.schedule.composeview.timepicker.TimePickerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class AddEditScheduleActivity : BaseActivity<ActivityScheduleBinding>(R.layout.activity_schedule) {

    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.composeScheduleTopAppbar.setContent { AddEditScheduleTopAppBar() }
        setCheckDateView()

        setScrollScheduleView()
        fetchScrollScheduleView()

        binding.composeScheduleSaveButton.setContent { SaveButton() }
        setTimePickerView()
    }

    private fun setCheckDateView() {
        binding.composeScheduleCheckDate.setContent {
            CheckDateView(selectDay = scheduleViewModel.currentDate)
        }
    }

    private fun setScrollScheduleView() {
        binding.composeScheduleScrollSchedule.setContent {
            // ScheduleView(schedules = FakeFactory.createSchedules())
            ScheduleView(
                schedules = scheduleViewModel.getCurrentDateSchedules()
            ) {
                scheduleViewModel.showDialog()
            }
        }
    }

    private fun fetchScrollScheduleView() {
        scheduleViewModel.currentDataSchedules.observe(this) { schedules ->
            binding.composeScheduleScrollSchedule.setContent {
                ScheduleView(
                    schedules = schedules
                ) {
                    scheduleViewModel.showDialog()
                }
            }
        }
    }

    private fun setTimePickerView() {
        scheduleViewModel.isShowTimePicker.observe(this) { isShowTimePicker ->
            binding.composeScheduleTimePicker.setContent {
                TimePickerView(
                    showDialog = isShowTimePicker,
                    onDismiss = { scheduleViewModel.closeDialog() },
                    addSchedule = { hour, minute ->
                        scheduleViewModel.addDateSchedule(hour, minute)
                        scheduleViewModel.closeDialog()
                    }
                )
            }
        }
    }
}
