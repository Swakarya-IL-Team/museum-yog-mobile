package com.swakarya.museumyog.app.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.ui.theme.greyku

@Preview
@Composable
fun voucher() {
    var voucher by remember { mutableStateOf("") }

    OutlinedTextField(
        value = voucher,
        modifier = Modifier
            .size(width = 220.dp, height = 50.dp)
            .border(
                BorderStroke(width = 2.dp, color = greyku),
                shape = RoundedCornerShape(20)
            ),
        onValueChange = { voucher = it },
        placeholder = { Text(text = "") }
    )
}