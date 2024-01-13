package com.example.pillreminder.repository

import android.util.Log
import com.example.pillreminder.model.AuthRequest
import com.example.pillreminder.model.AuthResponse
import com.example.pillreminder.network.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun logIn(email: String, password: String): AuthResponse {
        val response = try {
            authApi.logIn(AuthRequest(email, password))
        } catch(e: Exception) {
            Log.d("AuthAPI Error: ", e.message.toString())
        }
        return response as AuthResponse
    }
}