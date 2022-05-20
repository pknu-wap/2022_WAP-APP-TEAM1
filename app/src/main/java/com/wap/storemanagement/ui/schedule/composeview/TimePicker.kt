package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun TimePickerView(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .size(280.dp, 260.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "시작 시간")
                    Text(text = "종료 시간")
                }
                Text(text = "Time Picker")
                Row() {
                    Text(text = "취소")
                    Text(text = "확인")
                }
            }
        }
    }
}
