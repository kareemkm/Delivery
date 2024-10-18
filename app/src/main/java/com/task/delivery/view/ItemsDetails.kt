package com.task.delivery.view


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.task.delivery.R

@Composable
fun ItemsDetails(name:String?,image:String?,navController: NavController){

    var itemNum by remember { mutableIntStateOf(1) }
    val price by remember { mutableIntStateOf(2000) }
    var buttonState by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFA451))
            .verticalScroll(state = rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                    navController.navigate("home"){
                        popUpTo("item/{meal.strMeal}/{image}"){inclusive = true}
                    }
                }
                .background(Color.White)
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "Go back  ",
                color = Color.Black,
                fontSize = 13.sp
            )
        }
        Box (modifier = Modifier.align(Alignment.CenterHorizontally)
            .clip(shape = CircleShape)
            .size(200.dp),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = "$image",
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 40.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
        ) {
            Text(
                text = "$name",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 30.dp, start = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.minas),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                            if (itemNum != 1)  itemNum--
                        }
                    )
                    Text(
                        text = "$itemNum",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFFFFA451),
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { itemNum++ }
                    )
                }
                Text(
                    text = "${price*itemNum} $",
                    color = Color(0xFFFFA451),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "One Pack Contains:",
                color = Color.Black,
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp)
            )
            Box(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(2.dp)
                    .width(220.dp)
                    .background(Color(0xFFFFA451))
            )
            Text(
                text = "Red Quinoa, Lime, Honey, Blueberries, Strawberries,\nMango, Fresh mint.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp)
            )
            Text(
                text = "If you are looking for a new fruit salad to eat today,\nquinoa is the perfect brunch for you. make",
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 40.dp, start = 20.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(if (buttonState) R.drawable.fav else R.drawable.baseline_favorite_24),
                    contentDescription = null,
                    tint = Color(0xFFF08626),
                    modifier = Modifier
                        .padding(10.dp)
                        .size(25.dp)
                )
                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (buttonState) Color(0xFFFFA451) else Color.White,
                        contentColor = if (buttonState)Color.White else Color(0xFFFFA451)
                    ),
                    modifier = Modifier
                        .height(56.dp)
                        .width(219.dp)
                        .border(width = 1.dp, color = if (buttonState) Color.White else Color(0xFFFFA451), shape = RoundedCornerShape(10.dp)) ,
                    onClick = {buttonState = !buttonState}
                ) {
                    Text(
                        text = if (buttonState) "Add to basket" else "Added"
                    )
                }
            }

        }
    }
}