package com.example.textanimationjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.textanimationjetpackcompose.ui.theme.TextAnimationJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextAnimationJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimationSample1("Hello Kotlin")
                }
            }
        }
    }
}

@Composable
fun AnimationSample1(textItem: String) {
    val count = remember {
        mutableStateOf(1)
    }
    val previewText = remember { mutableStateOf(textItem.substring(0,count.value)) }

    fun handleClick() { // これをループさせたら文字列のアニメーションができる
        if (textItem.length == count.value) {
            count.value = 1
        } else {
            count.value++
        }
        previewText.value = textItem.substring(0,count.value)
//        println(previewText.value)
    }

    Column {
        Text(text = previewText.value)
        Button(onClick = { handleClick() } ) {
            Text(text = "ボタン")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextAnimationJetpackComposeTheme {
        Greeting("Android")
    }
}