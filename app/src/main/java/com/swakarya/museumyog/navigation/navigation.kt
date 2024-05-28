package com.swakarya.museumyog.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swakarya.museumyog.app.component.SharedVariables.username
import com.swakarya.museumyog.data.model.imageMuseum
import com.swakarya.museumyog.data.model.nameMuseum
import com.swakarya.museumyog.data.model.rateMuseum
import com.swakarya.museumyog.presentation.login.login
import com.swakarya.museumyog.presentation.home.HomePage
import com.swakarya.museumyog.presentation.ListMuseum.ListMuseum
import com.swakarya.museumyog.presentation.Notifikasi.NotificationScreen
import com.swakarya.museumyog.presentation.Payment.VA
import com.swakarya.museumyog.presentation.Payment.listPayment
import com.swakarya.museumyog.presentation.Payment.listpayment2
import com.swakarya.museumyog.presentation.Payment.listpayment3
import com.swakarya.museumyog.presentation.PaymentMethod.method
import com.swakarya.museumyog.presentation.ProfileMenu.EditBahasa.EditBahasa
import com.swakarya.museumyog.presentation.ProfileMenu.EditProfile.EditProfileMenu
import com.swakarya.museumyog.presentation.ProfileMenu.KebijakanPrivasi.KebijakanPrivasi
import com.swakarya.museumyog.presentation.ProfileMenu.ProfileMenu
import com.swakarya.museumyog.presentation.ProfileMenu.PusatBantuan.PusatBantuanScreen
import com.swakarya.museumyog.presentation.informasikoleksi.informationkoleksi
import com.swakarya.museumyog.presentation.informasikoleksi.informationpage
import com.swakarya.museumyog.presentation.informasikoleksi.review
import com.swakarya.museumyog.presentation.kunjungan.AktifKunjungan
import com.swakarya.museumyog.presentation.kunjungan.RiwayatKunjungan
import com.swakarya.museumyog.presentation.singup.singUp
import com.swakarya.museumyog.presentation.onboarding.onboarding1
import com.swakarya.museumyog.presentation.onboarding.onboarding2
import com.swakarya.museumyog.presentation.onboarding.onboarding3
import com.swakarya.museumyog.presentation.splash.splashScreen
import com.swakarya.museumyog.presentation.ReviewUsers.ReviewUsers


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
        composable(route = "onboarding1") {
            onboarding1(navController)
        }
        composable(route = "onboarding2") {
            onboarding2(navController)
        }
        composable(route = "onboarding3") {
            onboarding3(navController)
        }

        composable(route = "method") {
            method(navController)
        }
        composable(route = "va") {
            VA(navController)
        }
        composable(route="home"){
            HomePage(
                text = "$username",
                onTextChange = {},
                placeHolder = "Mau ke Museum apa ?",
                onCloseClicked = {},
                onMicClicked = {},
                navController = navController)

    }
        composable(route="listMuseum"){
            ListMuseum(
                navController = navController,
                onSearchTextChange = {},
                placeHolder = "Mau ke Museum apa ?"
            )
        }
        composable(route="riwayatkunjungan"){
            RiwayatKunjungan(navController =navController )
        }
        composable(route="aktifkunjungan"){
            AktifKunjungan(navController =navController )
        }
        composable(route = "koleksi/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            informationkoleksi(photos = imageMuseum,
                name = nameMuseum,
                rate = rateMuseum,
                itemIndex = index.arguments?.getInt("index"),
                navController
            )
        }
        composable(route = "informasi/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            informationpage(
                photos = imageMuseum,
                name = nameMuseum,
                rate = rateMuseum,
                itemIndex = index.arguments?.getInt("index"),
                navController
            )
        }
        composable(route = "review/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            review(photos = imageMuseum,
                name = nameMuseum,
                rate = rateMuseum,
                itemIndex = index.arguments?.getInt("index"),
                navController
            )
        }
        composable(route = "pay1/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            listPayment(navController,
                itemIndex = index.arguments?.getInt("index")
            )
        }
        composable(route = "pay2/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            listpayment2(navController,
                itemIndex = index.arguments?.getInt("index")
            )
        }
        composable(route = "pay3/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            listpayment3(navController,
                itemIndex = index.arguments?.getInt("index")
            )
        }

        composable(route="profil"){
            ProfileMenu(navController =navController )
        }
        composable(route="bantuan"){
            PusatBantuanScreen(navController =navController )
        }
        composable(route="privasi"){
            KebijakanPrivasi(navController =navController )
        }
        composable(route="edit"){
            EditProfileMenu(navController =navController )
        }
        composable(route="editbahasa"){
            EditBahasa(navController =navController )
        }
        composable(route="notif"){
            NotificationScreen(navController =navController )
        }
        composable(route = "reviewUser") {
            ReviewUsers(navController)
        }

    }
}