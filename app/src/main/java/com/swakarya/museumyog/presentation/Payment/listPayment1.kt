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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.swakarya.museumyog.app.component.SharedVariables.anak
import com.swakarya.museumyog.app.component.SharedVariables.dewasa
import com.swakarya.museumyog.app.component.SharedVariables.mhs
import com.swakarya.museumyog.app.component.SharedVariables.total
import com.swakarya.museumyog.app.component.SharedVariables.wekndanak
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysanak
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysdewasa
import com.swakarya.museumyog.app.component.SharedVariables.wekndaysmhs
import com.swakarya.museumyog.app.component.SharedVariables.weknddewasa
import com.swakarya.museumyog.app.component.SharedVariables.wekndmhs
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listPayment(navController: NavHostController,
                itemIndex: Int?) {
    var weekend by remember { mutableStateOf(false) }
    val color = if(weekend) greenku else Color.Black
    val color1 = if(weekend) Color.Black else greenku
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { navController.navigate("pay3/$itemIndex")},
                        colors = ButtonDefaults.buttonColors(greenku),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 350.dp, height = 60.dp)) {
                        Text(text ="Pesan Tiket")
                    }

                }
            }
        },
        topBar = {
            TopAppBar(title = { Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(text = "Museum Keraton Ngayogyakarta",
                    fontFamily = worksansbold,
                    fontSize = 18.sp)
            }
            },
                navigationIcon =  {
                    IconButton(onClick = { navController.navigate(route = "informasi/$itemIndex")}) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = greenku,
                            modifier = Modifier.size(30.dp))
                    }
                },)
        }
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 0.dp, y = 60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    TextButton(onClick = { navController.navigate("pay1/$itemIndex") }) {
                        Text(text = "Tiket Satuan",
                            fontFamily = worksansbold,
                            color = greenku)

                    }
                    TextButton(onClick = { navController.navigate("pay2/$itemIndex")}) {
                        Text(text = "Paket",
                            fontFamily = worksans,
                            color = greyku)

                    }
                }
                Divider(color = greyku, thickness = 1.dp,
                    modifier = Modifier.offset(x = 0.dp, y = 100.dp))
                Image(painter = painterResource(id = R.drawable.line),
                    contentDescription ="",
                    modifier = Modifier
                        .offset(x = 63.dp, y = 52.dp)
                        .size(100.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Mau berkunjung waktu apa?",
                fontFamily = worksansbold,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { weekend=false
                                            total=0
                                            anak=0
                                            mhs=0
                                            dewasa=0
                                            total=0},
                    border = BorderStroke(1.dp, color1),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 150.dp, height = 60.dp)
                ) {
                    Text(text = "Weekdays\n(senin-jumat)",
                        color = color1,
                        textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { weekend=true
                                         total=0
                                         anak=0
                                         mhs=0
                                         dewasa=0
                                         total=0},
                    border = BorderStroke(1.dp, color) ,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 150.dp, height = 60.dp)
                ) {
                    Text(text = "Weekends\n(Sabtu-Minggu)",
                        color = color,
                        textAlign = TextAlign.Center)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Pilih Jenis Tiket",
                fontFamily = worksansbold,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Anak-anak",
                        fontFamily = worksansbold,
                        fontSize = 20.sp)
                    Text(text = "(0-10 tahun)",
                        fontFamily = worksans,
                        fontSize = 12.sp)
                    Text(text = "Rp"+if(weekend) "$wekndanak" else "$wekndaysanak",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color= greenku)
                }
                Spacer(modifier = Modifier.width(125.dp))
                Image(painter = painterResource(id = R.drawable.minusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
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
                Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .padding(4.dp)
                        .size(height = 40.dp, width = 60.dp),
                    shape = RoundedCornerShape(10.dp)) {
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()) {
                        Text(text = "$anak",
                            fontSize = 25.sp)
                    }
                }
                Image(painter = painterResource(id = R.drawable.plusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (weekend) {
                                anak++
                                total += wekndanak
                            } else if(!weekend){
                                anak++
                                total += wekndaysanak
                            }
                        })
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Mahasiswa",
                        fontFamily = worksansbold,
                        fontSize = 20.sp)
                    Text(text = "(wajib menunjukkan KTM)",
                        fontFamily = worksans,
                        fontSize = 12.sp)
                    Text(text = "Rp"+if(weekend) "$wekndmhs" else "$wekndaysmhs",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color= greenku)
                }
                Spacer(modifier = Modifier.width(75.dp))
                Image(painter = painterResource(id = R.drawable.minusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if ((mhs != 0) and  (weekend)) {
                                mhs--
                                total -= wekndmhs
                            } else if((mhs != 0) and (!weekend)){
                                mhs--
                                total -= wekndaysmhs
                            }
                            else {
                                mhs = 0
                            }
                        })
                Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .padding(4.dp)
                        .size(height = 40.dp, width = 60.dp),
                    shape = RoundedCornerShape(10.dp)) {
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()) {
                        Text(text ="$mhs",
                            fontSize = 25.sp)
                    }
                }
                Image(painter = painterResource(id = R.drawable.plusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (weekend) {
                                mhs++
                                total += wekndmhs
                            } else if(!weekend){
                                mhs++
                                total += wekndaysmhs
                            }
                        })
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Dewasa",
                        fontFamily = worksansbold,
                        fontSize = 20.sp)
                    Text(text = "",
                        fontFamily = worksans,
                        fontSize = 12.sp)
                    Text(text = "Rp"+if(weekend) "$weknddewasa" else "$wekndaysdewasa",
                        fontFamily = worksans,
                        fontSize = 15.sp,
                        color= greenku)
                }
                Spacer(modifier = Modifier.width(155.dp))
                Image(painter = painterResource(id = R.drawable.minusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if ((dewasa != 0) and  (weekend)) {
                                dewasa--
                                total -= weknddewasa
                            } else if((dewasa != 0) and (!weekend)){
                                dewasa--
                                total -= wekndaysdewasa
                            }
                            else {
                                dewasa = 0
                            }
                        })
                Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .padding(4.dp)
                        .size(height = 40.dp, width = 60.dp),
                    shape = RoundedCornerShape(10.dp)) {
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()) {
                        Text(text ="$dewasa",
                            fontSize = 25.sp)
                    }
                }
                Image(painter = painterResource(id = R.drawable.plusbutton),
                    contentDescription ="",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (weekend) {
                                dewasa++
                                total += weknddewasa
                            } else if(!weekend){
                                dewasa++
                                total += wekndaysdewasa
                            }
                        })
            }
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "Jumlah Tiket",
                fontFamily = worksansbold,
                modifier = Modifier.padding(10.dp))
            Text(text = "Total Rp $total",
                fontFamily = worksansbold,
                modifier = Modifier.padding(10.dp))
        }

    }
}

