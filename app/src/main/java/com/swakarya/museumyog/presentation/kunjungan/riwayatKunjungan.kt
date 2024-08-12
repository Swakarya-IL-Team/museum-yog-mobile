package com.swakarya.museumyog.presentation.kunjungan

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.BottomBar
import com.swakarya.museumyog.app.component.SharedVariables
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku1
import com.swakarya.museumyog.ui.theme.orenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatKunjungan(navController: NavController) {
    val currentDate = LocalDate.now()
    val historyVisits = remember {
        SharedVariables.activeVisits.filter {
            LocalDate.parse(it.expiryDate, DateTimeFormatter.ISO_DATE).isBefore(currentDate)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
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
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
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
                for ((index, visit) in historyVisits.withIndex()) {
                    ColumnRiwayatMuseum(
                        visit = visit,
                        itemIndex = index,
                        navController = navController
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
                    TextButton(onClick = { navController.navigate("aktifkunjungan") }) {
                        Box(
                            modifier = Modifier
                                .background(greenku, CircleShape)
                                .padding(horizontal = 3.dp, vertical = 2.dp)
                                .sizeIn(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${SharedVariables.activeVisits.filter { LocalDate.parse(it.expiryDate, DateTimeFormatter.ISO_DATE).isAfter(LocalDate.now()) }.size}",
                                fontFamily = worksansbold,
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Aktif",
                            fontFamily = worksans,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextButton(onClick = { navController.navigate("riwayatkunjungan") }) {
                            Text(
                                text = "Riwayat",
                                fontFamily = worksanssemibold,
                                fontSize = 16.sp,
                                color = greenku
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.line),
                            contentDescription = ""
                        )
                    }

                }
                Divider(
                    modifier = Modifier.padding(bottom = 29.dp),
                    color = Color.Gray, thickness = 1.dp
                )
            }
        }
    }
}

@Composable
fun ColumnRiwayatMuseum(
    visit: SharedVariables.Visit,
    itemIndex: Int,
    navController: NavController
) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formattedOrderDate = LocalDate.parse(visit.date, DateTimeFormatter.ISO_DATE).format(formatter)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
                    .size(width = 132.dp, height = 111.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = visit.imageRes),
                    contentDescription = "Image Museum",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize(),
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
                )
            }

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(start = 14.dp),
                    text = visit.name,
                    fontFamily = worksanssemibold,
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp, start = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Selesai",
                        fontFamily = worksansmedium,
                        fontSize = 12.sp,
                        color = greyku1
                    )
                    Divider(
                        modifier = Modifier
                            .width(12.dp)
                            .rotate(90f)
                    )
                    Text(
                        text = formattedOrderDate,
                        fontFamily = worksans,
                        fontSize = 12.sp,
                        color = greyku1
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { navController.navigate(route = "reviewUser/$itemIndex") },
                        modifier = Modifier
                            .padding(bottom = 6.dp)
                            .heightIn(30.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, orenku)
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.icon_comment),
                            contentDescription = "Icon Comment",
                            tint = orenku
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Tulis Testimoni, Yuk!",
                            fontFamily = worksansmedium,
                            fontSize = 12.sp,
                            color = orenku
                        )
                    }
                }

            }
        }
    }
}
