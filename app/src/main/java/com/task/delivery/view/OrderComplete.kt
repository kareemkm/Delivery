package com.task.delivery.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun OrderComplete(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .padding(top = 150.dp)
                .size(200.dp)
                .clip(shape = CircleShape)
                .background(Color(0xFF4CD964).copy(alpha = 0.1f))
                .border(width = 2.dp, color = Color(0xFF4CD964), shape = CircleShape),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFF4CD964)),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
        Text(
            text = "Congratulations!!!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 40.dp)
        )
        Text(
            text = "Your order have been taken and\nis being attended to",
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 30.dp)
        )
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA451),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(top = 40.dp)
                .height(60.dp),
            onClick = {
                navController.navigate("track"){
                    popUpTo("complete"){inclusive = true}
                }
            }
        ) {
            Text("Track order")
        }
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFFFFA451),
                disabledContainerColor = Color(0xFFFFA451)
            ),
            modifier = Modifier
                .padding(40.dp)
                .height(60.dp)
                .border(width = 1.dp,Color(0xFFFFA451),
                    shape = RoundedCornerShape(10.dp)
                ),
            onClick = {
                navController.navigate("home"){
                    popUpTo("complete"){inclusive = true}
                }
            }
        ) { Text(text = "Continue shopping") }
    }
}
