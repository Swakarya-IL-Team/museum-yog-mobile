package com.swakarya.museumyog.app.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swakarya.museumyog.ui.theme.greenku

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun voucher() {
    var voucher by remember { mutableStateOf("") }

    OutlinedTextField(
        value = voucher,
        modifier = Modifier
            .size(width = 220.dp, height = 50.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                BorderStroke(
                    1.dp,
                    SolidColor(greenku)
                ),
                RoundedCornerShape(12.dp)
            ),
        onValueChange = { voucher = it },
        placeholder = { Text(text = "") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.onBackground
        ),
    )
}