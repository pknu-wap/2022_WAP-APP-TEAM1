package com.wap.storemanagement.ui.salary

import android.os.Bundle
import android.view.View
import com.wap.base.BaseFragment
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.FragmentSalaryBinding
import com.wap.storemanagement.ui.salary.composeview.TopBox
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SalaryFragment : BaseFragment<FragmentSalaryBinding>(R.layout.fragment_salary) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTopBox()
    }

    private fun setTopBox() {
        binding.composeSalaryTopBox.setContent {
            TopBox(salary = 10)
        }
    }
}
