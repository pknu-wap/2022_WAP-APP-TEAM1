package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.basecomposeview.BaseTopAppBar

@Composable
fun AddEditScheduleTopAppBar() {

    BaseTopAppBar(
        text = stringResource(R.string.schedule_top_appbar_title),
        onClick = { /*TODO*/ },
        actions = { /* TODO: 일정 체크 -> 삭제 버튼 나타남 */ }
    )
}

@Preview
@Composable
fun PreviewAddScheduleTopAppBar() {
    AddEditScheduleTopAppBar()
}