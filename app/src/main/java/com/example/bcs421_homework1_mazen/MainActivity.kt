package com.example.bcs421_homework1_mazen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bcs421_homework1_mazen.ui.theme.BCS421_HomeWork1_MazenTheme

// MainActivity class extending ComponentActivity
class MainActivity : ComponentActivity() {

    // onCreate method called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity using Compose
        setContent {

            // Apply the custom theme defined in BCS421_HomeWork1_MazenTheme
            BCS421_HomeWork1_MazenTheme {

                // Call the MainScreen composable function to define the UI
                MainScreen()
            }
        }
    }
}
