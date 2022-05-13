package com.wap.storemanagement.ui.schedule.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.storemanagement.R

@Composable
fun SaveButton() {
    val backgroundColor = colorResource(id = R.color.save_button_background)
    val buttonContentColor = colorResource(id = R.color.white)
    val buttonText = stringResource(id = R.string.save_button_text)

    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = buttonContentColor
        )
    ) {
            Text(text = buttonText, fontSize = 18.sp)
    }
}

@Preview
@Composable
fun PreviewSaveButton() {
    SaveButton()
}