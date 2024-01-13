package com.example.pillreminder.network

import com.example.pillreminder.model.AuthRequest
import com.example.pillreminder.model.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface AuthApi {

    @POST(value = "/auth/login")
    suspend fun logIn(@Body authRequest: AuthRequest): AuthResponse
}