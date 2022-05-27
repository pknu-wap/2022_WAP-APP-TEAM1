package com.wap.storemanagement

import com.wap.base.BaseActivity
import com.wap.storemanagement.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private fun initBottomNavigation() {

        // supportFragmentManager.beginTransaction()
        //     .replace(R.id.main_frm, HomeFragment())
        //     .commitAllowingStateLoss()
        //
        // binding.mainBnv.setOnItemSelectedListener{ item ->
        //     when (item.itemId) {
        //
        //         R.id.homeFragment -> {
        //             supportFragmentManager.beginTransaction()
        //                 .replace(R.id.main_frm, HomeFragment())
        //                 .commitAllowingStateLoss()
        //             return@setOnItemSelectedListener true
        //         }
        //
        //         R.id.lookFragment -> {
        //             supportFragmentManager.beginTransaction()
        //                 .replace(R.id.main_frm, LookFragment())
        //                 .commitAllowingStateLoss()
        //             return@setOnItemSelectedListener true
        //         }
        //         R.id.searchFragment -> {
        //             supportFragmentManager.beginTransaction()
        //                 .replace(R.id.main_frm, SearchFragment())
        //                 .commitAllowingStateLoss()
        //             return@setOnItemSelectedListener true
        //         }
        //         R.id.lockerFragment -> {
        //             supportFragmentManager.beginTransaction()
        //                 .replace(R.id.main_frm, LockerFragment())
        //                 .commitAllowingStateLoss()
        //             return@setOnItemSelectedListener true
        //         }
        //     }
        //     false
        // }
    }
}
