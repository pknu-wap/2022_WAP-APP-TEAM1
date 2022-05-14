package com.wap.storemanagement.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivityScheduleBinding
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.schedule.composeview.*
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class AddEditScheduleActivity: BaseActivity<ActivityScheduleBinding>(R.layout.activity_schedule) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding.composeScheduleTopAppbar.setContent { AddEditScheduleTopAppBar() }
        SetCheckDateView()
        SetScrollScheduleView()
        binding.composeScheduleSaveButton.setContent { SaveButton() }
    }

    private fun SetCheckDateView() {
        binding.composeScheduleCheckDate.setContent {
            // FIXME : ViewModel 작성 후 연결
            CheckDateView(selectDay = LocalDateTime.of(2222,2,22,22,2))
        }
    }

    private fun SetScrollScheduleView() {
        // FIXME : ViewModel 작성 후 연결
        binding.composeScheduleScrollSchedule.setContent {
            ScheduleView(schedules = FakeFactory.createSchedules()) }
    }
}