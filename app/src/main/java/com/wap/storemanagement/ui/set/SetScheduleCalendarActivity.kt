package com.wap.storemanagement.ui.set

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.wap.base.BaseActivity
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ActivitySetBinding
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.set.composeview.*

@RequiresApi(Build.VERSION_CODES.O)
class SetScheduleCalendarActivity : BaseActivity<ActivitySetBinding>(R.layout.activity_set) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.composeSetTopAppbar.setContent { SetScheduleCalendarTopAppBar() }
        binding.composeSetCalendarNameTitle.setContent { CalendarNameTitle() }
        binding.composeSetCalendarNameTextField.setContent { SetCalendarName() }
        /*
        * TODO : viewModel 작성 -> SelectWeek()에 selectedOption 옮기기
        * TODO : selectedOption과 같은 recurWeek 가진 schedules 반환
        * TODO : schdules -> SelectedRecurSchedules에 넘겨주기
        */
        binding.composeSetFixedScheduleTitle.setContent { CalendarFixedScheduleTitle() }
        binding.composeSetSelectFixedDayOfWeek.setContent { SelectWeek() }
        setSelectedDaySchedules()
        binding.composeSetSaveButton.setContent { SaveButton() }
    }

    private fun setSelectedDaySchedules() {
        binding.composeSetSelectedDaySchedules.setContent {
            // TODO: viewModel 작성 후 연결
            SelectedRecurSchedules(
                schedules = FakeFactory.createSchedules()
            ) {
                Log.i("todo", "click 'add button' in set")
            }
        }
    }
}
