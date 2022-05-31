package com.wap.storemanagement.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.data.repository.ScheduleRepository
import com.wap.domain.entity.Schedule
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.schedule.DeleteButtonState
import com.wap.storemanagement.ui.schedule.TimePickerState
import com.wap.storemanagement.utils.toDate
import com.wap.storemanagement.utils.toLocalDateTime
import com.wap.storemanagement.utils.toScheduleDate
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class ScheduleViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val scheduleRepository: ScheduleRepository
) : BaseViewModel(dispatcherProvider) {

    private var _checkedState: MutableLiveData<Int> = MutableLiveData(0)
    val checkedState: LiveData<Int> = _checkedState

    private var _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()

    private val _currentDateSchedules = MutableLiveData<List<Schedule>>()
    val currentDataSchedules: LiveData<List<Schedule>> = _currentDateSchedules

    var currentDate = scheduleRepository.currentDate
        private set

    private var _timePickerState = MutableLiveData(TimePickerState.Close)
    val timePickerState: LiveData<TimePickerState> = _timePickerState

    private var _addEditDeleteButtonState: DeleteButtonState = DeleteButtonState.OFF
    val addEditDeleteButtonState: DeleteButtonState get() = _addEditDeleteButtonState

    fun onDeleteButton() {
        _addEditDeleteButtonState = DeleteButtonState.ON
    }

    fun offDeleteButton() {
        _addEditDeleteButtonState = DeleteButtonState.OFF
    }

    fun onChecked (index: Int) {
        _checkedState.value = _checkedState.value?.plus(1)
        val onCheckedSchedule = _currentDateSchedules.value?.get(index)!!.copy(checked = true)
        _currentDateSchedules.value = _currentDateSchedules.value?.toMutableList().apply {
            this?.set(index, onCheckedSchedule)
        }
    }

    fun unChecked (index: Int) {
        _checkedState.value = _checkedState.value?.minus(1)
        val unCheckedSchedule = _currentDateSchedules.value?.get(index)!!.copy(checked = false)
        _currentDateSchedules.value = _currentDateSchedules.value?.toMutableList().apply {
            this?.set(index, unCheckedSchedule)
        }
    }

    init {
        setCurrentDateSchedules()
    }

    fun fetchSchedules(date: CalendarDay) {
        _schedules.value = FakeFactory.createSchedules()
        // _schedules.value = scheduleRepository.findSchedulesByStartTime(date.toLocalDateTime())

        _currentDateSchedules.value = _schedules.value?.filter { schedule -> isCurrentDateSchedule(date, schedule) } ?: emptyList()
        currentDate = date.toLocalDateTime()
    }

    private fun isCurrentDateSchedule(date: CalendarDay, schedule: Schedule) = date.toDate() == schedule.startTime.toScheduleDate()
    //FIXME : 캘린더 월이 1달씩 밀림   ex.May 5 클릭 -> Log : 4월 5일

    fun saveCurrentState() {
        saveCurrentDate()
        saveCurrentDateSchedules()
    }

    private fun saveCurrentDateSchedules() {
        scheduleRepository.saveCurrentDateSchedules(currentDataSchedules.value ?: emptyList())
    }

    private fun setCurrentDateSchedules() {
        _currentDateSchedules.value = scheduleRepository.currentDateSchedules
    }

    private fun saveCurrentDate() = scheduleRepository.saveCurrentDate(currentDate)

    fun saveButtonEvent() = scheduleRepository.saveViewModelToDB(_currentDateSchedules.value ?: emptyList())

    fun showDialog(option: TimePickerState) {
        _timePickerState.value = option
    }

    fun closeDialog() {
        _timePickerState.value = TimePickerState.Close
    }

    fun addDateSchedule(startHour: Int, startMinute: Int, endHour: Int, endMinute: Int) {
        val schedule = Schedule(
            scheduleId = -1L,
            startTime = LocalDateTime.of(
                currentDate.year,
                currentDate.month,
                currentDate.dayOfMonth,
                startHour,
                startMinute
            ),
            endTime = LocalDateTime.of(
                currentDate.year,
                currentDate.month,
                currentDate.dayOfMonth,
                endHour,
                endMinute
            ),
            color = "",
            recurWeek = null,
            checked = false,
            userId = 1L
        )
        _currentDateSchedules.value = _currentDateSchedules.value?.plus(schedule) ?: listOf(schedule)
    }

    private val defaultSchedule = Schedule(
        scheduleId = -1L,
        startTime = LocalDateTime.now(),
        endTime = LocalDateTime.now(),
        color = "",
        recurWeek = null,
        checked = false,
        userId = 1L
    )

    private var _scheduleForEdit: Schedule = defaultSchedule

    fun getSchedule(schedule: Schedule) {
        _scheduleForEdit = schedule
    }

    fun editDateSchedule(startHour: Int, startMinute: Int, endHour: Int, endMinute: Int) {
        val editScheduleIndex = _currentDateSchedules.value!!.indexOf(_scheduleForEdit)
        val editedSchedule = Schedule(
            scheduleId = _scheduleForEdit.scheduleId,
            startTime = LocalDateTime.of(
                _scheduleForEdit.startTime.year,
                _scheduleForEdit.startTime.month,
                _scheduleForEdit.startTime.dayOfMonth,
                startHour,
                startMinute
            ),
            endTime = LocalDateTime.of(
                _scheduleForEdit.endTime.year,
                _scheduleForEdit.endTime.month,
                _scheduleForEdit.endTime.dayOfMonth,
                endHour,
                endMinute
            ),
            color = _scheduleForEdit.color,
            recurWeek = _scheduleForEdit.recurWeek,
            checked = false,
            userId = _scheduleForEdit.userId
        )

        _currentDateSchedules.value = _currentDateSchedules.value?.toMutableList().apply {
            this?.set(editScheduleIndex, editedSchedule)
        }
    }

    fun deleteCheckedSchedules() {
        val schedules = _currentDateSchedules.value?.toMutableList() ?: emptyList()
        _currentDateSchedules.value = schedules.filter { !it.checked }
        _checkedState.value = 0
    }
}
