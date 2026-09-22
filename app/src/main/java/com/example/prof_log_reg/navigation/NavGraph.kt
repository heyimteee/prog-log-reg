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
            PlaceholderScreen(
                title = "Login (skeleton — Issue 4)",
                buttonLabel = "Go to Register",
                onButton = { navController.navigate(Routes.REGISTER) }
            )
        }
        composable(Routes.REGISTER) {
            PlaceholderScreen(
                title = "Register (skeleton — Issue 3)",
                buttonLabel = "Go to Profile",
                onButton = { navController.navigate(Routes.PROFILE) }
            )
        }
        composable(Routes.PROFILE) {
            PlaceholderScreen(
                title = "Profile (skeleton — Issue 5)",
                buttonLabel = "Go to Avatar",
                onButton = { navController.navigate(Routes.AVATAR) }
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
