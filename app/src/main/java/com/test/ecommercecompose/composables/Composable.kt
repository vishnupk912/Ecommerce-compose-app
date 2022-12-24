package com.test.ecommercecompose.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.ecommercecompose.R
import com.test.ecommercecompose.model.CategoryData
import com.test.ecommercecompose.ui.theme.LightGrey
import java.io.FileDescriptor

@Composable
fun ImageCompose(modifier: Modifier, drawable: Int, description: String) {
    Image(
        painter = painterResource(id = drawable),
        contentDescription = description,
        modifier = modifier
    )
}


@Composable
fun HeaderCompose() {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
    ) {

        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(20.dp),
            drawable = R.drawable.menu,
            description = "menuIcon"
        )


        Text(
            text = "ShowShoe Mart",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsblack))
            )
        )

        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 20.dp, end = 4.dp, top = 20.dp,),
            drawable = R.drawable.search,
            description = "menuIcon"
        )
        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 20.dp, end = 20.dp, top = 20.dp,),
            drawable = R.drawable.diamond,
            description = "diamond"
        )



    }
}



@Preview(showBackground = false)
@Composable
fun product(name: String, drawable: Int, price: String, onProductClick: () -> Unit) {

    Card(
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(width = 0.5.dp, color = LightGrey)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(100f)
                .background(Color.White)
                .padding(16.dp)
                .clickable {
                    onProductClick()
                }
        ) {
//            Box(modifier = Modifier
//                .wrapContentWidth()
//                .wrapContentHeight()) {
//                ImageCompose(
//                    modifier = Modifier
//                        .size(32.dp),
//                    drawable = R.drawable.search,
//                    description = "product Image"
//                )
//            }

            ImageCompose(

                modifier = Modifier
                    .size(200.dp),
                drawable = drawable,
                description = "product Image"
            )


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                text = "Nike",
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsbold))
                )
            )
            Text(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                text = name,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppinsmedium))
                )
            )


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                text = price,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinssemibold))
                )
            )


        }
    }
}