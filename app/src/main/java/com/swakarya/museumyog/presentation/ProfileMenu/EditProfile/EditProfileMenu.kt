package com.swakarya.museumyog.presentation.ProfileMenu.EditProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.SharedVariables.fullname
import com.swakarya.museumyog.app.component.SharedVariables.username
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.green5
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileMenu(modifier: Modifier = Modifier, navController: NavHostController) {
    var selectedGender by remember { mutableStateOf<Gender?>(null) }
    var phoneNumber by remember { mutableStateOf("") }
    Column {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_edit_profile),
                contentDescription = "Background Edit Profile",
                alignment = Alignment.TopCenter
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    IconButton(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        onClick = { navController.navigate(route = "profil")}) {
                        Box(
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .padding(horizontal = 1.dp, vertical = 1.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "IconBack",
                                tint = greenku
                            )
                        }

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "Edit Profil",
                            fontFamily = worksansbold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
                Box(contentAlignment = Alignment.BottomEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "profile user",
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .size(97.dp, 101.dp)
                            .clip(CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .background(green5, CircleShape)
                            .padding(horizontal = 3.dp, vertical = 3.dp)
                            .padding(start = 1.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_edit),
                            contentDescription = "Icon Edit Profile",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }

            }
        }
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "Nama Lengkap",
                fontFamily = worksans,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = fullname,
                onValueChange = { fullname = it },
                label = {
                    Text(
                        "Ketik disini",
                        fontFamily = worksans,
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Username",
                fontFamily = worksans,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        "Ketik disini",
                        fontFamily = worksans,
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Jenis-Kelamin",
                fontFamily = worksans,
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = selectedGender == Gender.Male,
                    onClick = { selectedGender = Gender.Male }
                )
                Text(
                    text = "Laki-laki",
                    fontFamily = worksans,
                    fontSize = 14.sp
                )

                Spacer(modifier = modifier.width(42.dp))

                RadioButton(selected = selectedGender == Gender.Female,
                    onClick = { selectedGender = Gender.Female })

                Text(
                    text = "Perempuan",
                    fontFamily = worksans,
                    fontSize = 14.sp
                )
            }



            Spacer(modifier = modifier.height(12.dp))

            Text(
                text = "Nomor Telepon",
                fontFamily = worksans,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = {
                    Text(
                        "Ketik disini",
                        fontFamily = worksans,
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(120.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(greenku),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Simpan",
                    fontFamily = worksansmedium,
                    fontSize = 16.sp
                )
            }

        }

    }
}

enum class Gender {
    Male, Female
}

@Preview
@Composable
fun EditProfileMenuPreview() {
    MuseumYogTheme {
        EditProfileMenu(navController = rememberNavController())
    }
}