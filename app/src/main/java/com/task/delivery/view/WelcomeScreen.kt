package com.task.delivery.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.delivery.R

@Composable
fun WelcomeScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFA451))
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(top = 150.dp), contentAlignment = Alignment.Center) {
            Column {
                Image(
                    painter = painterResource(R.drawable.welcome_image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(301.dp)
                        .height(260.dp)
                )
                Image(
                    painter = painterResource(R.drawable.shadw_welcome),
                    contentDescription = null,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
        Box(modifier = Modifier.fillMaxWidth().weight(1f).background(Color.White)) {
            Column (modifier = Modifier.fillMaxSize()){
                Text(
                    text = "Get The Freshest Fruit Salad Combo",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 50.dp, start = 20.dp)
                )
                Text(
                    text = "We deliver the best and freshest fruit salad in\ntown. Order for a combo today!!!",
                    color = Color(0xFF5D577E),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA451)),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        navController.navigate("name"){
                            popUpTo("welcome"){inclusive = true}
                        }
                    }
                ) {
                    Text(
                        text = "Let’s Continue"
                    )
                }
            }
        }
    }
}