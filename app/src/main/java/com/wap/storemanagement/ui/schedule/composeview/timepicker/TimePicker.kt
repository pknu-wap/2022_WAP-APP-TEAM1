package com.wap.storemanagement.ui.schedule.composeview.timepicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.wap.storemanagement.R
import com.wap.storemanagement.fake.FakeFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimePickerView(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    addSchedule: (String, String) -> Unit
) {
    if (showDialog) {
        val options: List<String> = listOf("StartTime", "EndTime")
        val selectedOption = remember { mutableStateOf(options.first()) }
        val roundedCornerPercent = 50

        val schedule = FakeFactory.createSchedules()[1]
        val hour = remember { mutableStateOf(schedule.startTime.hour.toString()) }
        val minute = remember{ mutableStateOf(schedule.startTime.minute.toString()) }
        val ampm = remember{ mutableStateOf(timeOption.AM)}

        Dialog(
            onDismissRequest = { }
        ) {
            Column(
                Modifier
                    .size(280.dp, 240.dp)
                    .clip(shape = RoundedCornerShape(roundedCornerPercent / 4))
                    .background(Color.White),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimePickerToggle(
                    roundedCornerPercent = roundedCornerPercent,
                    options = options,
                    selectedOption = selectedOption.value,
                ) { option ->
                    selectedOption.value = option
                }
                InputTime(
                    hour = hour,
                    minute = minute,
                    ampm = ampm
                )
                CancelAddButton(
                    cancelEvent = { onDismiss() },
                    addEvent = {
                        addSchedule(hour.toString(), minute.toString())
                    }
                )
            }
        }
    }
}
