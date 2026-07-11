package com.example.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profilepage.ui.theme.ProfilePageTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilePageTheme {
                NavController()
            }
        }
    }
}

@Composable
fun NavController(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Screen1")

    {
        composable("Screen1"){
            UserProfile(navController = navController
            )
        }

        composable("Screen2") {
            EditProfile(navController = navController)
        }
    }

}