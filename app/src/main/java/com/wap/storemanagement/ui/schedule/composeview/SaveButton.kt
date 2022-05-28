package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wap.storemanagement.ui.basecomposeview.BaseSaveButton

@Composable
fun SaveButton(onClick: () -> Unit) {
    BaseSaveButton {
        onClick()
    }
}

@Preview
@Composable
fun PreviewSaveButton() {
    // SaveButton()
}
