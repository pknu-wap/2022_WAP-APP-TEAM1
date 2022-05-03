package com.wap.storemanagement

import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.wap.base.BaseActivity
import com.wap.storemanagement.databinding.ActivityMainBinding
import com.wap.storemanagement.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.fragmentContainer_main_fragment)
        }
    }

}