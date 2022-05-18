package com.wap.storemanagement.ui.basecomposeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun SubTitle(text: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalTime.formatToString() : String = format(DateTimeFormatter.ofPattern("HH:mm"))