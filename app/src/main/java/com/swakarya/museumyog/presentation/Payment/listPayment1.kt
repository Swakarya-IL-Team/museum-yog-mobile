package com.swakarya.museumyog.presentation.Payment

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.swakarya.museumyog.app.component.SharedVariables
import com.swakarya.museumyog.app.component.SharedVariables.anak
import com.swakarya.museumyog.app.component.SharedVariables.dewasa
import com.swakarya.museumyog.app.component.SharedVariables.mhs
import com.swakarya.museumyog.app.component.SharedVariables.total
import com.swakarya.museumyog.app.component.SharedVariables.weekend
import com.swakarya.museumyog.app.component.SharedVariables.wekndanak
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysanak
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysdewasa
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysmhs
import com.swakarya.museumyog.app.component.SharedVariables.weknddewasa
import com.swakarya.museumyog.app.component.SharedVariables.wekndmhs
import com.swakarya.museumyog.app.component.calender
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold
import java.time.DayOfWeek
import java.time.LocalDate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listPayment(
    navController: NavHostController,
    name: Array<String>,
    itemIndex: Int?
) {
    var weekend = weekend

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

                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = "informasi/$itemIndex") }) {
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
        Column(modifier = Modifier.padding(bottom = 100.dp)) {
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
                            color = greenku
                        )

                    }
                }
                Divider(
                    color = greyku, thickness = 1.dp,
                    modifier = Modifier.offset(x = 0.dp, y = 100.dp)
                )
                Divider(
                    color = greenku,
                    modifier = Modifier
                        .offset(x = 120.dp, y = 100.dp)
                        .size(width = 150.dp, height = 3.dp)
                )
            }
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "Mau berkunjung waktu apa?",
                fontFamily = worksansbold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Tanggal Kunjungan",
                fontFamily = worksansbold,
                fontSize = 14.sp,
                modifier = Modifier.padding(10.dp))
            Box(modifier = Modifier.fillMaxWidth(),
                Alignment.Center) {
                calender(
                    value = SharedVariables.date.value,
                    onValueChange = { SharedVariables.date.value = it}
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Pilih Jenis Tiket",
                fontFamily = worksansbold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Anak-anak",
                        fontFamily = worksansbold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "(0-10 tahun)",
                        fontFamily = worksans,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Rp" + if (weekend) "$wekndanak" else "$wekndaysanak",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color = greenku
                    )
                }
                Spacer(modifier = Modifier.width(125.dp))
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(1.dp)) {
                    Image(painter = painterResource(id = R.drawable.minusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if ((anak != 0) and (weekend)) {
                                    anak--
                                    total -= wekndanak
                                } else if ((anak != 0) and (!weekend)) {
                                    anak--
                                    total -= wekndaysanak
                                } else {
                                    anak = 0
                                }
                            })
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Black),
                        modifier = Modifier
                            .padding(4.dp)
                            .size(height = 35.dp, width = 50.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "$anak",
                                fontSize = 25.sp
                            )
                        }
                    }
                    Image(painter = painterResource(id = R.drawable.plusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if (weekend) {
                                    anak++
                                    total += wekndanak
                                } else if (!weekend) {
                                    anak++
                                    total += wekndaysanak
                                }
                            })
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Mahasiswa",
                        fontFamily = worksansbold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "(wajib menunjukkan KTM)",
                        fontFamily = worksans,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Rp" + if (weekend) "$wekndmhs" else "$wekndaysmhs",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color = greenku
                    )
                }
                Spacer(modifier = Modifier.width(75.dp))
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(1.dp)) {
                    Image(painter = painterResource(id = R.drawable.minusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if ((mhs != 0) and (weekend)) {
                                    mhs--
                                    total -= wekndmhs
                                } else if ((mhs != 0) and (!weekend)) {
                                    mhs--
                                    total -= wekndaysmhs
                                } else {
                                    mhs = 0
                                }
                            })
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Black),
                        modifier = Modifier
                            .padding(4.dp)
                            .size(height = 35.dp, width = 50.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "$mhs",
                                fontSize = 25.sp
                            )
                        }
                    }
                    Image(painter = painterResource(id = R.drawable.plusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if (weekend) {
                                    mhs++
                                    total += wekndmhs
                                } else if (!weekend) {
                                    mhs++
                                    total += wekndaysmhs
                                }
                            })
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Dewasa",
                        fontFamily = worksansbold,
                        fontSize = 20.sp
                    )

                    Text(
                        text = "Rp" + if (weekend) "$weknddewasa" else "$wekndaysdewasa",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color = greenku
                    )
                }
                Spacer(modifier = Modifier.width(155.dp))
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(1.dp)) {
                    Image(painter = painterResource(id = R.drawable.minusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if ((dewasa != 0) and (weekend)) {
                                    dewasa--
                                    total -= weknddewasa
                                } else if ((dewasa != 0) and (!weekend)) {
                                    dewasa--
                                    total -= wekndaysdewasa
                                } else {
                                    dewasa = 0
                                }
                            })
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Black),
                        modifier = Modifier
                            .padding(4.dp)
                            .size(height = 35.dp, width = 50.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "$dewasa",
                                fontSize = 25.sp
                            )
                        }
                    }
                    Image(painter = painterResource(id = R.drawable.plusbutton),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                if (weekend) {
                                    dewasa++
                                    total += weknddewasa
                                } else if (!weekend) {
                                    dewasa++
                                    total += wekndaysdewasa
                                }
                            })
                }

            }
            Spacer(modifier = Modifier.height(110.dp))
            Text(
                text = "Jumlah Tiket",
                fontFamily = worksanssemibold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(1.dp)
            ) {
                Text(
                    text = "Total: ",
                    fontFamily = worksanssemibold,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = "Rp.$total",
                    fontFamily = worksansbold,
                    fontSize = 20.sp
                )
            }

        }

    }
}

@Preview
@Composable
fun ListPaymentPreview() {
    listPayment(
        navController = rememberNavController(),
        name = arrayOf("Payment 1"),
        itemIndex = 0
    )
}
