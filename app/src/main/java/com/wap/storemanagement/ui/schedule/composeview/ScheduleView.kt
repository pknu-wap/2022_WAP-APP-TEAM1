package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wap.storemanagement.R




@Composable
fun ScheduleView() {

}

@Composable
private fun ScheduleCard() {
    BaseSurface {

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
fun BaseSurface(block: @Composable () -> Unit) {
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
            ScheduleCard()
        }
    }


}