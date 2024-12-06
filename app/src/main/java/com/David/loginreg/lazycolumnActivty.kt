package com.David.loginreg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.David.loginreg.ui.theme.LoginRegTheme

class lazycolumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
                    SimpleListView()
                }
            }
        }
    }
}
private val countryList =
    mutableListOf("Kenya","Pakistan","Uganda","United States")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.Black)
    .padding(10.dp)

private val textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.White)
@Composable
fun SimpleListView() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country, style = textStyle)
        }
    }
}


@Preview
@Composable
private fun SimpleListViewprev() {
    SimpleListView()

}