package com.wap.storemanagement.ui.home.composeview

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round

@Composable
fun ScheduleCard() {
    Row(
        modifier = Modifier
            .width(360.dp)
            .height(48.dp)
    ) {
        BaseProfile(marginX = 12, marginY = 4, "은빈")
        BaseTimeSchedule(marginY = 4, Time = "12:00 - 18:00")
        PinchButton()
    }
}

@Composable
fun BaseProfile(marginX: Int, marginY: Int, name: String) {
    Column() {
        Spacer(modifier = Modifier.size(marginY.dp))

        Row {
            Spacer(modifier = Modifier.size(marginX.dp))

            Profile(name)

            Spacer(modifier = Modifier.size(marginX.dp))
        }

        Spacer(modifier = Modifier.size(marginY.dp))
    }
}

@Composable
fun Profile(name: String){
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        AlignTextCenterColumn{
            Text(text = name)
        }
    }
}

@Composable
fun BaseTimeSchedule(marginY: Int, Time: String) {
    Column(
        modifier = Modifier
            .width(232.dp)
            .height(48.dp)
    ) {
        Spacer(modifier = Modifier.size(marginY.dp))
        
        Row(
            modifier = Modifier.height(48.dp - (marginY.dp * 2))
        ) {
            InputTime(time = Time)
        }
        
        Spacer(modifier = Modifier.size(marginY.dp))
    }
}

@Composable
fun InputTime(time: String){
    Box(){
        AlignTextStartColumn {
            Text(
                text = time,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun PinchButton(){
    Surface(
        modifier = Modifier.size(50.dp)
    ){
        //Icon goes here
    }
}


@Preview
@Composable
fun PreviewGreeting() {
    ScheduleCard()
}