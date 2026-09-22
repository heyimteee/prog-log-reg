package com.example.prof_log_reg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.prof_log_reg.model.SessionViewModel
import com.example.prof_log_reg.navigation.NavGraph
import com.example.prof_log_reg.ui.theme.ProfLogRegTheme

class MainActivity : ComponentActivity() {
    private val sessionViewModel: SessionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfLogRegTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    sessionViewModel = sessionViewModel
                )
            }
        }
    }
}
