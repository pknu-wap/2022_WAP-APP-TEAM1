package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
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
                 TimePickerToggle(TimePickerState.StartTime) {
                 }
                Row() {
                    Text(text = "취소")
                    Text(text = "확인")
                }
            }
        }
    }
}

private enum class TimePickerOption {
    Option,
    Background
}

enum class TimePickerState {
    StartTime,
    EndTime
}

// 출처: https://fvilarino.medium.com/creating-an-animated-selector-in-jetpack-compose-669066dfc01b
@Composable
fun TimePickerToggle(
    selectedOption: TimePickerState,
    onOptionSelect: (TimePickerState) -> Unit
) {
    val options = TimePickerState.values()
    require(options.contains(selectedOption)) { "Invalid selected option [$selectedOption]" }

    Layout(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50))
            .background(color = Color.White),
        content = {
            options.forEach { option ->
                Box(
                    modifier = Modifier
                        .layoutId(TimePickerOption.Option)
                        .clickable { onOptionSelect(option) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option.name,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Box(
                    modifier = Modifier
                        .layoutId(TimePickerOption.Background)
                        .background(Color.Gray)
                )
            }
        }
    ) { measurables, constraints ->

        val optionWidth = constraints.maxWidth / options.size

        val optionConstraints = Constraints.fixed(
            width = optionWidth,
            height = constraints.maxHeight,
        )

        val optionPlaceables = measurables
            .filter { measurable -> measurable.layoutId == TimePickerOption.Option }
            .map { measurable -> measurable.measure(optionConstraints) }

        val backgroundPlaceable = measurables
            .first { measurable -> measurable.layoutId == TimePickerOption.Background }
            .measure(optionConstraints)

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight,
        ) {
            backgroundPlaceable.placeRelative(
                x = 0,
                y = 0
            )

            optionPlaceables.forEachIndexed { index, placeable ->
                placeable.placeRelative(
                    x = optionWidth * index,
                    y = 0
                )
            }
        }
    }
}

@Preview(widthDp = 250, heightDp = 60)
@Composable
private fun PreviewTimePicker() {
    TimePickerToggle(TimePickerState.StartTime) {
    }
}