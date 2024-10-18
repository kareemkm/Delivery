package com.task.delivery.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.task.delivery.R

@Composable
fun SplashScreen(navController: NavController,onClick:()->Unit){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.splash),
            contentDescription = null
        )
    }
}