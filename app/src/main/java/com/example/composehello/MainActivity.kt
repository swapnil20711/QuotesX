package com.example.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = {
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
        val famousQuotes=DataHelper().quotesMaker()
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
    Text(
        text = name,
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Counter() {
    val counter = remember {
        mutableStateOf(0)
    }
    Button(onClick = { counter.value++ }) {
        Text(text = "I have been clicked ${counter.value} times")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InflateList()
}