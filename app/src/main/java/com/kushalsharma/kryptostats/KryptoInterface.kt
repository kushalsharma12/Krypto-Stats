package com.kushalsharma.kryptostats

import com.kushalsharma.unsplashphotos.Modals.Coins
import retrofit2.Response
import retrofit2.http.GET

const val API_KEY = BuildConfig.API_KEY

interface KryptoInterface {

    @GET("v1/coins?api_key=$API_KEY")
    suspend fun getCoins()
            : Response<Coins>

}

