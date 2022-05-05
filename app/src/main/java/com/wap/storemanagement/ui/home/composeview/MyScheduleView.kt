package com.wap.storemanagement.ui.home.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R
import com.wap.storemanagement.data.entity.Schedule

@Composable
fun ScheduleCards(schedules: List<Schedule>) {

    LazyColumn {
        items(schedules) { schedule ->
            ScheduleCard(name = "schedule.userID.Name?", time = "hjk")
        }
    }
}

@Composable
fun ScheduleCard(name: String, time: String) {
    val width = dimensionResource(id = R.dimen.home_scheduleCard_width)
    val height = dimensionResource(id = R.dimen.home_scheduleCard_height)

    Row(
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        BaseProfile(name)
        BaseTimeSchedule(time)
        PinchButton()
    }
}

@Composable
fun BaseProfile(name: String) {
    val topMargin = dimensionResource(id = R.dimen.profile_top_margin)
    val bottomMargin = dimensionResource(id = R.dimen.profile_bottom_margin)
    val rightMargin = dimensionResource(id = R.dimen.profile_right_margin)

    Column() {
        Spacer(modifier = Modifier.size(topMargin))

        Row {
            Profile(name)

            Spacer(modifier = Modifier.size(rightMargin))
        }

        Spacer(modifier = Modifier.size(bottomMargin))
    }
}

@Composable
fun Profile(name: String){
    val size = dimensionResource(id = R.dimen.profile_size)
    val cornerRadius = dimensionResource(id = R.dimen.profile_corner_radius)
    val borderWidth = dimensionResource(id = R.dimen.profile_border)

    val borderColor = colorResource(id = R.color.profile_border)
    val backgroundColor = colorResource(id = R.color.profile_background)

    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(cornerRadius))
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(backgroundColor)
    ) {
        AlignTextCenterColumn{
            Text(text = name)
        }
    }
}

@Composable
fun BaseTimeSchedule(Time: String) {
    val width = dimensionResource(id = R.dimen.home_timeSchedule_width)
    val height = dimensionResource(id = R.dimen.home_scheduleCard_height)
    val topMargin = dimensionResource(id = R.dimen.home_timeSchedule_top_margin)
    val bottomMargin = dimensionResource(id = R.dimen.home_timeSchedule_bottom_margin)

    Column(
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        Spacer(modifier = Modifier.size(topMargin))
        
        Row(
            modifier = Modifier.height(height - (topMargin + bottomMargin))
        ) {
            InputTime(time = Time)
        }
        
        Spacer(modifier = Modifier.size(bottomMargin))
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
    val size = dimensionResource(id = R.dimen.home_pinchButton_size)

    Surface(
        modifier = Modifier
            .size(size)
    ){
        //Icon goes here
    }
}


@Preview
@Composable
fun PreviewGreeting() {
    ScheduleCard("은빈","12:00 - 18:00")
}