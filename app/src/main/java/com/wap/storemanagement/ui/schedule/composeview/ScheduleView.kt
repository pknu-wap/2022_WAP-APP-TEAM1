package com.wap.storemanagement.ui.schedule.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R
import java.time.LocalDateTime
import java.time.LocalTime


@Composable
fun ScheduleView() {

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun ScheduleCard(startTime: LocalTime, endTime: LocalTime) {
    val checkBoxColor = colorResource(id = R.color.schedule_check_box)
    val grayTextColor = colorResource(id = R.color.gray_text)
    val checkedState = remember { mutableStateOf(false) }

    BaseSurface {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BaseTimeColumn {
                Text(text = "시작", fontSize = 18.sp, color = grayTextColor)
                Text(text = startTime.toString(), fontSize = 22.sp)
            }

            Text(text = "-", fontSize = 22.sp)

            BaseTimeColumn {
                Text(text = "종료", fontSize = 18.sp, color = grayTextColor)
                Text(text = endTime.toString(), fontSize = 22.sp)
            }

            Checkbox(checked = checkedState.value, onCheckedChange = {checkedState.value = it},
            colors = CheckboxDefaults.colors(checkBoxColor))
        }
    }
}

@Composable
private fun AddScheduleCard() {
    val addCircleIconColor = colorResource(id = R.color.schedule_add_circle_icon)
    val addCardText = stringResource(id = R.string.schedule_add_card_text)

    BaseSurface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.AddCircle,"add_schedule", tint = addCircleIconColor)
            Text(text = addCardText)
        }
    }
}

@Composable
private fun BaseSurface(block: @Composable () -> Unit) {
    Surface(
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color.White)
    ) {
        block()
    }
}

@Composable
private fun BaseTimeColumn(block: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        block()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PreviewScheduleView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            AddScheduleCard()
            ScheduleCard(LocalTime.of(12, 0), LocalTime.of(12, 20))
        }
    }
}