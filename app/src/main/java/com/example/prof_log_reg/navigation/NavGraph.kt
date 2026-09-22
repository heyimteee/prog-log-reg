package com.example.prof_log_reg.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prof_log_reg.screens.LoginScreen
import com.example.prof_log_reg.screens.ProfileScreen
import com.example.prof_log_reg.screens.RegisterScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    sessionViewModel: com.example.prof_log_reg.model.SessionViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.REGISTER) {
            RegisterScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.PROFILE) {
            ProfileScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.AVATAR) {
            PlaceholderScreen(
                title = "Avatar (skeleton — Issue 6)",
                buttonLabel = "Back to Login",
                onButton = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}

@Composable
private fun PlaceholderScreen(
    title: String,
    buttonLabel: String,
    onButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButton) {
            Text(buttonLabel)
        }
    }
}
