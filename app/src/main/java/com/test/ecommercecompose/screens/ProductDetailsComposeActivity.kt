package com.test.ecommercecompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.ecommercecompose.R
import com.test.ecommercecompose.composables.DetaillsScreenHeaderCompose
import com.test.ecommercecompose.composables.HeaderCompose
import com.test.ecommercecompose.composables.ImageCompose
import com.test.ecommercecompose.composables.ProfileTiles
import com.test.ecommercecompose.screens.ui.theme.EcommerceComposeTheme
import com.test.ecommercecompose.ui.theme.LightBlue
import com.test.ecommercecompose.ui.theme.LightGrey
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope as coroutineScope1
import kotlinx.coroutines.coroutineScope as coroutineScope2
import kotlinx.coroutines.*

class ProductDetailsComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")

        setContent {
            EcommerceComposeTheme {
                // A surface container using the 'background' color from the theme
                DetailsScreen(image, name, price)


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    EcommerceComposeTheme {
        DetailsScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(image: Int? = null, name: String? = null, price: String? = null) {
    val scope = rememberCoroutineScope()

    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    var addToCartButtonState by remember {
        mutableStateOf(false)
    }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        DetaillsScreenHeaderCompose(name.toString())

        if (image != null) {
            ImageCompose(
                modifier = Modifier
                    .background(LightBlue)
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(20.dp),
                drawable = image,
                description = "productImage"
            )
        }



        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                text = name.toString()
                    .toUpperCase(),
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppinsbold))
                )
            )


            Button(
                onClick = {

                    scope.launch {
                        sheetState.expand()

                    }

                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Buy now",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White, fontFamily = FontFamily(Font(R.font.poppinsbold))
                    )
                )

            }
        }

        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp),
            text = price.toString().toUpperCase(),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsbold))
            )
        )


        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp),
            text = "Nike Air cushioning reduces the weight of the shoe without reducing performance. The lighter the shoe is, the less energy athletes put out during their performance. Athletes need the cushioning in their footwear to last, and Nike Air is designed to provide support throughout the life of the shoe.".toString()
                .toUpperCase(),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinslight))
            )
        )


    }

    addToCartButtonState = sheetState.isCollapsed
    if (addToCartButtonState) {
        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Add to cart ",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White, fontFamily = FontFamily(Font(R.font.poppinsbold))
                    )
                )

            }


        }

    }





}

