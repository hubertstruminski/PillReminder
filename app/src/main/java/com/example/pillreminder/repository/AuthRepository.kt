package com.example.pillreminder.repository

import android.util.Log
import com.example.pillreminder.model.AuthRequest
import com.example.pillreminder.model.AuthResponse
import com.example.pillreminder.network.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun logIn(email: String, password: String): AuthResponse? {
        try {
            val response = authApi.logIn(AuthRequest(email, password))
            if(response.isSuccessful) {
                return response.body()
            }
        } catch(e: Exception) {
            Log.d("API logIn Error: ", e.message.toString())
            return null
        }
        return null
    }
}