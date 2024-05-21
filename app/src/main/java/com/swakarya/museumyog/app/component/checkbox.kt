package com.swakarya.museumyog.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.ui.theme.greenku


@Composable
fun CircularCheckbox(checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(
                color = if (checked) greenku else Color.White.copy(
                    alpha = 0.6f
                ),
                shape = CircleShape

            )
            .clickable { onCheckedChange(!checked) }
            .border(1.dp, greenku, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
@Preview
@Composable
fun previ(){
    CircularCheckbox(checked = false,
        onCheckedChange = {})
}