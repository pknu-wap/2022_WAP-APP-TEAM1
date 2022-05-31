package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.schedule.DeleteButtonState

@Composable
fun AddEditScheduleTopAppBar(
    deleteButtonState: DeleteButtonState,
    onClickDeleteButton: () -> Unit
) {
    val backgroundColor = colorResource(id = R.color.schedule_top_appbar_background)

    TopAppBar(
        title = { Text(text = stringResource(R.string.schedule_top_appbar_title)) },
        backgroundColor = backgroundColor,
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.ArrowBackIos, "ArrowBack")
            }
        },
        actions = {
            DeleteButton(
                deleteButtonState = deleteButtonState,
                onClick = onClickDeleteButton
            )
        }
    )
}

@Composable
private fun DeleteButton(
    deleteButtonState: DeleteButtonState,
    onClick: () -> Unit
) {
    when (deleteButtonState) {
        DeleteButtonState.ON ->
            IconButton(
                onClick = { onClick() },
                content = { Icon(imageVector = Icons.Default.Delete, contentDescription = "") }
            )
        DeleteButtonState.OFF ->
            IconButton(
                onClick = { /* Nothing todo */ },
                enabled = false,
                content = { }
            )
    }
}

@Preview
@Composable
fun PreviewAddScheduleTopAppBar() {
    AddEditScheduleTopAppBar(
        deleteButtonState = DeleteButtonState.ON,
        onClickDeleteButton = {}
    )
}
