package com.David.loginreg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.David.loginreg.ui.theme.LoginRegTheme

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
          //          Greeting("Android")
                      Calc()
                }
            }
        }
    }
}

@Composable
fun Calc() {
    var firstnum by remember { mutableStateOf(TextFieldValue("")) }
    var secondnum by remember { mutableStateOf(TextFieldValue("")) }
    var answer by remember { mutableStateOf("") }
    val context= LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)) {
      Text(text = "Click to go to intent",
          fontSize = 20.sp,
          color = Color.Black,
          modifier = Modifier.clickable {
              val intent=Intent(context,IntentActivity::class.java)
              context.startActivity(intent)
          })

        Text(text = answer,
            color = Color.White,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
        OutlinedTextField(
            value =firstnum ,
            label = { Text(text = "Enter First No",
                color = Color.White,
                fontSize = 30.sp)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={
                firstnum=it

            } )
        Spacer(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth())
        OutlinedTextField(
            value =secondnum ,
            label = { Text(text = "Enter second No",
                color = Color.White,
                fontSize = 30.sp)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={

                secondnum=it

            } )
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecontnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() || mysecontnum.isEmpty()){
                    answer="Please fill in all detail"
                }else {
                    val myanswer = myfirstnum.toDouble() + mysecontnum.toDouble()
                    answer = myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "+",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecontnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecontnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() - mysecontnum.toDouble()
                    answer=myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "-",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum = firstnum.text.trim()
                val mysecontnum = secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecontnum.isEmpty()) {
                    answer = "Please fill in all detail"
                } else {
                    val myanswer = myfirstnum.toDouble() * mysecontnum.toDouble()
                    answer = myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "*",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecontnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecontnum.isEmpty()){
                    answer="Please fill in all detail"
                }else {
                    val myanswer = myfirstnum.toDouble() / mysecontnum.toDouble()
                    answer = myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "/",
                fontSize = 30.sp)


        }

    }


}



@Preview
@Composable
private fun calcprev() {
   Calc()
}