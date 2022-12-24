package com.test.ecommercecompose.screens

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.ecommercecompose.composables.ImageCompose
import com.test.ecommercecompose.R
import com.test.ecommercecompose.composables.HeaderCompose
import com.test.ecommercecompose.composables.category
import com.test.ecommercecompose.composables.product
import com.test.ecommercecompose.model.CategoryData
import com.test.ecommercecompose.ui.theme.LightGrey
import com.test.ecommercecompose.ui.theme.Shapes

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeScreenCompose() {

    var visible by remember { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        HeaderCompose()

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                modifier = Modifier.padding(start=24.dp,top=12.dp, bottom = 12.dp),
                text = "Our Product",
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsblack))
                )
            )
//            Text(
//                modifier = Modifier
//                    .padding(start=24.dp,top=12.dp, bottom = 12.dp, end = 24.dp)
//                    .weight(1f),
//                text = "Sort by",
//                textAlign = TextAlign.End,
//                style = TextStyle(
//                    fontSize = 12.sp,
//                    color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppinsbold))
//                )
//            )
        }

        val categoryList = listOf(
            CategoryData("court vision low battery sneakers black", R.drawable.shoe,"Nike","Rs 9700"),
            CategoryData("Legacy & classic sneakers brown mens wear", R.drawable.nike1,"Nike","Rs 10909"),
            CategoryData("Green sparkle sports men's wear", R.drawable.nike5,"Nike","Rs 92839"),
            CategoryData("Lady queen for girls (Pink & white)", R.drawable.nike2,"Nike","Rs 9823"),
            CategoryData("Tanjun Red colour nike for men|women(unisex) - Red", R.drawable.nike3,"Nike","Rs 18977"),
            CategoryData("Tanjun made nike for men|women(unisex) - Blue", R.drawable.nike6,"Nike","Rs 7878"),
            CategoryData("Bounce premium sports shoe (unisex) - Red", R.drawable.nike7,"Nike","Rs 5000"),
            CategoryData("J&J party wear for men (High heels) - Red", R.drawable.nike8,"Nike","Rs 28499"),

            )


        LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.padding(10.dp))
        {
            items(categoryList) { item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    product(name = item.name,item.image,item.price){


                    }

                }
            }
        }

    }

}


