package com.wap.storemanagement.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivityScheduleBinding
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.schedule.composeview.AddEditScheduleTopAppBar
import com.wap.storemanagement.ui.schedule.composeview.CheckDateView
import com.wap.storemanagement.ui.schedule.composeview.SaveButton
import com.wap.storemanagement.ui.schedule.composeview.ScheduleView
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class AddEditScheduleActivity : BaseActivity<ActivityScheduleBinding>(R.layout.activity_schedule) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.composeScheduleTopAppbar.setContent { AddEditScheduleTopAppBar() }
        setCheckDateView()
        setScrollScheduleView()
        binding.composeScheduleSaveButton.setContent { SaveButton() }
    }

    private fun setCheckDateView() {
        binding.composeScheduleCheckDate.setContent {
            // FIXME : ViewModel 작성 후 연결
            CheckDateView(selectDay = LocalDateTime.of(2222, 2, 22, 22, 2))
        }
    }

    private fun setScrollScheduleView() {
        // FIXME : ViewModel 작성 후 연결
        binding.composeScheduleScrollSchedule.setContent {
            ScheduleView(schedules = FakeFactory.createSchedules())
        }
    }
}