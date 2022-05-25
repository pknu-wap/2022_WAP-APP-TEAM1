package com.wap.storemanagement.ui.schedule.composeview.timepicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R
import com.wap.storemanagement.fake.FakeFactory

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun P() {
    val schedule = FakeFactory.createSchedules()[1]
    val hour = remember { mutableStateOf(schedule.startTime.hour.toString()) }
    val minute = remember{ mutableStateOf(schedule.startTime.minute.toString()) }
    val ampm = remember{ mutableStateOf(timeOption.AM)}

    InputTime(hour, minute, ampm)
}

enum class timeOption {
    AM,
    PM
}

@Composable
fun InputTime(
    hour: MutableState<String>,
    minute: MutableState<String>,
    ampm: MutableState<timeOption>
) {
    val timeFontSize = 22.sp
    val buttonFontSize = 16.sp
    val focusedColor = colorResource(id = R.color.focused_indicator_color)
    val unfocusedColor = colorResource(id = R.color.gray)
    val borderWidth = dimensionResource(id = R.dimen.profile_border)
    val amText = stringResource(id = R.string.schedule_time_picker_am)
    val pmText = stringResource(id = R.string.schedule_time_picker_pm)
    val weight = listOf(4f, 1f, 4f, 3f)

    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.3f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = hour.value,
            onValueChange = {
                if (it.length in 0..2) hour.value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusedColor,
                unfocusedBorderColor = unfocusedColor
            ),
            textStyle = TextStyle(
                fontSize = timeFontSize,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(weight[0])
                .fillMaxHeight()
        )
        Text(
            text = ":",
            modifier = Modifier.weight(weight[1]),
            fontSize = timeFontSize,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = minute.value,
            onValueChange = {
                if (it.length in 0..2) minute.value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusedColor,
                unfocusedBorderColor = unfocusedColor
            ),
            textStyle = TextStyle(
                fontSize = timeFontSize,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(weight[2])
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier
                .weight(weight[3])
                .fillMaxHeight()
            ,
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .clickable { ampm.value = timeOption.AM }
                    .border(
                        width = 2.dp,
                        color = if (ampm.value == timeOption.AM) focusedColor else Color.Transparent,
                        shape = RoundedCornerShape(10)
                    )
                    .fillMaxWidth(0.8f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = amText,
                    fontSize = buttonFontSize
                )
            }
            Box(
                modifier = Modifier
                    .clickable { ampm.value = timeOption.PM }
                    .border(
                        width = borderWidth,
                        color = if (ampm.value == timeOption.PM) focusedColor else Color.Transparent,
                        shape = RoundedCornerShape(10)
                    )
                    .fillMaxWidth(0.8f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = pmText,
                    fontSize = buttonFontSize
                )
            }
        }
    }
}
