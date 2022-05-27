package com.wap.storemanagement.ui.schedule.composeview.timepicker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.wap.storemanagement.R

private enum class TimePickerToggleOption {
    Option,
    Background
}

// 출처: https://fvilarino.medium.com/creating-an-animated-selector-in-jetpack-compose-669066dfc01b
@Composable
fun TimePickerToggle(
    options: Array<TimeTitle>,
    roundedCornerPercent: Int,
    selectedOption: TimeTitle,
    selectedColor: Color = Color.White,
    unselectedColor: Color = colorResource(id = R.color.gray_text),
    state: TimePickerToggleState = rememberTimePickerToggleState(
        options = options,
        selectedOption = selectedOption,
        selectedColor = selectedColor,
        unselectedColor = unselectedColor
    ),
    onOptionSelect: (TimeTitle) -> Unit,
) {
    val backgroundColor = colorResource(id = R.color.focused_indicator_color)

    require(options.contains(selectedOption)) { "Invalid selected option [$selectedOption]" }

    LaunchedEffect(key1 = options, key2 = selectedOption) {
        state.selectOption(this, options.indexOf(selectedOption))
    }

    Layout(
        modifier = Modifier
            .background(color = Color.White),
        content = {
            val colors = state.textColors
            options.forEachIndexed { index, option ->
                Box(
                    modifier = Modifier
                        .layoutId(TimePickerToggleOption.Option)
                        .clickable { onOptionSelect(option) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option.name,
                        style = MaterialTheme.typography.body1,
                        color = colors[index],
                        modifier = Modifier.padding(horizontal = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Box(
                    modifier = Modifier
                        .layoutId(TimePickerToggleOption.Background)
                        .background(backgroundColor)
                )
            }
        }
    ) { measurables, constraints ->

        val optionWidth = constraints.maxWidth / options.size

        val optionConstraints = Constraints.fixed(
            width = optionWidth,
            height = constraints.maxWidth / 5,
        )

        val optionPlaceables = measurables
            .filter { measurable -> measurable.layoutId == TimePickerToggleOption.Option }
            .map { measurable -> measurable.measure(optionConstraints) }

        val backgroundPlaceable = measurables
            .first { measurable -> measurable.layoutId == TimePickerToggleOption.Background }
            .measure(optionConstraints)

        layout(
            width = constraints.maxWidth,
            height = constraints.maxWidth / 5,
        ) {
            backgroundPlaceable.placeRelative(
                x = (state.selectedIndex * optionWidth).toInt(),
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
