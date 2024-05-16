package com.swakarya.museumyog.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swakarya.museumyog.presentation.kunjungan.AktifKunjungan
import com.swakarya.museumyog.presentation.kunjungan.RiwayatKunjungan

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "aktif") {
        composable(route = "aktif") {
            AktifKunjungan(navController)
        }
        
        composable(route = "riwayat") {
            RiwayatKunjungan(navController)
        }
    }
}