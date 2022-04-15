package com.wap.storemanagement

import android.os.Bundle
import android.view.View
import com.wap.base.BaseFragment
import com.wap.storemanagement.databinding.FragmentHomeBinding
import com.wap.storemanagement.ui.home.composeview.OffMemberView
import com.wap.storemanagement.ui.home.composeview.ScheduleCard

class FragmentHome: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeHomeSchedule.setContent {
            ScheduleCard("", "")
        }

        binding.composeHomeOffMember.setContent {
            OffMemberView()
        }
    }

}