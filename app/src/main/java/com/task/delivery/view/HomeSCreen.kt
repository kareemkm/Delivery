package com.task.delivery.view

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.task.delivery.R
import com.task.delivery.viewModel.MealViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: MealViewModel = viewModel(),
    navController: NavController
) {


    var combose by remember { mutableStateOf("") }

    var selectedCategory by remember { mutableStateOf("Beef") }
    viewModel.getMealsByCategory(selectedCategory)

    val meals by viewModel.meal.collectAsState()
    val error by viewModel.errorMessage.collectAsState()

    var isRefresh by remember { mutableStateOf(false) }


    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefresh),
        onRefresh = {
            isRefresh = true
            viewModel.getMealsByCategory(selectedCategory)
            isRefresh = false
        },
        indicator = { state, refreshTriggerDistance ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTriggerDistance,
                contentColor = Color(0xFFFFA451)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(state = rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color(0xFFFFA451),
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = CircleShape)
                            .clickable { navController.navigate("fav") }
                    )
                    Text(
                        text = "my favorite",
                        color = Color(0xFFFFA451),
                        fontSize = 8.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.basket),
                        contentDescription = null,
                        tint = Color(0xFFFFA451),
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = CircleShape)
                            .clickable { navController.navigate("basket") }
                    )
                    Text(
                        text = "my basket",
                        color = Color(0xFFFFA451),
                        fontSize = 8.sp
                    )
                }
            }
            Text(
                text = "Hello kareem, What fruit salad\ncombo do you want today?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
            OutlinedTextField(
                value = combose,
                onValueChange = { combose = it },
                placeholder = { Text(text = "Search for fruit salad combos", fontSize = 12.sp) },
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF3F4F9),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedTextColor = Color(0xFF86869E),
                    focusedTextColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.bi_search),
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            )
            Text(
                text = "Recommended Combo",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            LazyRow {

                items(viewModel.mealCategory) { category ->
                    val isSelected = selectedCategory == category
                    Text(
                        text = category,
                        fontSize = if (isSelected) 20.sp else 14.sp,
                        color = if (isSelected) Color.Black else Color(0xFF938DB5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = if (isSelected) 25.dp else 5.dp)
                            .border(
                                width = if (isSelected) 2.dp else 0.dp,
                                color = if (isSelected) Color(0xFFFFA451) else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                selectedCategory = category
                                viewModel.getMealsByCategory(category)
                            }

                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {

                if (error != null) {
                    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("error_animation.json"))
                    val progress by animateLottieCompositionAsState(
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )
                    LottieAnimation(
                        composition = composition,
                        progress = progress,
                    )
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(5.dp)
                    ) {
                        items(meals) { meal ->
                            Recommended(
                                image = meal.strMealThumb,
                                text = meal.strMeal,
                                price = "200",
                                onClick = {
                                    val image = Uri.encode(meal.strMealThumb)
                                    try {
                                        navController.navigate("item/${meal.strMeal}/$image")
                                    }catch (e:Exception){
                                        Log.e("kareem","${e.message}")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Recommended(
    image: String,
    text: String,
    price: String,
    onClick: () -> Unit,
) {
    var isFav by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(183.dp)
            .padding(5.dp)
            .clickable { onClick() }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Icon(
                painter = painterResource(if (isFav) R.drawable.baseline_favorite_24 else R.drawable.fav),
                contentDescription = null,
                tint = Color(0xFFF08626),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .size(25.dp)
                    .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {isFav = !isFav}
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                        .clip(shape = CircleShape)
                ) {
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                LazyRow {
                    item {
                        Text(
                            text = text,
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp, horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$price $",
                        fontSize = 16.sp,
                        color = Color(0xFFF08626),
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFFF08626),
                        modifier = Modifier
                            .size(30.dp)
                            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {

                        }
                    )
                }
            }
        }
    }
}