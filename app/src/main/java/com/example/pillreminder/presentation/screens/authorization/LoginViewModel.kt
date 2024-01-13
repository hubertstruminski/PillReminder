package com.example.pillreminder.presentation.screens.authorization

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pillreminder.repository.AuthRepository
import com.example.pillreminder.storage.GlobalPreferences
import com.example.pillreminder.util.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val preferences: GlobalPreferences,
): ViewModel() {

    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            val response = authRepository.logIn(email, password)
            if(response.token.isNotEmpty()) {
                preferences.token = response.token

                Log.d("LAST TOKEN VALUE: ", preferences.token!!)
            }
        }
    }
}