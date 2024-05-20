package com.swakarya.museumyog.presentation.kunjungan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.BottomBar
import com.swakarya.museumyog.data.model.dateOrderMuseum
import com.swakarya.museumyog.data.model.imageOrderMuseum
import com.swakarya.museumyog.data.model.nameOrderMuseum
import com.swakarya.museumyog.presentation.Payment.listPayment
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.orenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AktifKunjungan(navController: NavController) {
    var activeCount by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Kunjungan Saya",
                        fontFamily = worksanssemibold,
                        fontSize = 20.sp
                    )

                }

            })
        },
        bottomBar = { BottomBar() }
    )

    { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(top = 90.dp)
            ) {
                val ItemLazyCount = imageOrderMuseum.size
                activeCount = ItemLazyCount
                for (index in 0 until ItemLazyCount) {
                    ColumnMuseumAktif(
                        itemIndex = index,
                        painter = imageOrderMuseum,
                        tittle = nameOrderMuseum,
                        dateOrderMuseum = dateOrderMuseum
                    )
                }

            }


            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .background(Color.White)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextButton(onClick = { navController.navigate("aktif") }) {

                            Box(
                                modifier = Modifier
                                    .background(greenku, CircleShape)
                                    .padding(horizontal = 3.dp, vertical = 2.dp)
                                    .sizeIn(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$activeCount",
                                    fontFamily = worksansbold,
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Aktif",
                                fontFamily = worksanssemibold,
                                fontSize = 16.sp,
                                color = greenku
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.line),
                            contentDescription = "",

                            )

                        }
                    TextButton(onClick = { navController.navigate("riwayat") }) {
                            Text(
                                text = "Riwayat",
                                fontFamily = worksans,
                                fontSize = 16.sp,
                                color = Color.Black

                            )
                    }

                }

                Divider(
                    color = Color.Gray, thickness = 1.dp
                )
            }
        }
    }

}

@Composable
fun ColumnMuseumAktif(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    dateOrderMuseum: Array<String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 132.dp, height = 111.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = painter[itemIndex]),
                    contentDescription = "Image Museum",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier.padding(start = 14.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = tittle[itemIndex],
                    fontFamily = worksanssemibold,
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier.padding(top = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(14.dp),
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = "Icon Time",
                        tint = orenku
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = dateOrderMuseum[itemIndex],
                        fontFamily = worksans,
                        fontSize = 10.sp
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .heightIn(30.dp),
                    colors = ButtonDefaults.buttonColors(greenku),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Buka Tiket",
                        fontFamily = worksansmedium,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
@Preview
@Composable
private fun kunjungan() {
    MuseumYogTheme {
        AktifKunjungan(navController = rememberNavController())
    }
}
