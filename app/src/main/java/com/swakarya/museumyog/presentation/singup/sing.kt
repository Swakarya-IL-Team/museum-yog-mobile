package com.swakarya.museumyog.presentation.singup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.data.component.FieldPassword
import com.swakarya.museumyog.data.component.FieldUsername
import com.swakarya.museumyog.data.component.Fullname
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.FieldPassword
import com.swakarya.museumyog.app.component.FieldUsername
import com.swakarya.museumyog.app.component.Fullname
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@Composable
fun singUp(navController: NavHostController){

    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Image(painter = painterResource(id = R.drawable.perempuan_dan_background),
            contentDescription =null ,
            modifier = Modifier
                .size(500.dp)
                .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 150.dp))
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopStart) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                Image(painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo")
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopEnd){
        Column {
            Image(painter = painterResource(id = R.drawable.awan3),
                contentDescription =null,
                modifier = Modifier.size(130.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(330.dp))
            Text(text = "Daftar Sekarang!",
                color = coklatku,
                fontFamily = worksansbold,
                fontSize = 30.sp)
            Text(text = "Dapatkan pengalaman lebih seru bersama kami!",
                color= Color.Black,
                fontFamily = worksans,
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Fullname()
            Spacer(modifier = Modifier.height(10.dp))
            FieldUsername()
            Spacer(modifier = Modifier.height(10.dp))
            FieldPassword()
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(greenku),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 350.dp, height = 60.dp))
            {
                Text(text = "Masuk")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Atau daftar dengan")
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(690.dp))
            Row(verticalAlignment = Alignment.Top) {
                TextButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.google),
                        contentDescription =null,
                        modifier = Modifier
                            .size(150.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
                TextButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.facebook),
                        contentDescription =null ,
                        modifier = Modifier
                            .size(150.dp))
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column {
            Spacer(modifier = Modifier.height(790.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "Sudah punya akun?")
                TextButton(onClick = { navController.navigate("login")}) {
                    Text(text = "Masuk",
                        color = greenku,
                        textDecoration = TextDecoration.Underline)
                }
            }
        }
    }
}
