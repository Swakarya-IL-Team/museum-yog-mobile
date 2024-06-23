package com.swakarya.museumyog.presentation.Payment

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.material3.TopAppBar
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
import com.swakarya.museumyog.app.component.CircularCheckbox
import com.swakarya.museumyog.app.component.SharedVariables
import com.swakarya.museumyog.app.component.SharedVariables.checked
import com.swakarya.museumyog.app.component.SharedVariables.checked1
import com.swakarya.museumyog.app.component.SharedVariables.family
import com.swakarya.museumyog.app.component.SharedVariables.student
import com.swakarya.museumyog.app.component.SharedVariables.total
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listpayment2(
    navController: NavHostController,
    name: Array<String>,
    itemIndex: Int?
) {
    val color = if (checked) greenku else greyku
    val color1 = if (checked1) greenku else greyku
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { navController.navigate("pay3/$itemIndex") },
                        colors = ButtonDefaults.buttonColors(greenku),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 350.dp, height = 60.dp)
                    ) {
                        Text(text = "Pesan Tiket")
                    }

                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = name[itemIndex!!],
                            fontFamily = worksanssemibold,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("pay1/$itemIndex") }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = greenku,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
            )
        }
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = 60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TextButton(onClick = { navController.navigate("pay1/$itemIndex") }) {
                        Text(
                            text = "Tiket Satuan",
                            fontFamily = worksansbold,
                            color = greyku
                        )

                    }
                    TextButton(onClick = { navController.navigate("pay2/$itemIndex") }) {
                        Text(
                            text = "Paket",
                            fontFamily = worksans,
                            color = greenku
                        )

                    }
                }
                Divider(
                    color = greyku, thickness = 1.dp,
                    modifier = Modifier.offset(x = 0.dp, y = 100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "",
                    modifier = Modifier
                        .offset(x = 270.dp, y = 52.dp)
                        .size(100.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.verticalScroll(rememberScrollState())
                .padding(bottom = 90.dp)) {
                Text(
                    text = "Pilih Paket Wisata",
                    fontFamily = worksansbold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Row(
                    modifier = Modifier.padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.dangercircle),
                        contentDescription = "",
                        tint = coklatku,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "1 Pembelian paket hanya berlaku untuk 1 akun",
                        fontFamily = worksans,
                        fontSize = 12.sp
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(2.dp, color),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(modifier = Modifier.padding(23.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Family Package Tour",
                                fontFamily = worksansbold,
                                fontSize = 16.sp
                            )
                            CircularCheckbox(
                                checked = checked,
                                onCheckedChange = {
                                    checked = it
                                    if (checked) total += family else total -= family
                                }
                            )
                        }
                        Text(
                            text = "Benefit :\n" +
                                    "1. Mendapatkan tour guide Bersama minimal 4 keluarga.\n" +
                                    "2. voucher merchandise\n" +
                                    "3. Gratis wahana membatik untuk anak-anak.\n",
                            fontFamily = worksans,
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Syarat :\n" +
                                    "1. Maksimal anggota keluarga terdiri dari 4 orang.",
                            fontFamily = worksans,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Rp " + "$family" + "/Pack",
                            fontFamily = worksansbold,
                            color = greenku,
                            fontSize = 16.sp
                        )

                    }
                }
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(2.dp, color1),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(modifier = Modifier.padding(23.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Student Package Tour",
                                fontFamily = worksansbold,
                                fontSize = 16.sp
                            )
                            CircularCheckbox(
                                checked = checked1,
                                onCheckedChange = {
                                    checked1 = it
                                    if (checked1) total += student else total -= student
                                })
                        }
                        Text(
                            text = "Benefit :\n"+
                                    "1. Mendapatkan tour guide. \n" +
                                    "2. voucher merchandise.\n" +
                                    "3. Diskon wahana membatik free perlengkapan\n",
                            fontFamily = worksans,
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Rp " + "$family" + "/Pack",
                            fontFamily = worksansbold,
                            color = greenku,
                            fontSize = 16.sp
                        )

                    }
                }
                Text(
                    text = "Total",
                    fontFamily = worksansbold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "Total Rp ${SharedVariables.total}",
                    fontFamily = worksansbold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListPaymentPreview2() {
    listpayment2(
        navController = rememberNavController(),
        name = arrayOf("Museum Keraton Ngayogyakarta"),
        itemIndex = 0
    )
}

