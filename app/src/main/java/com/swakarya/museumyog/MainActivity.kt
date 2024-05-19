package com.swakarya.museumyog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.swakarya.museumyog.navigation.Navigation
import com.swakarya.museumyog.presentation.kunjungan.AktifKunjungan
import com.swakarya.museumyog.navigation.Navigation
import com.swakarya.museumyog.presentation.home.HomePage
import com.swakarya.museumyog.ui.theme.MuseumyogmobileTheme
import com.swakarya.museumyog.navigation.Navigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseumyogmobileTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
