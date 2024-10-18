package com.task.delivery.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

private const val API_URL ="https://www.themealdb.com/api/json/v1/1/"


    val api:MealApiService by lazy {
        Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApiService::class.java)
    }
}