package com.swakarya.museumyog.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swakarya.museumyog.app.component.SharedVariables.fullname
import com.swakarya.museumyog.data.model.nameMuseum
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
import com.swakarya.museumyog.presentation.ReviewUsers.ReviewUsers
import com.swakarya.museumyog.presentation.home.HomePage
import com.swakarya.museumyog.presentation.informasikoleksi.InformationKoleksi.InformationKoleksi
import com.swakarya.museumyog.presentation.informasikoleksi.InformationPage.InformationPage
import com.swakarya.museumyog.presentation.informasikoleksi.InformationReview.ReviewPage
import com.swakarya.museumyog.presentation.kunjungan.AktifKunjungan
import com.swakarya.museumyog.presentation.kunjungan.RiwayatKunjungan
import com.swakarya.museumyog.presentation.login.login
import com.swakarya.museumyog.presentation.onboarding.onboarding1
import com.swakarya.museumyog.presentation.onboarding.onboarding2
import com.swakarya.museumyog.presentation.onboarding.onboarding3
import com.swakarya.museumyog.presentation.singup.singUp
import com.swakarya.museumyog.presentation.splash.splashScreen
import com.swakarya.museumyog.presentation.tiket.tiket
import com.swakarya.museumyog.presentation.tiket.tiketOTS

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable(route = "splash") {
            splashScreen(navController)
        }
        composable("login") {
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

        composable(route = "method/{index}/{name}/{image}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "image") {
                    type = NavType.IntType
                },
            )) { entry ->
            val name = entry.arguments?.getString("name") ?: ""
            val image = entry.arguments?.getInt("image") ?: 0
            method(
                navController,
                itemIndex = entry.arguments?.getInt("index"),
                name = name,
                image = image,
            )
        }
        composable(route = "va/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            VA(
                navController,
                itemIndex = index.arguments?.getInt("index")
            )
        }
        composable(route = "home") {
            HomePage(
                text = "$fullname",
                onTextChange = {},
                placeHolder = "Mau ke Museum apa ?",
                onCloseClicked = {},
                onMicClicked = {},
                navController = navController
            )

        }
        composable(route = "listMuseum") {
            ListMuseum(
                navController = navController,
                onSearchTextChange = {},
                placeHolder = "Mau ke Museum apa ?"
            )
        }
        composable(route = "riwayatkunjungan") {
            RiwayatKunjungan(navController = navController)
        }
        composable(route = "aktifkunjungan") {
            AktifKunjungan(navController = navController)
        }
        composable(route = "koleksi/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            InformationKoleksi(
                itemIndex = index.arguments?.getInt("index"),
                navController = navController
            )
        }
        composable(route = "informasi/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            InformationPage(
                itemIndex = index.arguments?.getInt("index"),
                navController = navController
            )
        }
        composable(route = "review/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            ReviewPage(
                itemIndex = index.arguments?.getInt("index"),
                navController = navController
            )
        }
        composable(route = "pay1/{index}/{name}/{image}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "image") {
                    type = NavType.IntType
                },

            )) { entry ->
            val name = entry.arguments?.getString("name") ?: ""
            val image = entry.arguments?.getInt("image") ?: 0

            listPayment(
                navController = navController,
                name = name,
                itemIndex = entry.arguments?.getInt("index"),
                image = image,

            )
        }

        composable(route = "pay2/{index}/{name}/{image}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "image") {
                    type = NavType.IntType
                },

            )) { entry ->
            val name = entry.arguments?.getString("name") ?: ""
            val image = entry.arguments?.getInt("image") ?: 0
            listpayment2(
                navController = navController,
                name = name,
                itemIndex = entry.arguments?.getInt("index"),
                image = image,

            )
        }

        composable(route = "pay3/{index}/{name}/{image}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "image") {
                    type = NavType.IntType
                },
            )) { entry ->
            val name = entry.arguments?.getString("name") ?: ""
            val image = entry.arguments?.getInt("image") ?: 0

            listpayment3(
                navController = navController,
                name = name,
                itemIndex = entry.arguments?.getInt("index"),
                image = image,
            )
        }
        composable(route = "profil") {
            ProfileMenu(navController = navController)
        }
        composable(route = "bantuan") {
            PusatBantuanScreen(navController = navController)
        }
        composable(route = "privasi") {
            KebijakanPrivasi(navController = navController)
        }
        composable(route = "edit") {
            EditProfileMenu(navController = navController)
        }
        composable(route = "editbahasa") {
            EditBahasa(navController = navController)
        }
        composable(route = "notif") {
            NotificationScreen(navController = navController)
        }
        composable(route = "reviewUser/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            ReviewUsers(
                itemIndex = index.arguments?.getInt("index"),
                navController = navController
            )
        }
        composable(route = "tiket/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )) { index ->
            tiket(
                navController,
                name = nameMuseum,
                itemIndex = index.arguments?.getInt("index")
            )
        }
        composable(
            route = "tiketOTS/{itemIndex}/{name}/{selectedDate}/{image}",
            arguments = listOf(
                navArgument("itemIndex") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType },
                navArgument("selectedDate") { type = NavType.StringType },
                navArgument("image") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val itemIndex = backStackEntry.arguments?.getInt("itemIndex")
            val name = backStackEntry.arguments?.getString("name")
            val selectedDate = backStackEntry.arguments?.getString("selectedDate")
            val image = backStackEntry.arguments?.getInt("image")

            if (name != null && selectedDate != null && image != null) {
                tiketOTS(
                    navController = navController,
                    name = name,
                    itemIndex = itemIndex,
                    selectedDate = selectedDate,
                    image = image
                )
            }
        }
    }
}
