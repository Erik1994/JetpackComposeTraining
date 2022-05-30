package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(0.9f)
//                    .height(200.dp)
//                    .background(Color.Gray),
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "Hello")
//                Text(text = "Erik")
//                Text(text = "Hello")
//            }


//            Column(
//                modifier = Modifier
//                    .background(Color.Gray)
//                    .fillMaxHeight(0.5f)
//                    .fillMaxWidth()
//                    //.padding(start = 30.dp, top = 50.dp)
//                    .border(10.dp, Color.DarkGray)
//                    .padding(10.dp)
//                    .border(10.dp, Color.White)
//                    .padding(10.dp)
//                    .border(15.dp, Color.DarkGray)
//                    .padding(15.dp)
//                    //.padding(vertical = 21.dp)
//                    //.width(100.dp)
//                    //.requiredWidth(300.dp)
//            ) {
//                Text(text = "Hello", modifier = Modifier.clickable {
//
//                })//, modifier = Modifier.offset(0.dp, 20.dp))
//                Spacer(modifier = Modifier.height(50.dp))
//                Text(text = "World!!!")
//            }

            val fontFamily = FontFamily(
                Font(R.font.lexend_light, FontWeight.Light),
                Font(R.font.lexend_black, FontWeight.Black),
                Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
                Font(R.font.lexend_extralight, FontWeight.ExtraLight),
                Font(R.font.lexend_medium, FontWeight.Medium),
                Font(R.font.lexend_regular, FontWeight.Normal),
                Font(R.font.lexend_semibold, FontWeight.SemiBold),
                Font(R.font.lexend_bold, FontWeight.Bold)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF00d7ff))
            ) {

                /** ********* **/

                // Image Card
//                val painter = painterResource(id = R.drawable.logo)
//                val contentDescription = "Real Madrid Logo"
//                val title = "Real Madrid is Champion"
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(0.5f)
//                        .padding(5.dp)
//                ) {
//                    ImageCard(
//                        painter = painter,
//                        contentDescription = contentDescription,
//                        title = title
//                    )
//                }

                /** ********* **/

                // Text styling
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Gray,
//                                fontSize = 40.sp,
//                                fontStyle = FontStyle.Normal
//                            )
//                        ) {
//                            append("A")
//                        }
//                        append("ndroid ")
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Gray,
//                                fontSize = 40.sp,
//                                fontStyle = FontStyle.Normal
//                            )
//                        ) {
//                            append(" D")
//                        }
//                        append("eveloper")
//                    },
//                    color = Color.DarkGray,
//                    fontSize = 30.sp,
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    fontStyle = FontStyle.Italic,
//                    textAlign = TextAlign.Center,
//                )

                /** ********* **/

                // State

                Column(Modifier.fillMaxSize()) {
                    val color = remember {
                        mutableStateOf(Color.Yellow)
                    }

                    ColorBox(
                        Modifier
                            .weight(1f)
                            .fillMaxSize()) {
                        color.value = it
                    }

                    Box(
                        modifier = Modifier
                            .background(color = color.value)
                            .weight(1f)
                            .fillMaxSize()
                    )
                }

            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Gray)
            .clickable {
                updateColor(Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                ))
            }
    )
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 11.dp
    ) {
        Box(modifier = Modifier.height(350.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Blue
                            ),
                            startY = 400f
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }

    }
}