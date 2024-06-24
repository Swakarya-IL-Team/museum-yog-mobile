package com.swakarya.museumyog.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.FieldPassword
import com.swakarya.museumyog.app.component.FieldUsername
import com.swakarya.museumyog.app.component.SharedVariables.email
import com.swakarya.museumyog.app.component.SharedVariables.password
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import kotlinx.coroutines.launch

@Composable
fun login(navController: NavHostController) {
    val viewModel: LoginViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Image(painter = painterResource(id = R.drawable.laki_dan_backgroud),
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
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.awan3),
                contentDescription =null,
                modifier = Modifier.size(130.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(300.dp))
            Text(text = "Kita Bertemu lagi",
                color = greenku,
                fontFamily = worksansbold,
                fontSize = 24.sp)
            Text(text = " Ayo Lanjutkan Perjalanan Bersama Kami!",
                fontFamily = worksans,
                fontSize = 12.sp)
            Spacer(modifier = Modifier.height(15.dp))
            FieldUsername()
            Spacer(modifier = Modifier.height(8.dp))
            FieldPassword()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Lupa password?",
                        color = greyku,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
            Button(onClick = { coroutineScope.launch {
                if(email.isBlank() || password.isBlank()){
                   Toast.makeText(
                       context,
                       "Email dan Password harus di isi",
                       Toast.LENGTH_SHORT
                   )
                       .show()
                }else{
                    viewModel.loginUser(email,password){
                        navController.navigate("home"){
                            popUpTo("login")
                            { inclusive = true }
                        }
                        email = ""
                        password = ""
                    }
                }
            } } ,
                colors = ButtonDefaults.buttonColors(greenku),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 350.dp, height = 60.dp))
            {
                Text(text = "Masuk")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {navController.navigate("home") },
                border = BorderStroke(2.dp, color = greenku),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 350.dp, height = 60.dp))
            {
                Text(text = "Masuk Sebagai Tamu",
                    fontFamily = worksansbold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Atau masuk dengan")
        }
        Box(modifier = Modifier.fillMaxSize(),
            Alignment.TopCenter){
            Column {
                Spacer(modifier = Modifier.height(710.dp))
                Row() {
                    TextButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.google),
                            contentDescription =null,
                            modifier = Modifier
                                .size(height = 42.dp, width = 127.dp))
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.facebook),
                            contentDescription =null ,
                            modifier = Modifier
                                .size(height = 42.dp, width = 147.dp))
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(),
            Alignment.TopCenter){
            Column {
                Spacer(modifier = Modifier.height(760.dp))
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Text(text = "Belum punya akun?",
                        fontSize = 14.sp,
                        fontFamily = worksans)
                    TextButton(onClick = { navController.navigate("singup") }) {
                        Text(text = "Daftar sekarang",
                            color = greenku,
                            fontSize = 14.sp,
                            fontFamily = worksans,
                            textDecoration = TextDecoration.Underline)
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun login() {
    MuseumYogTheme {
        login(navController = rememberNavController())
    }
}