package com.swakarya.museumyog.presentation.informasikoleksi.InformationKoleksi

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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.swakarya.museumyog.component.ImageSliderWithIndicator
import com.swakarya.museumyog.presentation.informasikoleksi.InformationPage.InformationPageViewModel
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationKoleksi(
    itemIndex: Int?,
    navController: NavHostController,
    viewModel: InformationPageViewModel = hiltViewModel()
) {
    val museum by viewModel.museum.collectAsState()

    LaunchedEffect(itemIndex) {
        if (itemIndex != null) {
            viewModel.loadMuseum(itemIndex)
        }
    }

    if (museum != null) {
        val museumData = museum!!
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.background(Color.Transparent),
                    containerColor = Color.Transparent
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { navController.navigate(route = "pay1/$itemIndex/${museumData.name}/${museumData.imageList[0]}") },
                            colors = ButtonDefaults.buttonColors(greenku),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.size(width = 350.dp, height = 60.dp)
                        ) {
                            Text(text = "Pesan Tiket")
                        }
                    }
                }
            }
        ) {
            Box {
                ImageSliderWithIndicator(imageResList = museumData.imageList)
                Box {
                    IconButton(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        onClick = { navController.navigate(route = "listMuseum") }) {
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
                        modifier = Modifier.padding(top = 190.dp),
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
                                    text = museumData.name,
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
                                        text = museumData.rate,
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
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    TextButton(onClick = { navController.navigate("koleksi/$itemIndex") }) {
                                        Text(
                                            text = "Koleksi",
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
                                TextButton(onClick = { navController.navigate("review/$itemIndex") }) {
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
                            modifier = Modifier.padding(
                                start = 0.dp,
                                top = 0.dp,
                                bottom = 60.dp,
                                end = 0.dp
                            )
                        ) {
                            LazyColumn {
                                item {
                                    Column {
                                        Spacer(modifier = Modifier.height(28.dp))
                                        museumData.koleksi.forEachIndexed { index, koleksiItem ->
                                            ColumnItem(
                                                itemIndex = index,
                                                painter = koleksiItem.image,
                                                tittle = koleksiItem.name,
                                                describe = koleksiItem.description
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
    } else {
        // Loading state or error state
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Int,
    tittle: String,
    describe: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 0.dp)
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = tittle,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = tittle,
            fontFamily = worksansbold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = describe,
            fontFamily = worksans,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
