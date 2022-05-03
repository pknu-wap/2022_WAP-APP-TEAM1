package com.wap.storemanagement.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.storemanagement.data.entity.Schedule
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(dispatcherProvider: DispatcherProvider): BaseViewModel(dispatcherProvider) {

    private var _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()
    val schedules: LiveData<List<Schedule>> = _schedules

    //TODO : 달력에서 날짜를 선택했을 때 날짜에 해당하는 모든 일정을 반환
    //FIXME : 날짜 자료형 확정
    fun fetchSchedules(date: CalendarDay) {
        //TODO : repository에 요청
        //_schedules.value = FakeFactory.createSchedules()
        //FIXME : Fake 다시 생성후 사용
    }
}