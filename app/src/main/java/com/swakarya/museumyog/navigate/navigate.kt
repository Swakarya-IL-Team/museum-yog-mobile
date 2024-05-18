package com.swakarya.museumyog.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swakarya.museumyog.presentation.Payment.VA
import com.swakarya.museumyog.presentation.Payment.listPayment
import com.swakarya.museumyog.presentation.Payment.listpayment2
import com.swakarya.museumyog.presentation.Payment.listpayment3
import com.swakarya.museumyog.presentation.PaymentMethod.method

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "pay1") {

        composable(route = "pay1") {
            listPayment(navController)
        }
        composable(route = "pay2") {
            listpayment2(navController)
        }
        composable(route = "pay3") {
            listpayment3(navController)
        }
        composable(route = "method") {
            method(navController)
        }
        composable(route = "va") {
            VA(navController)
        }

    }
}