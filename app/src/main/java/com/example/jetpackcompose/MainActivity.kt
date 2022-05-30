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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

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



            val painter = painterResource(id = R.drawable.logo)
            val contentDescription = "Real Madrid Logo"
            val title = "Real Madrid is Champion"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(5.dp)){
                ImageCard(painter = painter, contentDescription = contentDescription, title = title)
            }
        }
    }
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
                    style = TextStyle(color = Color.Blue, fontSize = 16.sp)
                )
            }
        }

    }
}