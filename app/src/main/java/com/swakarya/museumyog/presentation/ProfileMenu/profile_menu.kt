package com.swakarya.museumyog.presentation.ProfileMenu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.BottomBar
import com.swakarya.museumyog.app.component.SharedVariables.fullname
import com.swakarya.museumyog.app.component.SharedVariables.username
import com.swakarya.museumyog.ui.theme.MuseumYogTheme

var notificationSwitchState by mutableStateOf(false)


@Composable
fun ProfileMenu(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(bottomBar = { BottomBar(navController = navController) }) { paddingValues ->
        Column(modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)) {
            Box(contentAlignment = Alignment.TopCenter) {
                Image(
                    painter = painterResource(id = R.drawable.background_profile_menu),
                    contentDescription = "background profile menu",
                    alignment = Alignment.TopStart,
                    modifier = Modifier.fillMaxSize()
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        modifier = Modifier.padding(top = 30.dp),
                        text = "Akun Saya",
                        color = Color(0xfff2f2f2),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "profile user",
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .size(97.dp, 101.dp)
                            .clip(CircleShape)
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 12.dp),
                        text = "$fullname",
                        color = Color(0xfff2f2f2),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 31.dp)
                    .fillMaxSize()
            ) {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(18.dp))
                        IconWithText(
                            text = "Sunting Informasi Pribadi",
                            icon = painterResource(id = R.drawable.icon_sunting),
                            textColor = Color.Black,
                            route = "edit",
                            navController = navController
                        )

                        Spacer(modifier = Modifier.height(18.dp))
                        IconWithSwitch(
                            text = "Notifikasi",
                            icon = painterResource(id = R.drawable.icon_notification),
                            isChecked = notificationSwitchState,
                            onCheckedChange = { isChecked -> notificationSwitchState = isChecked }
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        IconWithText(
                            text = "Bahasa",
                            icon = painterResource(id = R.drawable.icon_language),
                            textColor = Color.Black,
                            route = "editbahasa",
                            navController = navController
                        )
//                            onClick = {
//
//                            }

                        Spacer(modifier = Modifier.height(18.dp))
                    }

                }

                Spacer(modifier = Modifier.height(17.dp))

                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier.padding(horizontal = 15.dp),
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(18.dp))
                        IconWithText(
                            text = "Pusat Bantuan",
                            icon = painterResource(id = R.drawable.icon_pusat_bantuan),
                            textColor = Color.Black,
                            route = "bantuan",
                            navController = navController
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        IconWithText(
                            text = "Privasi",
                            icon = painterResource(id = R.drawable.icon_notification),
                            textColor = Color.Black,
                            route = "privasi",
                            navController = navController
                        )

                        Spacer(modifier = Modifier.height(18.dp))
                    }

                }
                Spacer(modifier = Modifier.height(28.dp))

                Card(
                    colors = CardDefaults.cardColors(Color(android.graphics.Color.parseColor("#FFEDE4"))),
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 17.dp, bottom = 17.dp)
                            .clickable { }
                    ) {
                        IconWithText(
                            text = "Keluar",
                            icon = painterResource(id = R.drawable.icon_leave),
                            textColor = Color(0xFFC57557),
                            route = "login",
                            navController = navController
                        )
//                            onClick = {
//
//                            }

                    }
                }
            }
        }
    }
}


@Composable
fun IconWithText(
    text: String,
    icon: Painter,
    textColor: Color,
    route : String,
    navController: NavController
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {navController.navigate(route) }
    ) {
        Image(
            painter = icon,
            contentDescription = text,
            modifier = Modifier
                .padding(start = 18.dp)
                .size(width = 20.dp, height = 20.dp)
        )
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(start = 13.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun IconWithSwitch(
    text: String,
    icon: Painter,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = icon,
            contentDescription = text,
            modifier = Modifier
                .padding(start = 18.dp)
                .size(20.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 13.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier
                .padding(end = 18.dp)
                .size(width = 35.dp, height = 17.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileMenuPreview() {
    MuseumYogTheme {
        ProfileMenu(navController = rememberNavController())
    }
}