package com.example.museumyog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museumyog.presentation.login.login
import com.example.museumyog.presentation.singup.singUp

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "login") {

        composable(route = "login") {
            login(navController)
        }
        composable(route = "singup") {
            singUp(navController)
        }
    }
}