package com.example.museumyog.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.museumyog.R
import com.example.museumyog.ui.theme.greyku
import com.example.museumyog.ui.theme.worksans
import kotlinx.coroutines.delay

@Composable
fun splashScreen(navController: NavController){
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate("onboarding1")
    }
    Column {
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            , Alignment.Center){
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription ="Logo",
                modifier = Modifier.size(250.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(modifier = Modifier.height(700.dp))
                Text(text = "CopyRight By Swakarya 2024",
                    color = greyku,
                    fontFamily = worksans
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Version 1.0.0",
                    color = greyku,
                    fontFamily = worksans
                )
            }
        }
    }



}
