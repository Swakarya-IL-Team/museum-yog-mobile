package com.swakarya.museumyog.presentation.Payment

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.SharedVariables.total1
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VA(navController: NavHostController,
       itemIndex: Int?) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(text = "Info Pembayaran",
                    fontFamily = worksansbold,
                    fontSize = 20.sp)
            }
            },
                navigationIcon =  {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = greenku,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { navController.navigate("tiket/$itemIndex") })
                    }
                },)
        }
    ){
        Box(modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Rp"+"$total1",
                    fontFamily = worksansbold,
                    fontSize = 20.sp,
                    color = greenku)
                Text(text = "Segera lakukan pembayaran sejumlah nominal di atas",
                    textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(10.dp))
                Box(modifier = Modifier.size(width = 500.dp, height = 80.dp)){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.mandiri),
                            contentDescription = "",
                            modifier = Modifier.size(100.dp))
                        Divider(
                            color = greyku,
                            modifier = Modifier
                                .height(50.dp)
                                .width(1.dp)
                        )
                        Text(text = "4745534312345",
                            fontSize = 20.sp)
                    }
                }
                Divider(color = Color.Gray, thickness = 1.dp)
            }
            Text(text = "Virtual Account:",
                fontFamily = worksans,
                modifier = Modifier.offset(x = 190.dp,  y = 140.dp))
            Column(modifier = Modifier.offset(x = 10.dp , y = 250.dp)) {
                Text(text = "Cara Transfer ATM-Mandiri",
                    fontFamily = worksansbold)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "1. Kunjungi ATM Mandiri terdekat.\n" +
                        "2. Masukkan kartu ATM dan PIN.\n" +
                        "3. Pilih menu “Bayar/Beli” dan kemudian “Multi Payment.”\n" +
                        "4. Masukkan Kode Perusahaan dan nomor Virtual Account.\n" +
                        "5. Input jumlah tagihan dan konfirmasi transaksi.\n" +
                        "6. Simpan struk sebagai bukti pembayaran.")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Cara Transfer M-Banking",
                    fontFamily = worksansbold)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "1. Login ke aplikasi Livin’ by Mandiri.\n" +
                        "2. Pilih menu “Pembayaran Baru” dan kemudian “Multi Payment.”\n" +
                        "3. Pilih penyedia jasa atau service provider.\n" +
                        "4. Masukkan nomor Virtual Account dan nominal pembayaran.\n" +
                        "5. Konfirmasi transaksi dengan memasukkan PIN Livin’ by Mandiri")
            }

        }
    }
}