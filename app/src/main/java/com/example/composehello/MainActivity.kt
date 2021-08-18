package com.example.composehello

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

lateinit var scaffoldState: ScaffoldState
lateinit var scope: CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            scaffoldState = rememberScaffoldState()
            scope = rememberCoroutineScope()
            Scaffold(scaffoldState = scaffoldState, topBar = {
                TopAppBar(title = { Text(text = "Quotes X") })
            }, content = {
                InflateList()
            })
        }
    }
}

@Composable
private fun InflateList() {
    Surface(color = Color.White) {
        val famousQuotes = DataHelper().quotesMaker()
        LazyColumn() {
            item {
                famousQuotes.forEach { quote ->
                    if (famousQuotes.isEmpty()) {
                        Text(text = "No quotes")
                    } else {
                        Greeting(quote)
                        Divider(color = Color.Black, modifier = Modifier.shadow(6.dp))
                    }
                }
                Divider(color = Color.Transparent, thickness = 32.dp)
                Counter()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val backgroundColor by animateColorAsState(
        if (isSelected) {
            Color.Green
        } else {
            Color.Transparent
        }
    )
    Text(
        text = name,
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .background(backgroundColor, RectangleShape)
            .clickable {
                isSelected=!isSelected
            }
    )
}

@Composable
fun Counter() {
    var counter by remember {
        mutableStateOf(0)
    }
    Button(
        onClick = {
            counter++
        }, colors = ButtonDefaults.buttonColors(
            backgroundColor = if (counter >= 7) {
                Color.Green
            } else {
                Color.Cyan
            }
        )
    ) {
        Text(text = "I have been clicked $counter times")
        if (counter == 7) {
            scope.launch {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}