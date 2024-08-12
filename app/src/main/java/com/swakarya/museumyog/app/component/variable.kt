// variable.kt
package com.swakarya.museumyog.app.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var fullname by mutableStateOf("")
    var terdekat by mutableStateOf(false)
    var passwordConfirm by mutableStateOf("")
    var isRegistering by  mutableStateOf(false)
    var imageMuseum by mutableStateOf(listOf<Int>())
    var nameMuseum by mutableStateOf(listOf<String>())

    data class Visit(
        val name: String,
        val date: String,
        val expiryDate: String,
        val imageRes: Int
    )
    data class Ticket(
        val museumName: String,
        val orderDate: String,
        val expiryDate: String,
        val imageRes: Int? = null
    )
    data class Testimonial(
        val name: String,
        val date: String,
        val rating: Float,
        val comment: String
    )
    var purchasedTickets = mutableStateListOf<Ticket>()
    var activeVisits = mutableStateListOf<Visit>()
    val historyVisits = mutableStateListOf<Visit>()
    val testimonials = mutableStateListOf<Testimonial>()
}
