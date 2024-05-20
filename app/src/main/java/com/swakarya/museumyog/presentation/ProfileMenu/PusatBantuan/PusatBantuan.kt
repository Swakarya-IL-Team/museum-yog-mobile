package com.swakarya.museumyog.presentation.ProfileMenu.PusatBantuan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.data.model.DataDropdown
import com.swakarya.museumyog.data.model.dataDropdown
import com.swakarya.museumyog.ui.theme.MuseumyogmobileTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium

@Composable
fun PusatBantuanHeader() {
    Column {
        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.background_edit_bahasa),
                contentDescription = "Background Edit Bahasa",
                alignment = Alignment.TopCenter
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box {
                    IconButton(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        onClick = { /*TODO*/ }) {
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
                            text = "Pusat Bantuan",
                            fontFamily = worksansbold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                modifier = Modifier.padding(top = 33.dp, bottom = 44.dp),
                text = "Selamat datang di Pusat Bantuan Aplikasi MuseumYog! Kami di sini untuk membantu Anda dengan pertanyaan atau masalah apa pun yang mungkin Anda miliki. Silakan telusuri pertanyaan umum di bawah ini atau hubungi tim dukungan kami jika Anda membutuhkan bantuan lebih lanjut.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PusatBantuanItem(
    dataDropdown: DataDropdown,
    isExpanded: Boolean,
    onToggleExpanded: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = onToggleExpanded,
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onToggleExpanded() }
            ) {
                Text(
                    text = dataDropdown.title,
                    fontSize = 12.sp,
                    fontFamily = worksans,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onToggleExpanded,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowRight,
                        contentDescription = if (isExpanded) "Collapse" else "Expand"
                    )
                }
            }
            if (isExpanded) {
                Text(
                    text = dataDropdown.description,
                    fontSize = 12.sp,
                    fontFamily = worksansmedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Divider()
    }
}

@Composable
fun PusatBantuanScreen() {
    val expandedStates = remember { mutableStateListOf(*Array(dataDropdown.size) { false }) }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        PusatBantuanHeader()
        dataDropdown.forEachIndexed { index, item ->

            PusatBantuanItem(
                dataDropdown = dataDropdown[index],
                isExpanded = expandedStates[index],
                onToggleExpanded = { expandedStates[index] = !expandedStates[index] }
            )
        }


    }
}

@Preview
@Composable
fun PusatBantuanPreview() {
    MuseumyogmobileTheme {
        PusatBantuanScreen()
    }
}
