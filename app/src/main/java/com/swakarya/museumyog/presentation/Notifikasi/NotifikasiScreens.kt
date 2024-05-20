package com.swakarya.museumyog.presentation.Notifikasi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.app.component.BottomBar
import com.swakarya.museumyog.ui.theme.MuseumYogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Notifikasi", fontSize = 20.sp) }

        )
    },
            bottomBar = { BottomBar() }
    )

    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Notifikasi", style = MaterialTheme.typography.headlineMedium)
                TextButton(onClick = { /* TODO: Handle clear all notifications */ }) {
                    Text(text = "Hapus semua", color = Color.Gray)
                }
            }
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                items(4) { index ->
                    NotificationItem(
                        title = "Event Hari Kemerdekaan!",
                        description = "Rayakan hari Kemerdekaan dengan mengingat sejarah di Museum!",
                        icon = Icons.Default.MailOutline
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationItem(title: String, description: String, icon: ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = title, style = MaterialTheme.typography.bodyLarge, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
            }
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItemPreview() {
    MuseumYogTheme {
        NotificationItem(
            title = "Event Hari Kemerdekaan!",
            description = "Rayakan hari Kemerdekaan dengan mengingat sejarah di Museum!",
            icon = Icons.Default.MailOutline
        )
    }
}