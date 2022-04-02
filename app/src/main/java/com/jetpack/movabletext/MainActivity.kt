package com.jetpack.movabletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.movabletext.ui.theme.MovableTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovableTextTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Movable Text",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            MovableText()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovableText() {
    var isRow by remember { mutableStateOf(true) }
    val boxes = remember { movableContentOf {
            LetterBox(letter = 'M')
            LetterBox(letter = 'J')
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isRow = !isRow }
        ) {
            Text(text = "Switch")
        }

        if (isRow) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                boxes()
            }
        } else {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                boxes()
            }
        }
    }
}

@Composable
fun LetterBox(
    modifier: Modifier = Modifier,
    letter: Char
) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .size(150.dp)
            .background(
                if (letter == 'M') Color(0xFF3DDC84) else Color(0xFF073042),
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 80.sp
            )
        )
    }
}

























