package com.wap.storemanagement.ui.schedule.composeview.timepicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun TimePickerView(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        val options: List<String> = listOf("StartTime", "EndTime")
        val selectedOption = remember { mutableStateOf(options.first()) }
        val roundedCornerPercent = 50

        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .size(280.dp, 260.dp)
                    .clip(shape = RoundedCornerShape(roundedCornerPercent/4))
                    .background(Color.White),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TimePickerToggle(
                    roundedCornerPercent = roundedCornerPercent,
                    options = options,
                    selectedOption = selectedOption.value,
                ) { option ->
                    selectedOption.value = option
                }
                Row() {
                    Text(text = "취소")
                    Text(text = "확인")
                }
            }
        }
    }
}
