package com.wap.storemanagement.ui.home.composeview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R

@Composable
fun OffMemberTitle() {
    val title = stringResource(id = R.string.home_off_member_title)
    val textColor = colorResource(id = R.color.gray_text)
    Text(
        text = title,
        fontSize = 14.sp,
        color = textColor
    )
}

@Composable
fun OffMemberLazyList() {
    val scrollState = rememberLazyListState()

    LazyRow(state = scrollState) {
        // TODO: member list중 일정에 일이 없는 사람의 이름을 가져와서 profile에 적용

        item { BaseProfile(name = "Dd") }
    }
}

@Preview
@Composable
private fun OffMemberPreview() {
    Column() {
        OffMemberTitle()
        OffMemberLazyList()
    }
}