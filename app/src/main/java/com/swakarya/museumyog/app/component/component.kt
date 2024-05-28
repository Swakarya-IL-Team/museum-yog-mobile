package com.swakarya.museumyog.app.component

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.app.component.SharedVariables.password
import com.swakarya.museumyog.app.component.SharedVariables.username
import com.swakarya.museumyog.ui.theme.greyku
@Preview
@Composable
fun FieldPassword() {
    OutlinedTextField(
        value = password,
        modifier = Modifier
            .size(width = 350.dp, height = 60.dp)
            .border(2.dp, greyku, RoundedCornerShape(20)),
        shape = RoundedCornerShape(20),
        trailingIcon = { Icon(imageVector = Icons.Default.Lock,
            contentDescription = null)
        },
        onValueChange = { password = it },
        placeholder = { Text(text = "Password") },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun FieldUsername() {
    OutlinedTextField(
        value = username,
        modifier = Modifier
            .size(width = 350.dp, height = 60.dp)
            .border(2.dp, greyku, RoundedCornerShape(20)),
        shape = RoundedCornerShape(20),
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
            .border(2.dp, greyku, RoundedCornerShape(20)),
        shape = RoundedCornerShape(20),
        onValueChange = { name = it },
        placeholder = { Text(text = "Username") }
    )
}