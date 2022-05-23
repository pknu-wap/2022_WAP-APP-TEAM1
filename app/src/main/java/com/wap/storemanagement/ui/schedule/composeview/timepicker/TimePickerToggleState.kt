package com.wap.storemanagement.ui.schedule.composeview.timepicker

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Stable
interface TimePickerToggleState {
    val selectedIndex: Float
    val textColors: List<Color>

    fun selectOption(scope: CoroutineScope, index: Int)
}

@Stable
class TimePickerToggleStateImpl(
    options: List<String>,
    selectedOption: String,
    private val selectedColor: Color,
    private val unselectedColor: Color
) : TimePickerToggleState {

    override val selectedIndex: Float
        get() = _selectedIndex.value

    override val textColors: List<Color>
        get() = _textColors.value

    private var _selectedIndex = Animatable(options.indexOf(selectedOption).toFloat())

    private val animationSpec = tween<Float>(
        durationMillis = 200,
        easing = FastOutSlowInEasing
    )

    private var _textColors: State<List<Color>> = derivedStateOf {
        List(numOptions) { index ->
            lerp(
                start = unselectedColor,
                stop = selectedColor,
                fraction = 1f - (((selectedIndex - index.toFloat()).absoluteValue).coerceAtMost(1f))
            )
        }
    }

    private val numOptions = options.size

    override fun selectOption(scope: CoroutineScope, index: Int) {
        scope.launch {
            _selectedIndex.animateTo(
                targetValue = index.toFloat(),
                animationSpec = animationSpec
            )
        }
    }
}

@Composable
fun rememberTimePickerToggleState(
    options: List<String>,
    selectedOption: String,
    selectedColor: Color,
    unselectedColor: Color
) = remember {
    TimePickerToggleStateImpl(
        options,
        selectedOption,
        selectedColor,
        unselectedColor
    )
}