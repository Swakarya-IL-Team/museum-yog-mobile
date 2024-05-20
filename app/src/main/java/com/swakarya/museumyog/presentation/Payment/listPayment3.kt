package com.swakarya.museumyog.presentation.Payment

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.component.SharedVariables
import com.swakarya.museumyog.component.SharedVariables.admin
import com.swakarya.museumyog.component.SharedVariables.bankpay
import com.swakarya.museumyog.component.SharedVariables.pay
import com.swakarya.museumyog.component.SharedVariables.total
import com.swakarya.museumyog.component.SharedVariables.total1
import com.swakarya.museumyog.component.TicketShape
import com.swakarya.museumyog.component.calender
import com.swakarya.museumyog.component.dropdown
import com.swakarya.museumyog.component.getDummyList
import com.swakarya.museumyog.component.voucher
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.orenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listpayment3(navController: NavHostController) {
    val colorbutton = if(pay) greenku else greyku
    val textbank = if(bankpay)"Tranfer Bank" else "OTS"
    val textcolor = if(pay) Color.White else orenku
    val boxcolor = if(pay) orenku else Color.White
    total1 = total + admin
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { if(pay)navController.navigate("va")
                    else navController.navigate("pay3") },
                        colors = ButtonDefaults.buttonColors(colorbutton),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 350.dp, height = 60.dp)) {
                        Text(text ="Pesan")
                    }

                }
            }
        },
        topBar = {
            TopAppBar(title = { Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(text = "Konfirmasi Pemesanan",
                    fontFamily = worksansbold,
                    fontSize = 18.sp)
            }
            },
                navigationIcon =  {
                    IconButton(onClick = { navController.navigate("pay2")}) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = greenku,
                            modifier = Modifier.size(30.dp))
                    }
                },)
        }
    ){
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 90.dp)) {
            LazyColumn(contentPadding = PaddingValues(20.dp),
                state = rememberLazyListState()) {
                items(getDummyList().filter { it.banyak > 0},key = {it.id}){ tiket->
                    ItemList(judul = tiket.title,
                        banyak = tiket.banyak,
                        ket = tiket.ket)

                }
                item{

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
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Total",
                            fontFamily = worksansbold,
                            fontSize = 14.sp)
                        Box(modifier = Modifier.fillMaxWidth(),
                            Alignment.CenterEnd){
                            Text(text = "$total",
                                fontFamily = worksansbold,
                                fontSize = 14.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Voucher",
                            fontFamily = worksansbold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(10.dp))
                        Spacer(modifier = Modifier.width(80.dp))
                        voucher()
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Metode Pembayaran:",
                            fontFamily = worksansbold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(10.dp))
                        Spacer(modifier = Modifier.width(65.dp))
                        Box(modifier = Modifier
                            .size(width = 150.dp, height = 40.dp)
                            .border(
                                BorderStroke(width = 2.dp, color = orenku),
                                shape = RoundedCornerShape(20)
                            )
                            .background(boxcolor)
                            .clickable { navController.navigate("method") }
                        ){
                            Box(modifier = Modifier.fillMaxSize().padding(start = 5.dp),
                                Alignment.CenterStart){
                                Text(text = "$textbank",
                                    fontFamily = worksans,
                                    fontSize = 14.sp,
                                    color = textcolor)
                            }
                            Box(modifier = Modifier.fillMaxSize().padding(end = 2.dp),
                                Alignment.CenterEnd){
                                Icon(imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription ="",
                                    tint = textcolor)
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Order Subtotal",
                            fontFamily = worksansbold,
                            fontSize = 14.sp)
                        Box(modifier = Modifier.fillMaxWidth(),
                            Alignment.CenterEnd){
                            Text(text = "$total",
                                fontFamily = worksansbold,
                                fontSize = 14.sp)
                        }
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Biaya Admin",
                            fontFamily = worksansbold,
                            fontSize = 14.sp)
                        Box(modifier = Modifier.fillMaxWidth(),
                            Alignment.CenterEnd){
                            Text(text = "$admin",
                                fontFamily = worksansbold,
                                fontSize = 14.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Total Harga",
                            fontFamily = worksansbold,
                            fontSize = 16.sp,
                            color = greenku)
                        Box(modifier = Modifier.fillMaxWidth(),
                            Alignment.CenterEnd) {
                            Text(text = "$total1",
                                fontFamily = worksansbold,
                                fontSize = 16.sp,
                                color = greenku)
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun ItemList(judul: String,
             banyak : Int,
             ket: String) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)){
        Box(
            modifier = Modifier
                .clip(TicketShape())
                .background(Color.Transparent)
                .size(width = 400.dp, height = 123.dp)
                .border(3.dp, greenku, TicketShape())
        ){
            Text(text = "Tiket",
                modifier = Modifier
                    .offset(x = 0.dp, y = 50.dp)
                    .rotate(-90f),
                fontFamily = worksansbold,
                color = greenku,
                fontSize = 14.sp)
            Column(modifier = Modifier
                .offset(x = 120.dp, y = 20.dp)
                .fillMaxWidth()) {
                Text(text = "Museum Keraton Ngayogyakarta \n Hadiningrat",
                    fontFamily = worksansbold,
                    fontSize = 14.sp)
                Text(text = ket,
                    fontFamily = worksans,
                    color = greenku,
                    fontSize = 12.sp)
                Text(text = judul,
                    fontFamily = worksans,
                    color = greenku,
                    fontSize = 12.sp)
                Text(text = "x$banyak",
                    fontFamily = worksans,
                    color = greenku,
                    fontSize = 12.sp)
            }

        }
    }

}

@Preview
@Composable
fun pre(){
    val navController = rememberNavController()
    listpayment3(navController)
}