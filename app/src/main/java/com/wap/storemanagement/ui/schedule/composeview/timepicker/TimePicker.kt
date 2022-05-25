package com.wap.storemanagement.ui.schedule.composeview.timepicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.wap.storemanagement.fake.FakeFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimePickerView(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    addSchedule: (startHour: Int, StartMinute: Int, EndHour: Int, EndMinute: Int) -> Unit
) {
    if (showDialog) {
        val options: List<String> = listOf("StartTime", "EndTime")
        val selectedOption = remember { mutableStateOf(options.first()) }
        val roundedCornerPercent = 50

        val schedule = FakeFactory.createSchedules()[1]

        val startHour = remember { mutableStateOf(schedule.startTime.hour.toString()) }
        val startMinute = remember { mutableStateOf(schedule.startTime.minute.toString()) }
        val startAmPm = remember { mutableStateOf(timeOption.AM) }

        val endHour = remember { mutableStateOf(schedule.endTime.hour.toString()) }
        val endMinute = remember { mutableStateOf(schedule.endTime.minute.toString()) }
        val endAmPm = remember { mutableStateOf(timeOption.AM) }

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
                    selectedOption = selectedOption.value
                ) { option ->
                    selectedOption.value = option
                }
                InputTime(
                    hour = if (selectedOption.value == "StartTime") startHour else endHour,
                    minute = if (selectedOption.value == "StartTime") startMinute else endMinute,
                    ampm = if (selectedOption.value == "StartTime") startAmPm else endAmPm
                )
                CancelAddButton(
                    cancelEvent = { onDismiss() },
                    addEvent = {
                        addSchedule(
                            hourConvert(
                                option = startAmPm.value,
                                hour = startHour.value
                            ),
                            startMinute.value.toInt(),
                            hourConvert(
                                option = endAmPm.value,
                                hour = endHour.value
                            ),
                            endMinute.value.toInt()
                        )
                    }
                )
            }
        }
    }
}

private fun hourConvert(option: timeOption, hour: String) = when (option) {
    timeOption.AM -> hour.toInt()
    else -> hour.toInt() + 12
}
