package com.wap.storemanagement.ui.set.composeview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.basecomposeview.SubTitle

@Composable
fun CalendarNameTitle() {
    SubTitle(text = stringResource(id = R.string.set_calender_name_sub_title))
}

@Composable
fun SetCalendarName() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val backgroundColor = colorResource(id = R.color.white)
    val unfocusedIndicatorColor = colorResource(id = R.color.black)
    val focusedIndicatorColor = colorResource(id = R.color.focused_indicator_color)

    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { HintSetCalendarName() },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            focusedIndicatorColor = focusedIndicatorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor,
        )
    )
}

@Composable
private fun HintSetCalendarName() {
    Text(
        text = stringResource(id = R.string.set_calender_name_hint),
        style = TextStyle(
            color = colorResource(id = R.color.gray_text),
            fontSize = 18.sp
        )
    )
}

@Preview
@Composable
private fun PreviewSetCalendarName() {
    Column(
        modifier = Modifier.height(200.dp)
    ) {
        CalendarNameTitle()
        SetCalendarName()
    }
}
