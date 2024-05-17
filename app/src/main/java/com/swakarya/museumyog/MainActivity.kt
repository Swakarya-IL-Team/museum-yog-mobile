package com.swakarya.museumyog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.swakarya.museumyog.navigation.Navigation
import com.swakarya.museumyog.ui.theme.MuseumyogmobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseumyogmobileTheme {
                Navigation()
            }
        }
    }
}