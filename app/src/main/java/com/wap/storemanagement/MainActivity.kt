package com.wap.storemanagement

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.wap.base.BaseActivity
import com.wap.storemanagement.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController by lazy { findNavController(R.id.fragment_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setNavHostFragment()
    }

    private fun setNavHostFragment() {
        binding.bottomBarMain.setupWithNavController(navController)
    }
}
