package com.swakarya.museumyog.presentation

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.component.ImageSliderWithIndicator
import com.swakarya.museumyog.component.deskripsi
import com.swakarya.museumyog.component.judulkoleksi
import com.swakarya.museumyog.component.koleksi
import com.swakarya.museumyog.domain.model.ImageMuseum.images
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun informationkoleksi(navController: NavHostController) {
    Scaffold(
    ) {
        Box {
            ImageSliderWithIndicator(images = images)
            Box() {
                IconButton(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                    onClick = { /*TODO*/ }) {
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
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .padding(top = 18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Museum Keraton \nNgayogyakarta Hadiningrat",
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
                            TextButton(onClick = { navController.navigate("information") }) {
                                Text(
                                    text = "Deskripsi",
                                    fontFamily = worksans,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                TextButton(onClick = { navController.navigate("koleksi") }) {
                                    Text(
                                        text = "Koleksi",
                                        fontFamily = worksans,
                                        fontSize = 15.sp,
                                        color = greenku
                                    )
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.line),
                                    contentDescription = "",
                                )
                            }
                            TextButton(onClick = { navController.navigate("review") }) {
                                Text(
                                    text = "Penilaian",
                                    fontFamily = worksans,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                            }
                        }
                        Divider(color = Color.Gray, thickness = 1.dp)
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LazyColumn() {
                            val ItemCount = koleksi.size
                            items(ItemCount) { item ->
                                Spacer(modifier = Modifier.height(28.dp))
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
        }
    }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    describe: Array<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 0.dp)
    ) {
        Image(
            painter = painterResource(id = painter[itemIndex]),
            contentDescription = tittle[itemIndex],
            modifier = Modifier
                .fillMaxWidth()
                .size(180.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = tittle[itemIndex],
            fontFamily = worksansbold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = describe[itemIndex],
            fontFamily = worksans
        )
    }
}
