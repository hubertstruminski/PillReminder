package com.example.pillreminder.presentation.screens.authorization

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pillreminder.repository.AuthRepository
import com.example.pillreminder.storage.GlobalPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val preferences: GlobalPreferences,
): ViewModel() {
    var isLoading by mutableStateOf(false)
    var canLogin by mutableStateOf(false)

    fun logIn(email: String, password: String) {
        isLoading = true
        viewModelScope.launch {
            val response = authRepository.logIn(email, password)
            if(response?.token?.isNotEmpty() == true) {
                preferences.token = response.token
                isLoading = false
                canLogin = true
            }
        }
    }

    fun logout() {
        preferences.token = null
        preferences.rememberUserLogin = false
    }

    fun rememberUserLogin(isRememberMeEnabled: Boolean) {
        preferences.rememberUserLogin = isRememberMeEnabled
    }

    fun initRememberMeCheckbox(isRememberMeEnabled: MutableState<Boolean>) {
        isRememberMeEnabled.value = preferences.rememberUserLogin
    }
}