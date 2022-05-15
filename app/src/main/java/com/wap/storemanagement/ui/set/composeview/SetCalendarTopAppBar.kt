package com.wap.storemanagement.ui.set.composeview

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.basecomposeview.BaseTopAppBar

@Composable
fun SetScheduleCalendarTopAppBar() {
    BaseTopAppBar(
        text = stringResource(id = R.string.set_calender_top_appbar_title),
        onClick = { /*TODO*/ },
        actions = {}
    )
}