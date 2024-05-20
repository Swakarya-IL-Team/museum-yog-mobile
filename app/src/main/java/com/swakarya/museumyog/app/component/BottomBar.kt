
package com.swakarya.museumyog.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.data.model.BottomBarItem
import com.swakarya.museumyog.ui.theme.MuseumYogTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    titleSize: TextUnit = 8.sp,
    iconColor: Color = Color.White,
    titleColor: Color = Color.White
) {
    NavigationBar(
        modifier = modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 17.dp)
            .sizeIn(maxHeight = 66.dp)
            .clip(RoundedCornerShape(8.dp)),
        containerColor = Color(android.graphics.Color.parseColor("#CA8164")),
    ) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.txt_beranda),
                icon = painterResource(id = R.drawable.icon_beranda)
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_kunjungan),
                icon = painterResource(id = R.drawable.icon_kunjungan)
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_notifikasi),
                icon = painterResource(id = R.drawable.icon_notifikasi)
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_akun),
                icon = painterResource(id = R.drawable.icon_akun)
            )
        )
        bottomNavigation.map {
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        painter = it.icon,
                        contentDescription = it.title,
                        modifier = Modifier.size(iconSize),
                        tint = iconColor
                    )
                },
                label = { Text(text = it.title, fontSize = titleSize, color = titleColor) })
        }
    }
}

@Preview
@Composable
private fun ButtonBarPreview() {
    MuseumYogTheme {
        BottomBar()
    }
}
