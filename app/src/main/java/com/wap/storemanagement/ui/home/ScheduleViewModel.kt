package com.wap.storemanagement.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.storemanagement.data.entity.Schedule
import com.wap.storemanagement.fake.FakeFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(dispatcherProvider: DispatcherProvider): BaseViewModel(dispatcherProvider) {

    private var _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    private val _currentDateSchedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    val currentDataSchedules: LiveData<List<Schedule>> = _currentDateSchedules

    //TODO : 달력에서 날짜를 선택했을 때 날짜에 해당하는 모든 일정을 반환
    //FIXME : 날짜 자료형 확정
    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchSchedules(date: CalendarDay) {
        //TODO : repository에 요청
        val currentScheduleList: MutableList<Schedule> = mutableListOf()
        _schedules.value = FakeFactory.createSchedules()

        _schedules.value?.forEach { schedule ->
            if (isCurrentDateSchedule(date, schedule)) {
                currentScheduleList.add(schedule)
            }
        }
        _currentDateSchedules.value = currentScheduleList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isCurrentDateSchedule(date: CalendarDay, schedule: Schedule) = date.toDate() == schedule.startTime.toScheduleDate()
    //FIXME : 캘린더 월이 1달씩 밀림   ex.May 5 클릭 -> Log : 4월 5일
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.toScheduleDate() = format(DateTimeFormatter.ofPattern("yyyyMMdd"))
fun CalendarDay.toDate() = hashCode().toString()