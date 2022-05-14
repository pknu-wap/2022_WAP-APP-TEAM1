package com.wap.storemanagement.ui.basecomposeview

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.wap.storemanagement.R

@Composable
fun BaseTopAppBar(text: String, onClick: () -> Unit, actions: () -> Unit) {
    val backgroundColor = colorResource(id = R.color.schedule_top_appbar_background)

    TopAppBar(
        title = {
            Text(text = text)
        },
        backgroundColor = backgroundColor,
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(Icons.Default.ArrowBackIos, "ArrowBack")
            }
        },
        actions = {
            actions()
        }
    )
}