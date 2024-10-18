package com.task.delivery.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.delivery.api.RetrofitClient
import com.task.delivery.model.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel:ViewModel() {

    val mealCategory = listOf(
        "Beef",
        "Chicken",
        "Dessert",
        "Lamb",
        "Pasta",
        "Pork",
        "Seafood",
        "Side",
        "Starter",
        "Vegan",
        "Vegetarian",
        "Breakfast",
        "Miscellaneous",
        "Goat"
    )

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meal: StateFlow<List<Meal>> = _meals.asStateFlow()


    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage : StateFlow<String?> = _errorMessage.asStateFlow()


    fun getMealsByCategory(category: String){
        viewModelScope.launch(Dispatchers.IO) {
            _errorMessage.value = null
            try {
                val response = RetrofitClient.api.getMealByCategory(category = category)
                _meals.value = response.meals
            }catch (e: Exception){
                _errorMessage.value = e.message
            }
        }
    }





}














































