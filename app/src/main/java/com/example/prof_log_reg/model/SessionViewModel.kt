package com.example.prof_log_reg.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SessionViewModel : ViewModel() {
    var currentUser: User? by mutableStateOf(null)
        private set

    var isLoggedIn: Boolean by mutableStateOf(false)
        private set

    fun register(user: User) {
        currentUser = user
        isLoggedIn = true
    }

    fun login(username: String, password: String): Boolean {
        val user = currentUser
        return if (user != null &&
            user.username == username &&
            user.password == password
        ) {
            isLoggedIn = true
            true
        } else {
            false
        }
    }

    fun logout() {
        isLoggedIn = false
    }
}
