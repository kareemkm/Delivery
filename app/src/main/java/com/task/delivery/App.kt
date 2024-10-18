package com.task.delivery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.delivery.view.Basket
import com.task.delivery.view.FavScreen
import com.task.delivery.view.HomeScreen
import com.task.delivery.view.ItemsDetails
import com.task.delivery.view.OrderComplete
import com.task.delivery.view.SplashScreen
import com.task.delivery.view.TrackOrder
import com.task.delivery.view.WelcomeScreen
import com.task.delivery.view.YourFirstName
import kotlinx.coroutines.delay

@Composable
fun App (){
    val navController = rememberNavController()

    var isSplash by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(2000)
        isSplash = false
    }

    NavHost(
        navController = navController,
        startDestination = if (isSplash) "splash" else "welcome"
    ){
        composable("splash"){ SplashScreen(navController = navController , onClick = {isSplash = false}) }
        composable("welcome") { WelcomeScreen(navController = navController) }
        composable("name") { YourFirstName(navController = navController) }
        composable("home") { HomeScreen(navController = navController) }

        composable("item/{meal.strMeal}/{image}") {backStackEntry ->
            val strMeal = backStackEntry.arguments?.getString("meal.strMeal")
            val strMealThumb = backStackEntry.arguments?.getString("image")
            ItemsDetails(name = strMeal, image = strMealThumb, navController = navController)
        }

        composable("basket") { Basket(navController = navController) }
        composable("fav") { FavScreen(navController = navController) }
        composable("complete") { OrderComplete(navController = navController) }
        composable("track") { TrackOrder(navController = navController) }
    }

}