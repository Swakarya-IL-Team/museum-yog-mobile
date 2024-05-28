package com.swakarya.museumyog.presentation.informasikoleksi

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.swakarya.museumyog.app.component.gambar
import com.swakarya.museumyog.app.component.rating
import com.swakarya.museumyog.app.component.tittle
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

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
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { navController.navigate(route = "pay1/$itemIndex")},
                        colors = ButtonDefaults.buttonColors(greenku),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 350.dp, height = 60.dp)) {
                        Text(text ="Pesan Tiket")
                    }

                }
            }
        }
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
                    Row(horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.size(width = 300.dp , height = 70.dp)) {
                        Text(text = name[itemIndex],
                            fontFamily = worksansbold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(8.dp))
                    }
                    Row(horizontalArrangement = Arrangement.End) {
                        Icon(imageVector = Icons.Default.Star,
                            contentDescription ="",
                            tint = Color.Yellow,
                            modifier = Modifier.size(30.dp))
                        Text(text = rate[itemIndex],
                            fontFamily = worksansbold,
                            fontSize = 20.sp)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    TextButton(onClick = {navController.navigate(route = "informasi/$itemIndex")}) {
                        Text(text = "Deskripsi",
                            fontFamily = worksans,
                            fontSize = 15.sp,
                            color = greenku)
                    }
                    TextButton(onClick = { navController.navigate(route = "koleksi/$itemIndex") }) {
                        Text(text = "Koleksi",
                            fontFamily = worksans,
                            fontSize = 15.sp,
                            color = Color.Black)
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
                    .offset(x = 15.dp, y = 295.dp))

        }
        Column(modifier = Modifier.padding(start = 0.dp, top = 0.dp, bottom = 60.dp, end = 0.dp)) {
            Spacer(modifier = Modifier.height(350.dp))
            LazyColumn(contentPadding = PaddingValues(10.dp)) {
                val ItemCount = 1
                items(ItemCount){item ->
                    Box {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box() {
                                    Image(painter = painterResource(id = R.drawable.elipes),
                                        contentDescription ="",
                                        modifier = Modifier.size(80.dp))
                                    Text(text = "Buka",
                                        fontSize = 20.sp,
                                        fontFamily = worksans,
                                        color = Color.White,
                                        modifier = Modifier.offset(x=15.dp,y=24.dp))
                                }
                                Spacer(modifier = Modifier.width(160.dp))
                                Text(text = "08.00-13.30 WIB",
                                    fontFamily = worksans,
                                    color = greenku,
                                    fontSize = 15.sp)
                            }
                            Text(text = "Keraton Yogyakarta sebagai salah satu pilar utama berdirinya Republik Indonesia tentunya memiliki sejarah panjang perjuangannya dari era Kolonial hingga sekarang ini. Sejarah panjang tersebut tentunya berguna bagi masa depan generasi muda untuk bisa mengetahui serta memahani perjuangan yang telah dilakukan. Oleh karena itu Keraton Yogyakarta sebagai institusi budaya dan perjuangan bangsa berkewajiban mendokumentasikan perjuangannya kepada masyarakat dengan membangun wisata museum sebagai pusat dokumentasi sejarah perjuangan Keraton Yogyakarta.",
                                fontFamily = worksans)
                            Spacer(modifier = Modifier.height(20.dp))
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = greenku)
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
                                        color = Color.Black,
                                        fontFamily = worksans,
                                        fontSize = 12.sp)
                                }
                            }
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(imageVector = Icons.Default.Phone,
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "082226373138",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.watch),
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Buka setiap hari: 08.00 - 13.30 WIB\n" +
                                        "Khusus hari jumat: 08.00 - 13.00 WIB\n" +
                                        "Libur pada upacara kebesaran Keraton",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = "Transport",
                                fontFamily = worksansbold)
                            Spacer(modifier = Modifier.height(12.dp))
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.train),
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Stasiun Lempuyangan",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(170.dp))
                                Text(text = "100m",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.train),
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Stasiun Yogyakarta",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(190.dp))
                                Text(text = "100m",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = "Fasilitas",
                                fontFamily = worksansbold)
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.mosque),
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Mushola",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }

                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "",
                                    tint = greenku)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Toilet",
                                    color = Color.Black,
                                    fontFamily = worksans,
                                    fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = "Event dalam waktu dekat",
                                fontFamily = worksansbold)
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(painter = painterResource(id = R.drawable.event),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(200.dp))
                            Text(text = "Terdekat Dari ini",
                                fontFamily = worksansbold)
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

@Composable
fun RowItem( itemIndex: Int,
             painter: Array<Int>,
             judul: Array<String>,
             ratings:Array<String>) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(140.dp))
            Text(text = judul[itemIndex])
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box() {
                    Image(painter = painterResource(id = R.drawable.elipes),
                        contentDescription ="",
                        modifier = Modifier.size(80.dp))
                    Text(text = "Buka",
                        fontSize = 20.sp,
                        fontFamily = worksans,
                        color = Color.White,
                        modifier = Modifier.offset(x=15.dp,y=24.dp))
                }
                Spacer(modifier = Modifier.width(30.dp))
                Icon(imageVector = Icons.Default.Star,
                    contentDescription ="",
                    tint = Color.Yellow,
                    modifier = Modifier.size(30.dp))
                Text(text = ratings[itemIndex],
                    fontFamily = worksansbold,
                    fontSize = 20.sp)
            }
        }
    }
}