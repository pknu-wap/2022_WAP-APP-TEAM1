package com.wap.storemanagement.ui.schedule.composeview.timepicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wap.storemanagement.R

@Composable
fun CancelAddButton(
    cancelEvent: () -> Unit,
    confirmEvent: () -> Unit
) {
    val cancelText = stringResource(id = R.string.schedule_time_picker_cancel_button)
    val addText = stringResource(id = R.string.schedule_time_picker_add_button)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { cancelEvent() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = cancelText
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { confirmEvent() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = addText
            )
        }
    }
}