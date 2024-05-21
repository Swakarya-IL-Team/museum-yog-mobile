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
import androidx.lifecycle.ViewModel
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.greyku
import java.time.LocalDate

object SharedVariables {
    var anak by mutableStateOf(0)
    var mhs by  mutableStateOf(0)
    var dewasa by  mutableStateOf(0)
    var family by  mutableStateOf(120000)
    var student by  mutableStateOf(1200000)
    var total by  mutableStateOf(0)
    var total1 by  mutableStateOf(0)
    var admin by  mutableStateOf(2000)
    var wekndanak by mutableStateOf(7000)
    var wekndmhs by mutableStateOf(12000)
    var weknddewasa by mutableStateOf(15000)
    var wekndaysanak by mutableStateOf(5000)
    var wekndaysmhs by mutableStateOf(10000)
    var wekndaysdewasa by mutableStateOf(13000)
    var weekend by mutableStateOf(false)
    var checked1 by mutableStateOf(false)
    var checked by mutableStateOf(false)
    var pay by mutableStateOf(false)
    var bankpay by mutableStateOf(false)
    val SelectedDate = mutableStateOf(LocalDate.now())
    val date = mutableStateOf(LocalDate.now())
}

