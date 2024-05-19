package com.swakarya.museumyog.data.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.ui.theme.greyku

@Composable
fun FieldPassword() {
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        modifier = Modifier
            .size(width = 350.dp, height = 60.dp)
            .border(
                BorderStroke(width = 3.dp, color = greyku),
                shape = RoundedCornerShape(20)
            ),
        leadingIcon = { Icon(imageVector = Icons.Default.Lock,
            contentDescription = null)
        },
        onValueChange = { password = it },
        placeholder = { Text(text = "Password") }
    )
}

@Composable
fun FieldUsername() {
    var username by remember { mutableStateOf("") }

    OutlinedTextField(
        value = username,
        modifier = Modifier
            .size(width = 350.dp, height = 60.dp)
            .border(
                BorderStroke(width = 3.dp, color = greyku),
                shape = RoundedCornerShape(20)
            ),
        onValueChange = { username = it },
        placeholder = { Text(text = "Username") }
    )
}
@Composable
fun Fullname() {
    var name by remember { mutableStateOf("") }
    OutlinedTextField(
        value = name,
        modifier = Modifier
            .size(width = 350.dp, height = 60.dp)
            .border(
                BorderStroke(width = 3.dp, color = greyku),
                shape = RoundedCornerShape(20)
            ),
        onValueChange = { name = it },
        placeholder = { Text(text = "Username") }
    )
}