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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.task.delivery.R
import com.task.delivery.viewModel.MealViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourFirstName(viewModel: MealViewModel = viewModel(), navController: NavController){

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFA451))
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(top = 150.dp), contentAlignment = Alignment.Center) {
            Column {
                Image(
                    painter = painterResource(R.drawable.first_name_screen),
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
                    text = "What is your firstname?",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 50.dp, start = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text(text = "name", color = Color(0xFFC2BDBD)) },
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFF3F1F1),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA451)),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        navController.navigate("home"){
                            popUpTo("name"){inclusive = true}
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