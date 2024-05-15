package com.swakarya.museumyog.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.app.component.BottomBar
import com.swakarya.museumyog.data.model.imageId
import com.swakarya.museumyog.data.model.imageMuseum
import com.swakarya.museumyog.data.model.nameMuseum
import com.swakarya.museumyog.data.model.names
import com.swakarya.museumyog.data.model.placeMuseum
import com.swakarya.museumyog.data.model.rangeMuseum
import com.swakarya.museumyog.data.model.rateMuseum
import com.swakarya.museumyog.data.model.visitorMuseum
import com.swakarya.museumyog.ui.theme.green10
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeHolder: String,
    onCloseClicked: () -> Unit,
    onMicClicked: () -> Unit
) {
    Scaffold(bottomBar = { BottomBar() }) { paddingValues ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(color = greenku)
                        .padding(start = 16.dp, top = 31.dp, bottom = 33.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Selamat Pagi , ",
                        fontFamily = worksansbold,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    Text(text = "Eren",
                        fontFamily = worksanssemibold,
                        fontSize = 20.sp,
                        color = Color.White)
                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    Alignment.TopEnd
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.awan_home),
                            contentDescription = null,
                            modifier = Modifier.size(width = 93.dp, height = 31.dp),
                        )

                        Image(
                            painter = painterResource(id = R.drawable.awan_home2),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 7.dp)
                                .size(width = 93.dp, height = 47.dp),
                            alignment = Alignment.TopEnd
                        )
                    }

                }

                Column(
                    modifier = Modifier.padding(top = 66.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 48.dp)
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                BorderStroke(
                                    1.dp,
                                    SolidColor(greenku)
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .background(Color.White),
                        value = text,
                        onValueChange = {
                            onTextChange(it)
                        },
                        placeholder = {
                            Text(text = placeHolder,
                                fontFamily = worksans,
                                fontSize = 12.sp,
                                color = greenku)
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            focusedBorderColor = greenku,
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = MaterialTheme.colorScheme.onBackground
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                if (text.isNotBlank()) {
                                    onCloseClicked()
                                } else {
                                    onMicClicked()
                                }
                            }) {
                                if (text.isNotBlank()) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Icon Clear",
                                        modifier = modifier.size(22.dp)
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_search),
                                        contentDescription = "Icon Search",
                                        tint = green10,
                                        modifier = modifier.size(22.dp)
                                    )
                                }
                            }
                        },
                    )

                    Text(
                        text = "Event Seru Menunggumu!",
                        fontFamily = worksanssemibold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                    )
                    val ItemCount = imageId.size
                    LazyRow(
                        contentPadding = PaddingValues(top = 14.dp, start = 16.dp)
                    ) {
                        items(ItemCount) { item ->
                            RowEvent(itemIndex = item, painter = imageId, tittle = names)
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            Icon(
                                modifier = Modifier.size(21.dp),
                                imageVector = Icons.Default.Star,
                                contentDescription = "Icon Lokasi",
                                tint = yellowku
                            )

                            Spacer(modifier = Modifier.width(5.5.dp))

                            Text(
                                text = "Terpopuler Pekan Ini",
                                fontFamily = worksansbold,
                                fontSize = 14.sp,
                                color = green10,
                            )
                        }


                        TextButton(onClick = { }) {
                            Text(
                                text = "Lihat Lainnya",
                                fontFamily = worksansbold,
                                fontSize = 12.sp,
                                color = green10,
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null
                            )
                        }
                    }

                    val ItemLazyCount = imageMuseum.size
                    for (index in 0 until ItemLazyCount) {
                        ColumnMuseum(
                            itemIndex = index,
                            painter = imageMuseum,
                            tittle = nameMuseum,
                            rangeMuseum = rangeMuseum,
                            placeMuseum = placeMuseum,
                            rateMuseum = rateMuseum,
                            visitorMuseum = visitorMuseum
                        )
                    }
                }
            }


        }
    }


}

@Composable
fun RowEvent(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(width = 204.dp, height = 188.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column(
        ) {
            Box(
                modifier = Modifier
                    .size(width = 204.dp, height = 149.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = painter[itemIndex]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.Start) {
                Text(
                    text = tittle[itemIndex],
                    fontFamily = worksansbold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ColumnMuseum(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    rangeMuseum: Array<String>,
    placeMuseum: Array<String>,
    rateMuseum: Array<String>,
    visitorMuseum: Array<String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, bottom = 16.dp, start = 16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 3.dp)
                    .size(width = 132.dp, height = 111.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = painter[itemIndex]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            Column(
                modifier = Modifier.padding(start = 1.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = tittle[itemIndex],
                    fontFamily = worksanssemibold,
                    fontSize = 12.sp
                )
                Row(
                    modifier = Modifier.padding(vertical = 7.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = Icons.Outlined.LocationOn, contentDescription = "Icon Lokasi"
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = rangeMuseum[itemIndex],
                        fontFamily = worksans,
                        fontSize = 10.sp
                    )
                }
                Text(
                    text = placeMuseum[itemIndex],
                    fontFamily = worksansmedium,
                    fontSize = 10.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {
                        Icon(
                            modifier = Modifier.size(14.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "Icon Rate",
                            tint = yellowku
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = rateMuseum[itemIndex],
                            fontFamily = worksans,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        text = visitorMuseum[itemIndex],
                        fontFamily = worksans,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage(
        text = "",
        onTextChange = {},
        placeHolder = "Mau ke Museum apa ?",
        onCloseClicked = {},
        onMicClicked = {}
    )
}