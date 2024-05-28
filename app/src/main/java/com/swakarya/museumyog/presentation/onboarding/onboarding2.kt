package com.swakarya.museumyog.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@Composable
fun onboarding2(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter) {
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Ini logo",
                modifier = Modifier.size(120.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize()
        .clickable { navController.navigate("onboarding3") },
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(70.dp))
            Image(painter = painterResource(id = R.drawable.siluet_museum),
                contentDescription ="Siluet Museum",
                modifier = Modifier.size(450.dp))
        }
        Column {
            Spacer(modifier = Modifier.height(144.dp))
            Image(painter = painterResource(id = R.drawable.pasar),
                contentDescription ="pasar gak sie?",
                modifier = Modifier.size(450.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart){
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.awan_samping),
                contentDescription = "awan doang sih",
                modifier = Modifier.size(120.dp))
        }
        Column {
            Image(painter = painterResource(id = R.drawable.bendera_samping),
                contentDescription = "bendera",
                modifier = Modifier.size(120.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopEnd){
        Column {
            Spacer(modifier = Modifier.height(150.dp))
            Image(painter = painterResource(id = R.drawable.awan3),
                contentDescription = "awan doang sih",
                modifier = Modifier.size(120.dp))
        }
        Column {
            Image(painter = painterResource(id = R.drawable.bendera_samping2),
                contentDescription = "bendera",
                modifier = Modifier.size(120.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(400.dp))
            Image(
                painter = painterResource(id = R.drawable.bayangan),
                contentDescription = "bayangan",
                modifier = Modifier.size(300.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter) {
        Column {
            Spacer(modifier = Modifier.height(200.dp))
            Image(
                painter = painterResource(id = R.drawable.laki_perempuan),
                contentDescription = "lanang wadon",
                modifier = Modifier.size(350.dp))

        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopEnd){
        Column {
            Spacer(modifier = Modifier.height(460.dp))
            Image(
                painter = painterResource(id = R.drawable.tanaman4),
                contentDescription = "tanaman",
                modifier = Modifier.size(100.dp))

        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart){
        Column {
            Spacer(modifier = Modifier.height(500.dp))
            Image(
                painter = painterResource(id = R.drawable.tanaman3),
                contentDescription = "tanaman",
                modifier = Modifier.size(100.dp).
                padding(start = 20.dp, top = 0.dp, end = 0.dp, bottom = 50.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(580.dp))
            Text(text = "Booking Tiket & Rasakan ",
                color = greenku,
                fontSize = 25.sp,
                fontFamily = worksansbold
            )
            Text(text = "Event Seru di Museum!",
                color = greenku,
                fontSize = 25.sp,
                fontFamily = worksansbold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Dengan MuseumYog, Booking tiket",            color = greyku,
                fontSize = 17.sp,
                fontFamily = worksans
            )
            Text(text = "dengan mudah dan dapatkan info",
                color = greyku,
                fontSize = 17.sp,
                fontFamily = worksans
            )
            Text(text = "terupdate event seru di seluruh",
                color = greyku,
                fontSize = 17.sp,
                fontFamily = worksans
            )
            Text(text = "Museum Yogyakarta!",
                color = greyku,
                fontSize = 17.sp,
                fontFamily = worksans
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(10.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = painterResource(id = R.drawable.elipse),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(10.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "CopyRight By Swakarya 2024",
                color = greyku,
                fontFamily = worksans
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Version 1.0.0",
                color = greyku,
                fontFamily = worksans
            )

        }
    }
}