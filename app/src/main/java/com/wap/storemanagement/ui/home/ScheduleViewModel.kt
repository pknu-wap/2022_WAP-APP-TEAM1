package com.wap.storemanagement.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.domain.entity.Schedule
import com.wap.domain.local.ScheduleLocalDataSource
import com.wap.storemanagement.utils.toDate
import com.wap.storemanagement.utils.toLocalDateTime
import com.wap.storemanagement.utils.toScheduleDate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val scheduleLocalDataSource: ScheduleLocalDataSource
) : BaseViewModel(dispatcherProvider) {

    private var _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    private val _currentDateSchedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    val currentDataSchedules: LiveData<List<Schedule>> = _currentDateSchedules

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchSchedules(date: CalendarDay) {
        // _schedules.value = FakeFactory.createSchedules()
        _schedules.value = scheduleLocalDataSource.findSchedulesByStartTime(date.toLocalDateTime())

        _currentDateSchedules.value = _schedules.value?.filter { schedule -> isCurrentDateSchedule(date, schedule) } ?: emptyList()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isCurrentDateSchedule(date: CalendarDay, schedule: Schedule) = date.toDate() == schedule.startTime.toScheduleDate()
    //FIXME : 캘린더 월이 1달씩 밀림   ex.May 5 클릭 -> Log : 4월 5일
}
