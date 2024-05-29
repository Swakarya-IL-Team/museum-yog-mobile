package com.swakarya.museumyog.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageSliderItem(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun Indicator(active: Boolean, onClick: () -> Unit) {
    val color = if (active) Color.Gray else Color.White
    val size = if (active) 10.dp else 10.dp
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
            .clickable(onClick = onClick)
    )
}

@Composable
fun ImageSliderWithIndicator(images: List<Int>) {
    val currentIndex = remember { mutableStateOf(0) }
    val lastSwipeTime = remember { mutableStateOf(0L) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    val currentTime = System.currentTimeMillis()
                    if (currentTime - lastSwipeTime.value < 300) {
                        return@detectHorizontalDragGestures
                    }

                    change.consume()  // Consume the change to avoid propagation
                    if (dragAmount > 0) {
                        // Dragging right
                        if (currentIndex.value > 0) {
                            currentIndex.value -= 1
                            lastSwipeTime.value = currentTime
                        }
                    } else {
                        // Dragging left
                        if (currentIndex.value < images.size - 1) {
                            currentIndex.value += 1
                            lastSwipeTime.value = currentTime
                        }
                    }
                }
            }
    ) {
        ImageSliderItem(imageRes = images[currentIndex.value])
    }
    Row(
        modifier = Modifier
            .padding(top = 163.dp, start = 170.dp, bottom = 550.dp)
    ) {
        images.forEachIndexed { index, _ ->
            Indicator(active = index == currentIndex.value) {
                currentIndex.value = index
            }
            if (index < images.size - 1) {
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}
