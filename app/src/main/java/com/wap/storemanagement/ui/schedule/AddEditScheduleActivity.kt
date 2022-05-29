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
        setSaveButton()
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
                schedules = scheduleViewModel.currentDataSchedules.value ?: emptyList()
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
                    addSchedule = { startHour, startMinute, endHour, endMinute ->
                        scheduleViewModel.addDateSchedule(startHour, startMinute, endHour, endMinute)
                        scheduleViewModel.closeDialog()
                    }
                )
            }
        }
    }

    private fun setSaveButton() {
        binding.composeScheduleSaveButton.setContent {
            SaveButton { scheduleViewModel.saveButtonEvent() }
        }
    }
}
