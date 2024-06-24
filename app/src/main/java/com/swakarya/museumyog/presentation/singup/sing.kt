package com.swakarya.museumyog.presentation.singup
import android.widget.Toast
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.FieldPassword
import com.swakarya.museumyog.app.component.FieldUsername
import com.swakarya.museumyog.app.component.Fullname
import com.swakarya.museumyog.app.component.SharedVariables.password
import com.swakarya.museumyog.app.component.SharedVariables.email
import com.swakarya.museumyog.app.component.SharedVariables.fullname
import com.swakarya.museumyog.presentation.login.LoginViewModel
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.coklatku
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksanssemibold
import kotlinx.coroutines.launch


@Composable
fun singUp(navController: NavHostController){
    val coroutineScope = rememberCoroutineScope()
    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
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
            Spacer(modifier = Modifier.height(320.dp))
            Text(text = "Daftar Sekarang!",
                color = coklatku,
                fontFamily = worksansbold,
                fontSize = 24.sp)
            Text(text = "Dapatkan pengalaman lebih seru bersama kami!",
                color= Color.Black,
                fontFamily = worksans,
                fontSize = 12.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Fullname()
            Spacer(modifier = Modifier.height(10.dp))
            FieldUsername()
            Spacer(modifier = Modifier.height(10.dp))
            FieldPassword()
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                coroutineScope.launch {
                if (fullname.isBlank()|| email.isBlank()|| password.isBlank()){
                    Toast.makeText(
                        context,
                        "Field masih kosong!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    viewModel.registerUser(email, password) {
                        navController.navigate("login") {
                            popUpTo("login")
                            { inclusive = true }
                        }
                        email =""
                        password =""
                    }
                }
            }},
                colors = ButtonDefaults.buttonColors(greenku),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 350.dp, height = 60.dp))
            {
                Text(text = "Daftar",
                    fontFamily = worksanssemibold,
                    fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Atau daftar dengan",
                fontFamily = worksans,
                fontSize = 14.sp)
        }
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
            Spacer(modifier = Modifier.height(770.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "Sudah punya akun?",
                    fontFamily = worksans,
                    fontSize = 14.sp)
                TextButton(onClick = { navController.navigate("login")
                email = ""
                password = ""}) {
                    Text(text = "Masuk",
                        color = greenku,
                        fontFamily = worksans,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun sing() {
    MuseumYogTheme {
        singUp(navController = rememberNavController())
    }
}