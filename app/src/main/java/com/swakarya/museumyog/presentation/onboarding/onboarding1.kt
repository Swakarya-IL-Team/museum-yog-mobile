package com.swakarya.museumyog.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.jogja
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold

@Composable
fun onboarding1(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription ="Ini logo",
                modifier = Modifier.size(120.dp))
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable { navController.navigate("onboarding2") },
        contentAlignment = Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(70.dp))
            Image(painter = painterResource(id = R.drawable.siluet_museum),
                contentDescription ="Siluet Museum",
                modifier = Modifier.size(450.dp))

        }
        Column{
            Spacer(modifier = Modifier.height(462.dp))
            Box(modifier = Modifier.fillMaxSize()
                .clip(RectangleShape)
                .background(greenku))
        }
        Column {
            Spacer(modifier = Modifier.height(160.dp))
            Image(painter = painterResource(id = R.drawable.bangunan_museum),
                contentDescription ="Museum",
                modifier = Modifier.size(450.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.size(width = 300.dp, height = 1000.dp)) {
            Spacer(modifier = Modifier.height(550.dp))
            Text(text = "Yogyakarta",
                color = Color.White,
                fontSize = 45.sp,
                fontFamily = jogja
            )
            Text(text = "Penuh Dengan Cerita!",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = worksanssemibold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temukan museum terpopuler dan historis  Yogyakarta di sekitarmu dengan mudah dan lengkap!",
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = worksans,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(35.dp))
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.elipse),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(10.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription ="Lingkaran doang",
                    modifier = Modifier.size(10.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "CopyRight By Swakarya 2024",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = worksans
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Version 1.0.0",
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = worksans
            )
        }

    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.CenterEnd){
        Column {
            Spacer(modifier = Modifier.height(400.dp))
            Image(painter = painterResource(id = R.drawable.awan_samping2),
                contentDescription = "awan doang sih",
                modifier = Modifier.size(80.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.CenterStart){
        Column {
            Spacer(modifier = Modifier.height(400.dp))
            Image(painter = painterResource(id = R.drawable.awan_samping),
                contentDescription = "awan doang sih",
                modifier = Modifier.size(80.dp))
        }
    }
}

@Preview
@Composable
fun p(){
    onboarding1(navController = rememberNavController())
}