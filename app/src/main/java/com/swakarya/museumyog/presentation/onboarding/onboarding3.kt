package com.swakarya.museumyog.presentation.onboarding

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.R

@Composable
fun onboarding3(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(120.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart){
        Column {
            Image(painter = painterResource(id = R.drawable.awan4),
                contentDescription = "awan",
                modifier = Modifier
                    .size(120.dp)
                    .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 45.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd){
        Column {
            Spacer(modifier = Modifier.height(80.dp))
            Image(painter = painterResource(id = R.drawable.awan_samping2),
                contentDescription = "awan",
                modifier = Modifier.size(90.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart){
        Column {
            Spacer(modifier = Modifier.height(90.dp))
            Image(painter = painterResource(id = R.drawable.pohon2),
                contentDescription ="pohon",
                modifier = Modifier
                    .size(600.dp)
                    .padding(start = 0.dp, top = 0.dp, end = 170.dp, bottom = 100.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(190.dp))
            Image(painter = painterResource(id = R.drawable.backgroud_laki),
                contentDescription =null,
                modifier = Modifier.size(360.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart){
        Column {
            Spacer(modifier = Modifier.height(360.dp))
            Image(painter = painterResource(id = R.drawable.tanaman),
                contentDescription =null ,
                modifier = Modifier
                    .size(250.dp)
                    .padding(start = 0.dp, top = 0.dp, end = 150.dp, bottom = 0.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(420.dp))
            Image(painter = painterResource(id = R.drawable.bayangan),
                contentDescription =null ,
                modifier = Modifier
                    .size(280.dp))
        }
        Column {
            Spacer(modifier = Modifier.height(230.dp))
            Image(painter = painterResource(id = R.drawable.laki2),
                contentDescription =null ,
                modifier = Modifier
                    .size(350.dp)
                    .padding(start = 20.dp, top = 0.dp, end = 0.dp, bottom = 0.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopEnd){
        Column {
            Spacer(modifier = Modifier.height(460.dp))
            Image(painter = painterResource(id = R.drawable.kaktus),
                contentDescription =null ,
                modifier = Modifier
                    .size(100.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(600.dp))
            Text(
                text = "Selamat Datang di MuseumYog! ",
                fontSize = 20.sp,
                fontFamily = worksansbold
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "Sudah siap menjelajah bersama kami?",
                fontSize = 15.sp,
                fontFamily = worksans
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(greenku),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 350.dp, height = 50.dp))
            {
                Text(text = "Siap!")
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription = "Lingkaran doang",
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.lingkaran),
                    contentDescription = "Lingkaran doang",
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.elipse),
                    contentDescription = "Lingkaran doang",
                    modifier = Modifier.size(15.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "CopyRight By Swakarya 2024",
                color = greyku,
                fontFamily = worksans
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Version 1.0.0",
                color = greyku,
                fontFamily = worksans
            )

        }
    }
}