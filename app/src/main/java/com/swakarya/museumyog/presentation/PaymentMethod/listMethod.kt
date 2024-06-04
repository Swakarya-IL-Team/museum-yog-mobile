package com.swakarya.museumyog.presentation.PaymentMethod

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.app.component.SharedVariables.bankpay
import com.swakarya.museumyog.app.component.SharedVariables.pay
import com.swakarya.museumyog.app.component.SharedVariables.total1
import com.swakarya.museumyog.app.component.getDummybankList
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)@Composable
fun method(navController: NavHostController,
           itemIndex: Int?){
    val colorboxots = if(bankpay) greyku else greenku
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { navController.navigate("pay3/$itemIndex") },
                        colors = ButtonDefaults.buttonColors(greenku),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 350.dp, height = 60.dp)) {
                        Text(text ="Pilih pembayaran")
                    }

                }
            }
        },
        topBar = {
            TopAppBar(title = { Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(text = "Metode Pembayaran",
                    fontFamily = worksansbold,
                    fontSize = 20.sp)
            }
            },
                navigationIcon =  {
                    IconButton(onClick = { navController.navigate("pay3")}) {
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
                .padding(top = 90.dp, bottom = 90.dp)) {
            LazyColumn(contentPadding = PaddingValues(20.dp),
                state = rememberLazyListState()
            ) {
                item{
                    Text(text = "On The Spot",
                        fontFamily = worksansbold,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier
                        .size(width = 400.dp, height = 100.dp)
                        .border(
                            BorderStroke(width = 1.dp, color = colorboxots),
                            shape = RoundedCornerShape(20)
                        )
                        .clickable {bankpay = false
                            pay = true},
                        Alignment.Center
                    ){
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            Text(text = "Rp"+"$total1",
                                fontFamily = worksansbold,
                                fontSize = 20.sp,
                                color = colorboxots )
                            Text(text = "(Bayar di tempat)",
                                fontFamily = worksans,
                                fontSize = 12.sp,
                                color = colorboxots )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = "Transfer Bank/M-Banking",
                        fontFamily = worksansbold,
                        fontSize = 14.sp)
                    Text(text = "Pembayaran cepat dan mudah",
                        fontFamily = worksans,
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                }
                items(getDummybankList(),key = {it.id}){ bank ->
                    Itembank(gambar = bank.gambar,
                        navController = navController)
                }

            }
        }

    }
}

@Composable
fun Itembank(gambar: Int,
             navController: NavHostController) {
    val colorboxbank = if(bankpay) greenku else greyku
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)){
        Box(modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(width = 1.dp, color = colorboxbank),
                shape = RoundedCornerShape(20)
            )
            .padding(10.dp)
            .clickable {pay = true
            bankpay = true}) {
            Image(painter = painterResource(id = gambar),
                contentDescription ="",
                modifier = Modifier.size(83.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription ="" ,
                modifier = Modifier.size(30.dp)
                    .offset(x = 280.dp, y = 25.dp),
                tint = greenku)
        }

    }

}
