package com.task.delivery.api

import com.task.delivery.model.Meal
import com.task.delivery.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    @GET("filter.php")
    suspend fun getMealByCategory(
        @Query("c") category:String
    ): MealResponse
}