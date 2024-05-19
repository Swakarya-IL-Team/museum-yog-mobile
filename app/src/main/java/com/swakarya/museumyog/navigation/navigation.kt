package com.swakarya.museumyog.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.presentation.home.HomePage
import com.swakarya.museumyog.presentation.login.login
import com.swakarya.museumyog.presentation.singup.singUp
import com.swakarya.museumyog.presentation.onboarding.onboarding1
import com.swakarya.museumyog.presentation.onboarding.onboarding2
import com.swakarya.museumyog.presentation.onboarding.onboarding3
import com.swakarya.museumyog.presentation.splash.splashScreen


@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable(route="splash"){
            splashScreen(navController)
        }

        composable(route = "login") {
            login(navController)
        }
        composable(route = "singup") {
            singUp(navController)
        }
            composable(route = "splashScreen") {
                splashScreen(navController)
            }
            composable(route = "onboarding1") {
                onboarding1(navController)
            }
            composable(route = "onboarding2") {
                onboarding2(navController)
            }
            composable(route = "onboarding3") {
                onboarding3(navController)
            }
        composable(route="home"){
            HomePage(
                text = "",
                onTextChange = {},
                placeHolder = "Mau ke Museum apa ?",
                onCloseClicked = {},
                onMicClicked = {},
                navController = navController
            )
        }
    }
}