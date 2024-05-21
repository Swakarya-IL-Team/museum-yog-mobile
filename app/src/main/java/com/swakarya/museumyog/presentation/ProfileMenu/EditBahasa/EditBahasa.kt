package com.swakarya.museumyog.presentation.ProfileMenu.EditBahasa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.ui.theme.MuseumYogTheme
import com.swakarya.museumyog.ui.theme.Neutral1
import com.swakarya.museumyog.ui.theme.green8
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@Composable
fun EditBahasa(navController: NavHostController) {
    var selectedLanguage by remember { mutableStateOf("Bahasa Indonesia") }
    val languages = listOf("Bahasa Indonesia", "English")

    Column {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_edit_bahasa),
                contentDescription = "Background Edit Bahasa",
                alignment = Alignment.TopCenter
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    IconButton(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        onClick = { navController.navigate(route = "profil") }) {
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
                            text = "Bahasa",
                            fontFamily = worksansbold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Pilih Bahasa:",
                fontFamily = worksans,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        languages.forEach { language ->
            TextButton(
                onClick = { selectedLanguage = language },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Neutral1,
                    contentColor = if (selectedLanguage == language)
                        MaterialTheme.colorScheme.onSurface
                    else MaterialTheme.colorScheme.onSurface
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = language,
                        fontFamily = worksans,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    if (selectedLanguage == language) {
                        Box(
                            modifier = Modifier
                                .background(green8, CircleShape)
                                .padding(horizontal = 3.dp, vertical = 3.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "Selected icon",
                                modifier = Modifier.size(16.dp),
                                tint = Color.White
                            )
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
        }


    }
}


@Preview
@Composable
fun EditBahasaPreview() {
    MuseumYogTheme {
        EditBahasa(navController = rememberNavController())
    }
}