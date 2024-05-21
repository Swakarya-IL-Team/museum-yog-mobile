package com.swakarya.museumyog.presentation.informasikoleksi

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.deskripsi
import com.swakarya.museumyog.app.component.judulkoleksi
import com.swakarya.museumyog.app.component.koleksi
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun informationkoleksi(photos: Array<Int> ,
                       name : Array<String>,
                       rate : Array<String>,
                       itemIndex: Int?,
                       navController: NavHostController) {
    Scaffold(
    ) {
        Box() {
            Image(painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = "",
                modifier = Modifier.size(400.dp),
                Alignment.TopCenter)
            IconButton(onClick = { navController.navigate(route = "home")}) {
                Image(painter = painterResource(id = R.drawable.back),
                    contentDescription ="",
                    modifier = Modifier.size(40.dp))
            }
            Column(modifier = Modifier.offset(x = 0.dp, y = 230.dp)) {
                Row(modifier = Modifier.fillMaxWidth()){
                    Text(text = name[itemIndex],
                        fontFamily = worksansbold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp))
                    Spacer(modifier = Modifier.width(30.dp))
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription ="",
                        tint = Color.Yellow,
                        modifier = Modifier.size(30.dp))
                    Text(text = rate[itemIndex],
                        fontFamily = worksansbold,
                        fontSize = 20.sp)
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    TextButton(onClick = { navController.navigate(route = "informasi/$itemIndex") }) {
                        Text(text = "Deskripsi",
                            fontFamily = worksans,
                            fontSize = 15.sp,
                            color = Color.Black)
                    }
                    TextButton(onClick = { navController.navigate(route = "koleksi/$itemIndex") }) {
                        Text(text = "Koleksi",
                            fontFamily = worksans,
                            fontSize = 15.sp,
                            color = greenku)
                    }
                    TextButton(onClick = { navController.navigate("review/$itemIndex") }) {
                        Text(text = "Penilaian",
                            fontFamily = worksans,
                            fontSize = 15.sp,
                            color = Color.Black)
                    }
                }
                Divider(color = Color.Gray, thickness = 1.dp)

            }
            Image(painter = painterResource(id = R.drawable.line),
                contentDescription ="",
                modifier = Modifier
                    .size(104.dp)
                    .offset(x = 155.dp, y = 295.dp))

        }
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(350.dp))
            LazyColumn() {
                val ItemCount = koleksi.size
                items(ItemCount) { item ->
                    ColumnItem(
                        itemIndex = item,
                        painter = koleksi,
                        tittle = judulkoleksi,
                        describe = deskripsi
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnItem(itemIndex: Int,
               painter: Array<Int>,
               tittle: Array<String>,
               describe: Array<String>) {
        Column(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 0.dp)) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription =tittle[itemIndex],
                modifier = Modifier.fillMaxWidth()
                    .size(180.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = tittle[itemIndex],
                fontFamily = worksansbold,
                fontSize = 15.sp)
            Text(text = describe[itemIndex],
                fontFamily = worksans)
            Spacer(modifier = Modifier.height(20.dp))
        }
}
