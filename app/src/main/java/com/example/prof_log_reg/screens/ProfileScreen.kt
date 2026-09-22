package com.example.prof_log_reg.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prof_log_reg.model.SessionViewModel
import com.example.prof_log_reg.navigation.Routes
import com.example.prof_log_reg.ui.theme.PinkTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    sessionViewModel: SessionViewModel
) {
    val user = sessionViewModel.currentUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profil User") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PinkTopBar,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        if (user == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("No user data — please register first")
                Button(
                    onClick = {
                        navController.navigate(Routes.REGISTER) {
                            popUpTo(Routes.PROFILE) { inclusive = true }
                        }
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Go to Register")
                }
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = PinkTopBar
                    )
                    Column {
                        Text(
                            text = "${user.firstName} ${user.lastName}".trim(),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "@${user.username}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = user.email,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            InfoRow(Icons.Default.Person, "Username", user.username)
            InfoRow(Icons.Default.Email, "Email", user.email)
            InfoRow(Icons.Default.Lock, "Password", "•".repeat(user.password.length.coerceAtMost(8)))
            InfoRow(Icons.Default.Phone, "Phone", user.phone)
            InfoRow(Icons.Default.Home, "Address", user.address)
            InfoRow(Icons.Default.DateRange, "Birth Date", user.birthDate)
            InfoRow(Icons.Default.Person, "First Name", user.firstName)
            InfoRow(Icons.Default.Person, "Last Name", user.lastName)

            Button(
                onClick = { navController.navigate(Routes.AVATAR) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Lihat Avatar")
            }

            OutlinedButton(
                onClick = {
                    sessionViewModel.logout()
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}

@Composable
private fun InfoRow(icon: ImageVector, label: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = PinkTopBar)
            Column {
                Text(text = label, style = MaterialTheme.typography.labelSmall)
                Text(text = value, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
