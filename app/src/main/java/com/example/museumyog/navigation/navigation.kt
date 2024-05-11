package com.example.museumyog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museumyog.presentation.onboarding.onboarding1
import com.example.museumyog.presentation.onboarding.onboarding2
import com.example.museumyog.presentation.onboarding.onboarding3
import com.example.museumyog.presentation.splash.splashScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splashScreen") {

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
    }
}