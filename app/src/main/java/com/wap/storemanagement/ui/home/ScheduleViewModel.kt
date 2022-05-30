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

    private var _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    private val _currentDateSchedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    val currentDataSchedules: LiveData<List<Schedule>> = _currentDateSchedules
    var currentDate = scheduleRepository.currentDate
        private set

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

    private var _timePickerState: MutableLiveData<TimePickerState> = MutableLiveData(TimePickerState.Close)
    val timePickerState: LiveData<TimePickerState> = _timePickerState

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
            userId = 1L
        )
        _currentDateSchedules.value = _currentDateSchedules.value?.plus(schedule) ?: listOf(schedule)
    }

    lateinit var scheduleForEdit: Schedule

    fun editDateSchedule(startHour: Int, startMinute: Int, endHour: Int, endMinute: Int) {
        val editScheduleIndex = _currentDateSchedules.value!!.indexOf(scheduleForEdit)
        val editedSchedule = Schedule(
            scheduleId = scheduleForEdit.scheduleId,
            startTime = LocalDateTime.of(
                scheduleForEdit.startTime.year,
                scheduleForEdit.startTime.month,
                scheduleForEdit.startTime.dayOfMonth,
                startHour,
                startMinute
            ),
            endTime = LocalDateTime.of(
                scheduleForEdit.endTime.year,
                scheduleForEdit.endTime.month,
                scheduleForEdit.endTime.dayOfMonth,
                endHour,
                endMinute
            ),
            color = scheduleForEdit.color,
            recurWeek = scheduleForEdit.recurWeek,
            userId = scheduleForEdit.userId
        )

        _currentDateSchedules.value = _currentDateSchedules.value?.toMutableList().apply {
            this?.set(editScheduleIndex, editedSchedule)
        }
    }
}
