package com.test.ecommercecompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.ecommercecompose.composables.HeaderCompose
import com.test.ecommercecompose.screens.ui.theme.EcommerceComposeTheme

class ProductDetailsComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceComposeTheme {
                // A surface container using the 'background' color from the theme
                ProductDetailsScreen()
            }
        }
    }
}

@Composable
fun ProductDetailsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        HeaderCompose()

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    EcommerceComposeTheme {
        ProductDetailsScreen()
    }
}