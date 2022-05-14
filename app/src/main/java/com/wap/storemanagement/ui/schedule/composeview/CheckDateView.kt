package com.wap.storemanagement.ui.schedule.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckDateView(selectDay: LocalDateTime) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = selectDay.localDateTimeFormatter(), fontSize = 16.sp)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.localDateTimeFormatter(): String =
    format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일 (E)"))


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewCheckDate() {
    CheckDateView(LocalDateTime.of(2022, 5, 5, 12, 0, 0))
}