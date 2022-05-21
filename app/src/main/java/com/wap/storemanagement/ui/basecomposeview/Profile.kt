package com.wap.storemanagement.ui.basecomposeview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.wap.storemanagement.R

@Composable
fun Profile(name: String) {
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
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name)
    }
}