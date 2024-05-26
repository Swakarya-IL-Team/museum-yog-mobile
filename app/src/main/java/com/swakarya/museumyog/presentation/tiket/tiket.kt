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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@Preview
@Composable
fun tiket(){
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Box(modifier = Modifier
                .size(width = 400.dp, height = 700.dp)
                .clip(RectangleShape)
                .background(greenku))

            Box(modifier = Modifier
                .size(width = 400.dp, height = 150.dp)
                .clip(RectangleShape)
                .background(Color.White))
        }
        Image(painter = painterResource(id = R.drawable.tiket),
            contentDescription = "",
            modifier = Modifier
                .size(width = 400.dp, height = 750.dp)
                .shadow(15.dp))
        Icon(imageVector = Icons.Default.Check,
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .offset(x = 0.dp, y = 90.dp),
            tint = Color.White)
        Column(modifier = Modifier.offset(x = 0.dp, y = 180.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Rp. 17.000",
                fontFamily = worksansbold,
                fontSize = 35.sp,
                color = greenku)
            Text(text = "Pembayaran berhasil",
                fontFamily = worksans,
                fontSize = 15.sp,
                color = greenku)
        }
        Column(modifier = Modifier.offset(x = 0.dp, y = 364.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Museum Keraton\n" +
                    "Ngayogyakarta Hadiningrat",
                fontFamily = worksansbold,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center)
            Text(text = "Tanggal Pemesanan: 19 Mar 2023  13:48",
                fontFamily = worksans,
                fontSize = 10.sp,
                color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Black,
                modifier = Modifier
                    .height(1.dp)
                    .width(300.dp))
        }
        Column(modifier = Modifier.offset(x = 0.dp, y = 450.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "XYZ-123",
                fontFamily = worksansbold,
                fontSize = 40.sp,
                color = coklatku,
                textAlign = TextAlign.Center)
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_time),
                    contentDescription ="",
                    tint = coklatku)
                Text(text = "Berlaku sampai: 23/03/2024    18:00 WIB",
                    fontFamily = worksans,
                    fontSize = 10.sp,
                    color = Color.Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Weekdays",
                    fontFamily = worksans,
                    fontSize = 10.sp,
                    color = greenku)
                Divider(color = greenku,
                    modifier = Modifier
                        .height(15.dp)
                        .width(1.dp))
                Text(text = "Dewasa",
                    fontFamily = worksans,
                    fontSize = 10.sp,
                    color = greenku)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Black,
                modifier = Modifier
                    .height(1.dp)
                    .width(300.dp))
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.size(width = 350.dp, height = 60.dp)
                .offset(x=  0.dp, y = 770.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(greenku)) {
            Text(text = "Selesai",
                fontFamily = worksansbold,
                fontSize = 25.sp)
        }
    }
}