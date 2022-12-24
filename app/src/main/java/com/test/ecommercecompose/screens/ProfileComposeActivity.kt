package com.test.ecommercecompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.ecommercecompose.R
import com.test.ecommercecompose.composables.HeaderCompose
import com.test.ecommercecompose.composables.ImageCompose
import com.test.ecommercecompose.composables.ProfileTiles
import com.test.ecommercecompose.screens.ui.theme.EcommerceComposeTheme
import com.test.ecommercecompose.ui.theme.LightGrey

class ProfileComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderCompose()

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 20.dp, top = 20.dp),
            text = "My profile",
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinssemibold))
            )
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            ImageCompose(
                modifier = Modifier
                    .size(100.dp),
                drawable = R.drawable.logo,
                description = "product Image"
            )

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp),
                    text = "Alexender Freddy",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinssemibold))
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 20.dp),
                    text = "alex.freddy@gmail.com",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppinssemibold))
                    )
                )
            }
        }

        ProfileTiles(headerName = "My Orders", subHeader = "You have no orders")
        Divider(color = LightGrey, thickness = 0.5.dp)

        ProfileTiles(headerName = "Shipping Address", subHeader = "Add your delivery address")
        Divider(color = LightGrey, thickness = 0.5.dp)

        ProfileTiles(headerName = "Payment Methods", subHeader = "Add your card ")
        Divider(color = LightGrey, thickness = 0.5.dp)

        ProfileTiles(headerName = "Promocodes", subHeader = "Avail your promo codes")
        Divider(color = LightGrey, thickness = 0.5.dp)

        ProfileTiles(headerName = "My reviews", subHeader = "You have no orders")
        Divider(color = LightGrey, thickness = 0.5.dp)

        ProfileTiles(headerName = "Settings", subHeader = "notifications, password")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    EcommerceComposeTheme {
        ProfileScreen()
    }
}

