package com.swakarya.museumyog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.presentation.login.login
import com.swakarya.museumyog.presentation.singup.singUp


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,

        startDestination = "login"
    ) {

        composable(route = "login") {
            login(navController)
        }
        composable(route = "singup") {
            singUp(navController)

//        startDestination = "splashScreen") {
//
//        composable(route = "splashScreen") {
//            splashScreen(navController)
//        }
//        composable(route = "onboarding1") {
//            onboarding1(navController)
//        }
//        composable(route = "onboarding2") {
//            onboarding2(navController)
//        }
//        composable(route = "onboarding3") {
//            onboarding3(navController)
//        }
        }
    }
}