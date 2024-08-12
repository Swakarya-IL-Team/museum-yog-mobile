package com.swakarya.museumyog.presentation.informasikoleksi.InformationPage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.component.ImageSliderWithIndicator
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationPage(
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
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    TextButton(onClick = { navController.navigate("informasi/$itemIndex") }) {
                                        Text(
                                            text = "Deskripsi",
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
                                TextButton(onClick = { navController.navigate("koleksi/$itemIndex") }) {
                                    Text(
                                        text = "Koleksi",
                                        fontFamily = worksans,
                                        fontSize = 15.sp,
                                        color = Color.Black
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
                            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                                item {
                                    Column {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 5.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row {
                                                OutlinedCard(
                                                    colors = CardDefaults.cardColors(greenku),
                                                    modifier = Modifier.size(
                                                        height = 32.dp,
                                                        width = 70.dp
                                                    ),
                                                    shape = RoundedCornerShape(15.dp)
                                                ) {
                                                    Box(
                                                        contentAlignment = Alignment.Center,
                                                        modifier = Modifier.fillMaxSize()
                                                    ) {
                                                        Text(
                                                            text = "Buka",
                                                            fontFamily = worksanssemibold,
                                                            color = Color.White,
                                                            fontSize = 16.sp
                                                        )
                                                    }
                                                }
                                            }
                                            Text(
                                                text = museumData.openingHours,
                                                fontFamily = worksans,
                                                color = greenku,
                                                fontSize = 15.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(14.dp))
                                        Text(
                                            text = museumData.description,
                                            fontFamily = worksans,
                                            fontSize = 15.sp,
                                            textAlign = TextAlign.Justify,
                                            modifier = Modifier.padding(5.dp),
                                            lineHeight = 21.sp
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                imageVector = Icons.Default.LocationOn,
                                                contentDescription = "",
                                                tint = greenku
                                            )
                                            TextButton(onClick = { /*TODO*/ }) {
                                                Text(
                                                    text = museumData.address,
                                                    color = Color.Black,
                                                    fontFamily = worksans,
                                                    fontSize = 14.sp
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                imageVector = Icons.Default.Phone,
                                                contentDescription = "",
                                                tint = greenku
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = museumData.phone,
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 14.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        Text(
                                            text = "Transport",
                                            fontFamily = worksansbold
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        museumData.transportInfo.forEach { transport ->
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    val iconRes = when (transport.type) {
                                                        "train" -> R.drawable.train
                                                        "bus" -> R.drawable.train
                                                        "taxi" -> R.drawable.train
                                                        else -> R.drawable.train
                                                    }
                                                    Icon(
                                                        painter = painterResource(id = iconRes),
                                                        contentDescription = "",
                                                        tint = greenku
                                                    )
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Text(
                                                        text = transport.name,
                                                        color = Color.Black,
                                                        fontFamily = worksans,
                                                        fontSize = 12.sp
                                                    )
                                                }
                                                Text(
                                                    text = transport.distance,
                                                    color = Color.Black,
                                                    fontFamily = worksans,
                                                    fontSize = 12.sp
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(10.dp))
                                        }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        Text(
                                            text = "Fasilitas",
                                            fontFamily = worksansbold
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        museumData.fasilitasInfo.forEach { fasilitas ->
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    val iconRes = when (fasilitas.type) {
                                                        "toilet" -> R.drawable.bathroom
                                                        "masjid" -> R.drawable.mosque
                                                        else -> R.drawable.mosque
                                                    }
                                                    Icon(
                                                        painter = painterResource(id = iconRes),
                                                        contentDescription = "",
                                                        tint = greenku
                                                    )
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Text(
                                                        text = fasilitas.name,
                                                        color = Color.Black,
                                                        fontFamily = worksans,
                                                        fontSize = 12.sp
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(10.dp))
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Event dalam waktu dekat",
                                            fontFamily = worksansbold
                                        )
                                        museumData.eventInfo.forEach { event ->
                                            Column(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Image(
                                                    painter = painterResource(id = event.image),
                                                    contentDescription = event.name,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .size(200.dp)
                                                )
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceAround
                                                ) {
                                                    Text(
                                                        text = event.name,
                                                        color = Color.Black,
                                                        fontFamily = worksansmedium,
                                                        fontSize = 14.sp,
                                                        maxLines = 2,
                                                        overflow = TextOverflow.Ellipsis,
                                                        modifier = Modifier.weight(1f)
                                                    )
                                                    Spacer(modifier = Modifier.width(39.dp))
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Icon(
                                                            imageVector = Icons.Default.DateRange,
                                                            contentDescription = "",
                                                            tint = greenku
                                                        )
                                                        Spacer(modifier = Modifier.width(4.dp))
                                                        Text(
                                                            text = event.date,
                                                            color = Color.Black,
                                                            fontFamily = worksansmedium,
                                                            fontSize = 12.sp,
                                                            maxLines = 1
                                                        )
                                                    }
                                                }
                                                Spacer(modifier = Modifier.height(10.dp))
                                            }
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
