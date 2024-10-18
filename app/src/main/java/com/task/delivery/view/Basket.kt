package com.task.delivery.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Basket(navController: NavController){


    val sheetState = rememberModalBottomSheetState()
    var isOpen by remember { mutableStateOf(false) }

    ModelBottom(
        sheetState =sheetState,
        isOpen = isOpen,
        onDismissClick = { isOpen = false },
        payOnDeliveryClickButton = {navController.navigate("complete"); isOpen = false},
        payWithCarsClickButton = {navController.navigate("complete"); isOpen = false}
    )


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
                text = "My Basket",
                color = Color.White,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(start = 30.dp)


            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item{
                BasketItem(
                    image = "",
                    text = "Quinoa fruit salad",
                    price = "200"
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Total",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "60000 $",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFA451),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .height(59.dp)
                    .width(190.dp),
                onClick = {isOpen = true}
            ) {
                Text("Checkout")
            }
        }
    }
}

@Composable
fun BasketItem(
    image: String,
    text: String,
    price: String
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Image(
                painter = painterResource(R.drawable.recommended1),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(70.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "2packs",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
            Text(
                text = price,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelBottom(
    sheetState: SheetState,
    isOpen: Boolean,
    onDismissClick:()->Unit,
    payOnDeliveryClickButton:()->Unit,
    payWithCarsClickButton:()->Unit
){
    var address by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var ccv by remember { mutableStateOf("") }

    var bayCardState by remember { mutableStateOf(false) }


    if (isOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {onDismissClick()},
            dragHandle = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                )
            },
            containerColor = Color.Transparent,
            windowInsets = BottomSheetDefaults.windowInsets,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .clip(shape = CircleShape)
                        .clickable { onDismissClick(); bayCardState = false }
                        .background(Color.White)
                        .padding(10.dp)

                ){
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)

                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                        .background(Color.White),
                ) {
                    Text(
                        text = "Delivery address",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 30.dp, start = 30.dp)
                    )
                    TextField(
                        value = address,
                        onValueChange = {address = it},
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF3F1F1),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black
                        ),
                        placeholder = { Text("10th avenue, Lekki, Lagos State") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                    Text(
                        text = "Number we can call",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 20.dp, start = 30.dp)
                    )
                    TextField(
                        value = number,
                        onValueChange = {number = it},
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF3F1F1),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black
                        ),
                        placeholder = { Text("01024115925") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                    if (bayCardState){
                        Column(
                            modifier = Modifier
                            .fillMaxWidth()
                        ) {
                            Text(
                                text = "Number of Card",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 20.dp, start = 30.dp)
                            )
                            TextField(
                                value = number,
                                onValueChange = {number = it},
                                shape = RoundedCornerShape(10.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color(0xFFF3F1F1),
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    focusedTextColor = Color.Black
                                ),
                                placeholder = { Text("0000  0000 0000  0000") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp, vertical = 10.dp)
                            )
                            Row {
                                Text(
                                    text = "Date",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(top = 20.dp, start = 30.dp)
                                )
                                Text(
                                    text = "CCV",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(top = 20.dp, start = 160.dp)
                                )
                            }
                            Row {
                                TextField(
                                    value = date,
                                    onValueChange = {date = it},
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF3F1F1),
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        focusedTextColor = Color.Black
                                    ),
                                    placeholder = { Text("10/30") },
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 30.dp, vertical = 10.dp)
                                )
                                TextField(
                                    value = ccv,
                                    onValueChange = {ccv = it},
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF3F1F1),
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        focusedTextColor = Color.Black
                                    ),
                                    placeholder = { Text("123") },
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 30.dp, vertical = 10.dp)
                                )

                            }
                        }
                    }
                    if (bayCardState){
                        Button(
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color(0xFFFFA451),
                                disabledContainerColor = Color(0xFFFFA451)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 70.dp, vertical = 30.dp)
                                .height(60.dp)
                                .border(width = 1.dp,Color(0xFFFFA451),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            onClick = {payWithCarsClickButton()}
                        ) { Text(text = "Pay with card", fontSize = 12.sp) }
                    }else{
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color(0xFFFFA451),
                                    disabledContainerColor = Color(0xFFFFA451)
                                ),
                                modifier = Modifier
                                    .height(60.dp)
                                    .border(width = 1.dp,Color(0xFFFFA451),
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                onClick = {payOnDeliveryClickButton()}
                            ) { Text(text = "Pay on delivery", fontSize = 12.sp) }

                            Button(
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color(0xFFFFA451),
                                    disabledContainerColor = Color(0xFFFFA451)
                                ),
                                modifier = Modifier
                                    .height(60.dp)
                                    .border(width = 1.dp,Color(0xFFFFA451),
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                onClick = {bayCardState = true}
                            ) { Text(text = "Pay with card", fontSize = 12.sp) }
                        }
                    }
                }
            }
        }
    }
}