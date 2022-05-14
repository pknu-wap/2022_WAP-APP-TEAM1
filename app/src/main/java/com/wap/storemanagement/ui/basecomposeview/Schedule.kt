package com.wap.storemanagement.ui.basecomposeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R
import java.time.LocalTime

@Composable
fun BaseScheduleLazyColumn(block: (LazyListScope) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        block(this)
    }
        AddScheduleCard()
    }



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleCard(startTime: LocalTime, endTime: LocalTime) {
    val checkBoxColor = colorResource(id = R.color.schedule_check_box)
    val grayTextColor = colorResource(id = R.color.gray_text)
    val checkedState = remember { mutableStateOf(false) }

    BaseSurface {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BaseTimeColumn {
                Text(
                    text = stringResource(id = R.string.schedule_schedule_card_start_text),
                    fontSize = 18.sp,
                    color = grayTextColor
                )
                Text(text = startTime.toString(), fontSize = 22.sp)
            }

            Text(text = "-", fontSize = 22.sp)

            BaseTimeColumn {
                Text(
                    text = stringResource(id = R.string.schedule_schedule_card_end_text),
                    fontSize = 18.sp,
                    color = grayTextColor
                )
                Text(text = endTime.toString(), fontSize = 22.sp)
            }

            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(checkBoxColor)
            )
        }
    }
}

@Composable
fun AddScheduleCard() {
    val addCircleIconColor = colorResource(id = R.color.schedule_add_circle_icon)
    val addCardText = stringResource(id = R.string.schedule_add_card_text)

    BaseSurface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.AddCircle, "add_schedule", tint = addCircleIconColor)
            Text(text = addCardText)
        }
    }
}

@Composable
private fun BaseTimeColumn(block: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        block()
    }
}

@Composable
private fun BaseSurface(block: @Composable () -> Unit) {
    val shape = RoundedCornerShape(7.dp)
    val borderColor = colorResource(id = R.color.schedule_base_surface_border)

    Surface(
        elevation = 4.dp,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color.White)
            .border(width = 1.dp, color = borderColor, shape = shape)
    ) {
        block()
    }
}