package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.R

@Composable
fun AddEditScheduleTopAppBar() {
    val backgroundColor = colorResource(id = R.color.schedule_top_appbar_background)

    TopAppBar(
        title = { Text(text = stringResource(R.string.schedule_top_appbar_title)) },
        backgroundColor = backgroundColor,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBackIos, "ArrowBack")
            }
        },
        actions = {
            // TODO: 일정 체크 -> 삭제 버튼 나타남
        }
    )
}

@Preview
@Composable
fun PreviewAddScheduleTopAppBar(){
    AddEditScheduleTopAppBar()
}