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

@Preview
@Composable
fun Ad() {
    Column() {
        OffMemberTitle()
    }
}