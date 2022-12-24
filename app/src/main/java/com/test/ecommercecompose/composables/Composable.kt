package com.test.ecommercecompose.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.ecommercecompose.R
import com.test.ecommercecompose.model.CategoryData
import com.test.ecommercecompose.screens.ProfileComposeActivity
import com.test.ecommercecompose.ui.theme.LightBlue
import com.test.ecommercecompose.ui.theme.LightGrey
import com.test.ecommercecompose.utils.openActivity
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
    val context = LocalContext.current

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
            text = "Foot Bay",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsblack))
            )
        )

        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 20.dp, end = 4.dp, top = 20.dp),
            drawable = R.drawable.search,
            description = "menuIcon"
        )
        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .clickable {
                    context.openActivity(ProfileComposeActivity::class.java)
                }
                .padding(bottom = 20.dp, end = 20.dp, top = 20.dp),
            drawable = R.drawable.diamond,
            description = "diamond"
        )


    }
}


@Composable
fun DetaillsScreenHeaderCompose(name: String) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(LightBlue)
    ) {

        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(20.dp),
            drawable = R.drawable.arrow_left,
            description = "arrowLeft"
        )


        Text(
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            text = name,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinsblack))
            )
        )


        ImageCompose(
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 20.dp, end = 20.dp, top = 20.dp),
            drawable = R.drawable.heart,
            description = "favorite"
        )


    }
}

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

@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}


@Preview
@Composable
fun ProfileTiles(headerName: String, subHeader: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(16.dp)

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            text = headerName,
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black, fontFamily = FontFamily(Font(R.font.poppinssemibold))
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            text = subHeader,
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppinsregular))
            )
        )

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(onSheetClick: () -> Unit) {


}