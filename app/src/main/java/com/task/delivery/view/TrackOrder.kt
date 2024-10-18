package com.task.delivery.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.delivery.R

@Composable
fun TrackOrder(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFFFA451))
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 60.dp, bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { navController.navigate("home") }
                    .background(Color.White)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Go back  ",
                    color = Color.Black,
                    fontSize = 10.sp
                )
            }
            Text(
                text = "Delivery Status",
                color = Color.White,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(start = 30.dp)


            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column(modifier = Modifier.padding(top = 100.dp, bottom =10.dp )
                .padding(start = 55.dp)
                .fillMaxHeight()
                .width(1.75.dp)
            ){
                repeat(185){index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp)
                            .background(if(index % 2 == 0) Color(0xFFFFA451) else Color.Transparent)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier =Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFFFAEB))
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.order_teken),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Text(
                        text = "Order Taken",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 20.dp).weight(1f)
                    )
                    Box(
                        modifier = Modifier.padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ttrue),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier =Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF1EFF6))
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.order_binig),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Text(
                        text = "Order Is Being Prepared",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 20.dp).weight(1f)
                    )
                    Box(
                        modifier = Modifier.padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ttrue),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier =Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFEF0F0))
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.order_dev),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Text(
                        text = "Order Is Being Delivered",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 20.dp).weight(1f)
                    )
                    Box(
                        modifier = Modifier.padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.call),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                                .clip(shape = CircleShape)
                                .clickable {  }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .height(128.dp)
                        .fillMaxWidth()
                ){
                    Image(
                        painter = painterResource(R.drawable.map),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier =Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFFFAEB))
                            .padding(15.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.ttrue),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Text(
                        text = "Order Received",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 20.dp).weight(1f)
                    )
                    Box(
                        modifier = Modifier.padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.three),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                                .clip(shape = CircleShape)
                                .clickable {  }
                        )
                    }
                }
            }
        }
    }
}