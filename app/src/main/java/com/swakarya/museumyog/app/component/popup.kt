package com.swakarya.museumyog.app.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.museumyog.ui.theme.worksans
import com.example.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.app.component.SharedVariables.terdekat
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import kotlinx.coroutines.launch


@OptIn( ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            PopUpMenuContent {
                scope.launch {
                    bottomSheetState.hide()
                }
            }
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                scope.launch {
                    bottomSheetState.show()
                }
            }) {
                Text(text = "Show Pop-up Menu")
            }
        }
    }
}

@Composable
fun PopUpMenuContent(onDismiss: () -> Unit) {
    var colorbutton = if(terdekat) greenku else Color.White
    var colorbutton1 = if(terdekat) Color.White else greenku
    var textcolor = if(terdekat) Color.White else Color.Black
    var textcolor1 = if(terdekat) Color.Black else Color.White
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { onDismiss() }) {
                Icon(imageVector = Icons.Default.Close,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    tint = greenku)
            }
        }
        Text(text = "Filter",
            fontSize = 24.sp,
            fontFamily = worksansbold,
            color = greenku)
        Text(text = "Opsi yang ingin anda lihat",
            fontFamily = worksans,
            fontSize = 14.sp)
        Spacer(modifier = Modifier.height(10.dp))
        // Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(onClick = { terdekat = false},
                colors = ButtonDefaults.buttonColors(colorbutton1),
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                shape = RoundedCornerShape(10.dp)) {
                Text(text = "Terpopuler",
                    fontFamily = worksans,
                    fontSize = 14.sp,
                    color = textcolor1)
            }
            OutlinedButton(
                onClick = { terdekat = true },
                colors = ButtonDefaults.buttonColors(colorbutton),
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Terdekat",
                    fontFamily = worksans,
                    fontSize = 14.sp,
                    color = textcolor
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Rating
        Text(text = "Rating:",
            fontFamily = worksansbold,
            fontSize = 16.sp)
        RatingBar()

        Spacer(modifier = Modifier.height(16.dp))

        // Price Filter
        Text(text = "Harga Tiket",
            fontFamily = worksansbold,
            fontSize = 16.sp)
        PriceFilter()

        Spacer(modifier = Modifier.height(10.dp))

        // Close Button
        Button(onClick = { },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 400.dp, height = 50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(greenku)) {
            Text(text = "Simpan",
                fontFamily = worksansbold,
                fontSize = 16.sp,
                color = Color.White)
        }
    }
}

@Composable
fun RatingBar() {
    var rating by remember { mutableStateOf(0) }

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {
        for (i in 1..5) {
            IconButton(onClick = { rating = i }) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star $i",
                    tint = if (i <= rating) Color.Yellow else Color.Gray,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
fun PriceFilter() {
    var priceRange by remember { mutableStateOf(0f..100f) }

    Column {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(280.dp)) {
            Text(text = "Rp. 0")
            Text(text = "Rp. ${priceRange.start.toInt()} .000")
        }
        Slider(
            value = priceRange.start,
            onValueChange = { priceRange = it..priceRange.endInclusive },
            valueRange = 0f..100f,
            steps = 100,
            modifier = Modifier.padding(5.dp),
            colors = SliderDefaults.colors(
                thumbColor = greenku,
                activeTrackColor = greenku,
                inactiveTrackColor = Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}