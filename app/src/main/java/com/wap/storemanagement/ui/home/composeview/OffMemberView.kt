package com.wap.storemanagement.ui.home.composeview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.basecomposeview.Profile
import com.wap.storemanagement.ui.basecomposeview.SubTitle

@Composable
fun OffMemberView() {
    Column() {
        OffMemberTitle()
        OffMemberLazyList()
    }
}

@Composable
private fun OffMemberTitle() {
    val title = stringResource(id = R.string.home_off_member_title)

    SubTitle(text = title)
}

@Composable
private fun OffMemberLazyList() {
    val scrollState = rememberLazyListState()

    LazyRow(state = scrollState) {
        // TODO: member list중 일정에 일이 없는 사람의 이름을 가져와서 profile에 적용

        item { Profile(name = "Dd") }
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