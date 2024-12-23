package com.example.fithabits.data

import com.example.fithabits.data.model.ResultLogin
import com.example.fithabits.data.model.ResultRegister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Body

data class LoginRequest(
    val User: String,
    val Pass: String
)
data class RegistroRequest(
    val User: String,
    val Pass: String,
    val Email: String
)

interface RetrofitService {
    @POST("login")
    suspend fun Login(
        @Body request: LoginRequest
    ): ResultLogin
    @POST("registrar")
    suspend fun Registrar(
        @Body request: RegistroRequest
    ):ResultRegister
}

object  RetrofitServiceFactory{
    fun makeRetrofitService(): RetrofitService{
        return Retrofit.Builder()
            .baseUrl("https://fithabits.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}
