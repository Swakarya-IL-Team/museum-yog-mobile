package com.swakarya.museumyog.presentation.informasikoleksi

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.komen
import com.swakarya.museumyog.app.component.nama
import com.swakarya.museumyog.app.component.rating
import com.swakarya.museumyog.app.component.tanggal
import com.swakarya.museumyog.component.ImageSliderWithIndicator
import com.swakarya.museumyog.data.model.imageMuseum
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.abuku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun review(photos: Array<Int> ,
           name : Array<String>,
           rate : Array<String>,
           itemIndex: Int?,
           navController: NavHostController) {
    Scaffold(
    ) {
        Box {
            ImageSliderWithIndicator(imageMuseum = imageMuseum,
                itemIndex)
            Box() {
                IconButton(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                    onClick = { navController.navigate(route = "listMuseum")}) {
                    Box(
                        modifier = Modifier
                            .background(Color.White, CircleShape)
                            .padding(horizontal = 1.dp, vertical = 1.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "IconBack",
                            tint = greenku
                        )
                    }

                }
                Card(
                    modifier = Modifier.padding(top = 177.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .padding(top = 18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = name[itemIndex!!],
                                fontFamily = worksanssemibold,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.wrapContentSize()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "",
                                    tint = yellowku,
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = "5.0",
                                    fontFamily = worksanssemibold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            TextButton(onClick = { navController.navigate("informasi/$itemIndex") }) {
                                Text(
                                    text = "Deskripsi",
                                    fontFamily = worksans,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                            }
                            TextButton(onClick = { navController.navigate("koleksi/$itemIndex") }) {
                                Text(
                                    text = "Koleksi",
                                    fontFamily = worksans,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                TextButton(onClick = { navController.navigate("review/$itemIndex") }) {
                                    Text(
                                        text = "Penilaian",
                                        fontFamily = worksans,
                                        fontSize = 15.sp,
                                        color = greenku
                                    )
                                }
                                Divider(
                                    color = greenku,
                                    modifier = Modifier
                                        .height(2.dp)
                                        .width(100.dp)
                                )
                            }

                        }
                        Divider(color = Color.Gray, thickness = 1.dp)

                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "3 Ulasan",
                                fontFamily = worksansmedium,
                                color = abuku
                            )
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(
                                    text = "Urutkan berdasarkan",
                                    color = Color.Black,
                                    fontFamily = worksans
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Icon Panah Bawah",
                                    tint = greenku
                                )
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LazyColumn() {
                                val ItemCount = nama.size
                                items(ItemCount) { item ->
                                    ColumnItem2(
                                        itemIndex = item,
                                        name = nama,
                                        date = tanggal,
                                        rate = rating,
                                        coment = komen
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnItem2(
    itemIndex: Int,
    name: Array<String>,
    date: Array<String>,
    rate: Array<String>,
    coment: Array<String>
) {
    Column {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 7.dp)
                .wrapContentSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(1.dp, greenku),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name[itemIndex],
                    fontFamily = worksansmedium,
                )
                OutlinedCard(
                    border = BorderStroke(1.dp, greenku)
                ) {
                    Row(horizontalArrangement = Arrangement.Center) {
                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = yellowku
                        )
                        Text(
                            modifier = Modifier.padding(end = 8.dp),
                            text = rate[itemIndex],
                            fontFamily = worksansmedium
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = date[itemIndex],
                fontFamily = worksans,
                color = Color.Black.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                text = coment[itemIndex],
                fontFamily = worksans,
            )

        }
    }
}