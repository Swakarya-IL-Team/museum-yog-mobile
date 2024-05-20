package com.swakarya.museumyog.component

import android.icu.util.Calendar
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import com.swakarya.museumyog.component.SharedVariables.SelectedDate
import com.swakarya.museumyog.component.SharedVariables.date
import com.swakarya.museumyog.ui.theme.greenku
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calender(
    value: LocalDate,
    onValueChange: (LocalDate) -> Unit
) {

    val open = remember { mutableStateOf(false) }

    if (open.value) {
        CalendarDialog(
            state = rememberUseCaseState(visible = true, true, onCloseRequest = { open.value = false } ),
            config = CalendarConfig(
                yearSelection = true,
                style = CalendarStyle.MONTH,
            ),
            selection = CalendarSelection.Date(
                selectedDate = SelectedDate.value
            ) { newDate ->
                SelectedDate.value = newDate
            },
        )
    }

    OutlinedTextField(
        modifier = Modifier.size(width = 350.dp, height = 50.dp)
            .border(2.dp, greenku, RoundedCornerShape(25))
            .clickable { //Click event
                open.value = true
            },
        trailingIcon = { Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null) },
        enabled = false,// <- Add this to make click event work
        value = SelectedDate.value.format(DateTimeFormatter.ISO_DATE),
        onValueChange = {},
    )
}

@Preview(showBackground = true)
@Composable
fun CustomDatePickerPreview(){
    calender(
        value = SharedVariables.date.value,
        onValueChange = { SharedVariables.date.value = it}
    )
}

