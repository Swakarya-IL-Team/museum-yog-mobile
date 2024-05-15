package com.swakarya.museumyog.presentation.ListMuseum

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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.data.model.imageMuseum
import com.swakarya.museumyog.data.model.nameMuseum
import com.swakarya.museumyog.data.model.placeMuseum
import com.swakarya.museumyog.data.model.rangeMuseum
import com.swakarya.museumyog.data.model.rateMuseum
import com.swakarya.museumyog.data.model.visitorMuseum
import com.swakarya.museumyog.ui.theme.MuseumyogmobileTheme
import com.swakarya.museumyog.ui.theme.green10
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold
import com.swakarya.museumyog.ui.theme.worksansmedium
import com.swakarya.museumyog.ui.theme.worksanssemibold
import com.swakarya.museumyog.ui.theme.yellowku

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMuseum(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeHolder: String,
    onCloseClicked: () -> Unit,
    onMicClicked: () -> Unit
) {
    Column {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Icon Back",
                        tint = greenku
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                BorderStroke(
                                    1.dp,
                                    SolidColor(greenku)
                                ),
                                RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        OutlinedTextField(
                            modifier = modifier
                                .fillMaxWidth()
                                .heightIn(max = 48.dp),
                            value = text,
                            onValueChange = {
                                onTextChange(it)
                            },
                            placeholder = {
                                Text(
                                    text = placeHolder,
                                    fontFamily = worksans,
                                    fontSize = 12.sp,
                                    color = greenku,
                                )
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
                                        onMicClicked
                                    }
                                }) {
                                    if (text.isNotBlank()) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = "Icon Close",
                                            tint = greenku,
                                            modifier = modifier.size(22.dp)
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_search),
                                            contentDescription = null,
                                            tint = greenku,
                                            modifier = modifier.size(22.dp)
                                        )
                                    }
                                }
                            }
                        )
                    }
                }

            })
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 16.dp, top = 13.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    modifier = Modifier.size(21.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = "Icon Bintang",
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
                Icon(
                    painter = painterResource(id = R.drawable.icon_filter),
                    contentDescription = "Icon Filter",
                    modifier = Modifier.size(20.dp),
                    tint = greenku)

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Filter",
                    fontFamily = worksansbold,
                    fontSize = 12.sp,
                    color = green10,
                )
            }
        }
        val ItemLazyCount = imageMuseum.size
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 16.dp)
        ) {
            items(ItemLazyCount) { item ->
                ColumnMuseum(
                    itemIndex = item,
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
            .padding(end = 16.dp, bottom = 16.dp),
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


@Preview
@Composable
fun ListMuseumPreview() {
    MuseumyogmobileTheme {
        ListMuseum(
            text = "",
            onTextChange = {},
            placeHolder = "Mau ke Museum apa ?",
            onCloseClicked = {},
            onMicClicked = {}
        )
    }
}