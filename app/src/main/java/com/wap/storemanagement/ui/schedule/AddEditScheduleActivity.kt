package com.wap.storemanagement.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivityScheduleBinding
import com.wap.storemanagement.ui.home.ScheduleViewModel
import com.wap.storemanagement.ui.schedule.composeview.*
import com.wap.storemanagement.ui.schedule.composeview.timepicker.Empty
import com.wap.storemanagement.ui.schedule.composeview.timepicker.TimePickerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class AddEditScheduleActivity : BaseActivity<ActivityScheduleBinding>(R.layout.activity_schedule) {

    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTopAppBar()
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
                schedules = scheduleViewModel.currentDataSchedules.value ?: emptyList(),
                onClickAdd = { scheduleViewModel.showDialog(TimePickerState.Add) },
                onClickSchedule = { scheduleViewModel.showDialog(TimePickerState.Edit) },
                checkedState = { checkedState, index -> changeCheckState(checkedState, index) }
            )
        }
    }

    private fun setTopAppBar() {
        scheduleViewModel.checkedState.observe(this) { checkedState ->
            when (checkedState) {
                0 -> scheduleViewModel.offDeleteButton()
                else -> scheduleViewModel.onDeleteButton()
            }
            binding.composeScheduleTopAppbar.setContent {
                AddEditScheduleTopAppBar(
                    deleteButtonState = scheduleViewModel.addEditDeleteButtonState,
                    onClickDeleteButton = { scheduleViewModel.deleteCheckedSchedules() }
                )
            }
        }
    }

    private fun fetchScrollScheduleView() {
        scheduleViewModel.currentDataSchedules.observe(this) { schedules ->
            binding.composeScheduleScrollSchedule.setContent {
                ScheduleView(
                    schedules = schedules,
                    onClickAdd = { scheduleViewModel.showDialog(TimePickerState.Add) },
                    onClickSchedule = { schedule ->
                        scheduleViewModel.showDialog(TimePickerState.Edit)
                        scheduleViewModel.getSchedule(schedule)
                    },
                    checkedState = { checkedState, index -> changeCheckState(checkedState, index) }
                )
            }
        }
    }

    private fun setTimePickerView() {
        scheduleViewModel.timePickerState.observe(this) { state ->
            binding.composeScheduleTimePicker.setContent {
                when (state) {
                    TimePickerState.Close -> Empty()
                    else -> AddEditTimePickerView(state)
                }
            }
        }
    }

    @Composable
    private fun AddEditTimePickerView(state: TimePickerState) {
        TimePickerView(
            onDismiss = { scheduleViewModel.closeDialog() },
            confirmEvent = { startHour, startMinute, endHour, endMinute ->
                setConfirmEvent(state, startHour, startMinute, endHour, endMinute)
                scheduleViewModel.closeDialog()
            }
        )
    }

    private fun setConfirmEvent(
        state: TimePickerState,
        startHour: Int,
        startMinute: Int,
        endHour: Int,
        endMinute: Int
    ) {
        when (state) {
            TimePickerState.Add -> scheduleViewModel.addDateSchedule(startHour, startMinute, endHour, endMinute)
            TimePickerState.Edit -> scheduleViewModel.editDateSchedule(startHour, startMinute, endHour, endMinute)
            else -> error("무슨 일이지?")
        }
    }

    private fun setSaveButton() {
        binding.composeScheduleSaveButton.setContent {
            SaveButton { scheduleViewModel.saveButtonEvent() }
        }
    }

    private fun changeCheckState(checkedState: CheckBoxState, index: Int) {
        when (checkedState) {
            CheckBoxState.ON -> scheduleViewModel.onChecked(index)
            else -> scheduleViewModel.unChecked(index)
        }
    }
}
