package com.swakarya.museumyog.presentation.informasikoleksi

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.gambar
import com.swakarya.museumyog.app.component.rating
import com.swakarya.museumyog.app.component.tittle
import com.swakarya.museumyog.component.ImageSliderWithIndicator
import com.swakarya.museumyog.data.model.imageMuseum
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun informationpage(photos: Array<Int> ,
                    name : Array<String>,
                    rate : Array<String>,
                    itemIndex: Int?,
    navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { navController.navigate(route = "pay1/$itemIndex")},
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
            ImageSliderWithIndicator(imageMuseum = imageMuseum,
                itemIndex)
            Box() {
                IconButton(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                    onClick = {  navController.navigate(route = "listMuseum")}) {
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
                            val ItemCount = 1
                            items(ItemCount) { item ->
                                Box {
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
                                                    modifier = Modifier.size(height = 32.dp, width = 70.dp),
                                                    shape = RoundedCornerShape(15.dp)
                                                ) {
                                                    Box(contentAlignment = Alignment.Center,
                                                        modifier = Modifier.fillMaxSize()){
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
                                                text = "08.00-13.30 WIB",
                                                fontFamily = worksans,
                                                color = greenku,
                                                fontSize = 15.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(14.dp))
                                        Text(
                                            text = "Keraton Yogyakarta sebagai salah satu pilar utama berdirinya Republik Indonesia tentunya memiliki sejarah panjang perjuangannya dari era Kolonial hingga sekarang ini. Sejarah panjang tersebut tentunya berguna bagi masa depan generasi muda untuk bisa mengetahui serta memahani perjuangan yang telah dilakukan. Oleh karena itu Keraton Yogyakarta sebagai institusi budaya dan perjuangan bangsa berkewajiban mendokumentasikan perjuangannya kepada masyarakat dengan membangun wisata museum sebagai pusat dokumentasi sejarah perjuangan Keraton Yogyakarta.",
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
                                                    text = "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
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
                                                text = "082226373138",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 14.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.watch),
                                                contentDescription = "",
                                                tint = greenku
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = "Buka setiap hari: 08.00 - 13.30 WIB\n" +
                                                        "Khusus hari jumat: 08.00 - 13.00 WIB\n" +
                                                        "Libur pada upacara kebesaran Keraton",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 14.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Transport",
                                            fontFamily = worksansbold
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.train),
                                                    contentDescription = "",
                                                    tint = greenku
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Text(
                                                    text = "Stasiun Lempuyangan",
                                                    color = Color.Black,
                                                    fontFamily = worksans,
                                                    fontSize = 12.sp
                                                )
                                            }
                                            Text(
                                                text = "100m",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 12.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.train),
                                                    contentDescription = "",
                                                    tint = greenku
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Text(
                                                    text = "Stasiun Yogyakarta",
                                                    color = Color.Black,
                                                    fontFamily = worksans,
                                                    fontSize = 12.sp
                                                )
                                            }
                                            Text(
                                                text = "100m",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 12.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Fasilitas",
                                            fontFamily = worksansbold
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.mosque),
                                                contentDescription = "",
                                                tint = greenku
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = "Mushola",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 12.sp
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(14.dp))

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.bathroom),
                                                contentDescription = "",
                                                tint = greenku
                                            )
                                            Spacer(modifier = Modifier.width(12.dp))
                                            Text(
                                                text = "Toilet",
                                                color = Color.Black,
                                                fontFamily = worksans,
                                                fontSize = 12.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Text(
                                            text = "Event dalam waktu dekat",
                                            fontFamily = worksansbold
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.event),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .size(200.dp)
                                        )
                                        Text(
                                            text = "Terdekat Dari ini",
                                            fontFamily = worksansbold
                                        )
                                        Spacer(modifier = Modifier.height(12.dp))

                                    }

                                }
                            }
                            item {
                                LazyRow {
                                    val indexitem = gambar.size
                                    items(indexitem) { item ->
                                        RowItem(
                                            itemIndex = item,
                                            painter = gambar,
                                            judul = tittle,
                                            ratings = rating
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
}

@Composable
fun RowItem(
    itemIndex: Int,
    painter: Array<Int>,
    judul: Array<String>,
    ratings: Array<String>
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize(), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(140.dp)
            )
            Text(text = judul[itemIndex])
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.elipes),
                        contentDescription = "",
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Buka",
                        fontSize = 20.sp,
                        fontFamily = worksans,
                        color = Color.White,
                        modifier = Modifier.offset(x = 15.dp, y = 24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color.Yellow,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    text = ratings[itemIndex],
                    fontFamily = worksansbold,
                    fontSize = 20.sp
                )
            }
        }
    }
}
@Preview
@Composable
fun InformationPagePreview() {
    informationpage(
        photos = arrayOf(1, 2, 3),
        name = arrayOf("Name 1", "Name 2", "Name 3"),
        rate = arrayOf("Rate 1", "Rate 2", "Rate 3"),
        itemIndex = 0,
        navController = rememberNavController()
    )
}