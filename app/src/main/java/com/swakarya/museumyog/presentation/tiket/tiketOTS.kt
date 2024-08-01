package com.swakarya.museumyog.presentation.tiket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.SharedVariables
import com.swakarya.museumyog.data.model.nameMuseum
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.jogja
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun tiketOTS(
    navController: NavHostController,
    name: Array<String>,
    itemIndex: Int?
) {
    val parsedDate =
        LocalDate.parse(SharedVariables.date.value.toString(), DateTimeFormatter.ISO_DATE)
    val formattedOrderDate = parsedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    val expiryDate = parsedDate.plusDays(5)
    val formattedExpiryDate = expiryDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.TopCenter
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .size(width = 500.dp, height = 700.dp)
                        .background(greenku)
                )

                Box(
                    modifier = Modifier
                        .size(width = 500.dp, height = 150.dp)
                        .clip(RectangleShape)
                        .background(Color.White)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.tiket),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                alignment = Alignment.TopCenter
            )
            Column(
                modifier = Modifier.offset(x = 0.dp, y = 180.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rp" + "${SharedVariables.total1}",
                    fontFamily = worksansbold,
                    fontSize = 35.sp,
                    color = greenku
                )
                Text(
                    text = "Pembayaran berhasil",
                    fontFamily = worksans,
                    fontSize = 15.sp,
                    color = greenku
                )
            }
            Column(
                modifier = Modifier.padding(top = 390.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name[itemIndex!!],
                    fontFamily = worksansbold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 40.dp)
                )
                Text(
                    text = "Tanggal Pemesanan: $formattedOrderDate",
                    fontFamily = worksans,
                    fontSize = 10.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .height(1.dp)
                        .width(300.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.barcode),
                    contentDescription = "barcode",
                    modifier = Modifier.padding(top = 19.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = "",
                        tint = coklatku
                    )
                    Text(
                        text = "Berlaku sampai: $formattedExpiryDate",
                        fontFamily = worksans,
                        fontSize = 10.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Weekdays",
                        fontFamily = worksansmedium,
                        fontSize = 10.sp,
                        color = greenku
                    )
                    Divider(
                        color = greenku,
                        modifier = Modifier
                            .height(15.dp)
                            .width(1.dp)
                    )
                    Text(
                        text = "Dewasa",
                        fontFamily = worksans,
                        fontSize = 10.sp,
                        color = greenku
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .height(1.dp)
                        .width(300.dp)
                )
                Text(
                    text = "Berikan kode ini ke petugas museum sesuai jadwal kunjungan,apabila lewat dari jadwal, maka kode akan kadaluarsa otomatis.",
                    fontSize = 10.sp,
                    fontFamily = worksans,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(horizontal = 40.dp),
                    lineHeight = 16.sp,
                )
                Row(
                    modifier = Modifier.padding(top = 29.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tanaman_tiket),
                        contentDescription = "tanaman3",
                        modifier = Modifier.size(30.dp).graphicsLayer { scaleX = -1f }
                    )
                    Text(
                        text = "Sampai Bertemu \n di Museum!",
                        fontFamily = jogja,
                        fontSize = 24.sp,
                        color = greenku,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 13.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.tanaman_tiket),
                        contentDescription = "tanaman3",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { navController.navigate(route = "home") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(greenku),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(width = 350.dp, height = 60.dp)
            ) {
                Text(
                    text = "Selesai",
                    fontFamily = worksansbold,
                    fontSize = 25.sp
                )
            }
        }
    }

}

@Preview
@Composable
fun prevvvOTS() {
    val index = 3
    tiket(
        navController = rememberNavController(),
        name = nameMuseum,
        itemIndex = index
    )
}