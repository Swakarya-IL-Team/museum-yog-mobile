package com.swakarya.museumyog.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Size
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksansbold

class TicketShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawTicketPath(size = size)
        )
    }
}
private fun drawTicketPath(size: androidx.compose.ui.geometry.Size): Path {
    return Path().apply {
        val cornerRadius = 30f
        val seperempat = size.width.div(other = 4)
        lineTo(x = seperempat - cornerRadius, y = 0f)
        arcTo(
            rect = Rect(
                left = seperempat.minus(cornerRadius),
                top = 0F.minus(cornerRadius),
                right = seperempat.plus(cornerRadius),
                bottom = 0F.plus(cornerRadius)
            ),
            startAngleDegrees = 180.0f,
            sweepAngleDegrees = -180.0f,
            forceMoveTo = false
        )
        lineTo(x = size.width, y = 0F)
        // Bottom right arc

        lineTo(x = size.width, y = size.height)
        // Bottom left arc
        lineTo(seperempat.plus(cornerRadius), y = size.height)
        arcTo(
            rect = Rect(
                left = seperempat.minus(cornerRadius),
                top = size.height.minus(cornerRadius),
                right = seperempat.plus(cornerRadius),
                bottom = size.height.plus(cornerRadius)
            ),
            startAngleDegrees = 0.0f,
            sweepAngleDegrees = -180.0f,
            forceMoveTo = false
        )
        lineTo(x = 0F, y = size.height)

        close()
    }
}

@Preview(showBackground = true)
@Composable
fun prev(){
    Box(
        modifier = Modifier
            .clip(TicketShape())
            .background(Color.Transparent)
            .size(width = 200.dp, height = 100.dp)
            .border(3.dp, greenku, TicketShape())
    ){
        Text(text = "Tiket",
            modifier = Modifier.offset(x=0.dp,40.dp)
                .rotate(-90f),
            fontFamily = worksansbold,
            color = greenku)

    }
}