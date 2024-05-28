package com.swakarya.museumyog.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.R

@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    reviewRating: Float,
    onRatingChanged: (Float) -> Unit
) {
    val density = LocalDensity.current.density
    val starSize = (12f * density).dp
    val starSpacing = (0.5f * density).dp

    Row {
        for (i in 1..maxStars) {
            val isSelected = i <= reviewRating
            val icon = if (isSelected) painterResource(id = R.drawable.icon_bintang)else painterResource(id = R.drawable.icon_bintang_outlined)
            val iconTintColor = if (isSelected) Color(0xFFFED330) else Color(0xFFFED330)
            Icon(
                painter = icon, contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .selectable(
                        selected = isSelected,
                        onClick = {
                            onRatingChanged(i.toFloat())
                        }
                    )
                    .width(starSize)
                    .height(starSize)
            )
            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}