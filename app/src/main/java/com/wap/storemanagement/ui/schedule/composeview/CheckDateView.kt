package com.wap.storemanagement.ui.schedule.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.ui.basecomposeview.SubTitle
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckDateView(selectDay: LocalDateTime) {
    SubTitle(text = selectDay.localDateTimeFormatter())
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
