package com.example.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composehello.ui.theme.ComposeHelloTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = {
                TopAppBar(title = { Text(text = "Quotes X") })
            }, content = {
                ButtonPractice()
            })
        }
    }
}

@Composable
fun ButtonPractice() {
    OutlinedButton(onClick = {}) {
        Text(text = "Hello World",Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeHelloTheme {
        ButtonPractice()
    }
}