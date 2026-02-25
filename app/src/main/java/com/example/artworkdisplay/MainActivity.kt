package com.example.artworkdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artworkdisplay.ui.theme.ArtworkDisplayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtworkDisplayTheme {
                ArtworkDisplay(
                    arrayOf("Dog", "Cat", "Banana"),
                    arrayOf("Artist1 (2000)", "Art2 (2005)", "John (2003)"),
                    arrayOf(R.drawable.wallpaper2you_256278, R.drawable.__domestic_cat_bjorn_svenssonscience_photo_library, R.drawable.what_goes_with_banana)
                )
            }
        }
    }
}

@Composable
fun ArtworkDisplay(listTitle: Array<String>, listArtist: Array<String>, listPic: Array<Int>, modifier: Modifier = Modifier) {
    var currentPic by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.padding(30.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = Color(65, 70, 120),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(listPic[currentPic]),
                    contentDescription = null
                )
            }

            Text(
                text = listTitle[currentPic],
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(
                    top = 20.dp
                )
            )
            Text(
                text = listArtist[currentPic],
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,
                modifier = Modifier.padding(
                    bottom = 15.dp
                )
            )

            Row {
                Button(
                    onClick = {
                        currentPic--
                        if(currentPic < 0) {
                            currentPic = listPic.size - 1
                        }
                    }
                ) {
                    Text(
                        text = "Previous"
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        currentPic++
                        if(currentPic > listPic.size - 1) {
                            currentPic = 0
                        }
                    }
                ) {
                    Text(
                        text = "Next"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDisplayPreview() {
    ArtworkDisplayTheme {
        ArtworkDisplay(
            arrayOf("Dog", "Cat", "Banana"),
            arrayOf("Artist1 (2000)", "Art2 (2005)", "John (2003)"),
            arrayOf(R.drawable.wallpaper2you_256278, R.drawable.__domestic_cat_bjorn_svenssonscience_photo_library, R.drawable.what_goes_with_banana)
        )
    }
}