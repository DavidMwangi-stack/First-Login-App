package com.David.loginreg

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.David.loginreg.ui.theme.LoginRegTheme
import java.net.URL

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                //    Greeting("Android")
                    IntentScreen()
                }
            }
        }
    }
}

@Composable
fun IntentScreen() {
    //create 7 buttons namely ,sms,call,dial,camera,share,stk/mpesa,email...
    var sms by remember { mutableStateOf("") }
    var call by remember { mutableStateOf("") }
    var dial by remember { mutableStateOf("") }
    var camera by remember { mutableStateOf("") }
    var share by remember { mutableStateOf("") }
    var mpesa by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 18.dp)
    ) {
        Text(
            text = "Highland's logins",
            color = Color.Green,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val uri = Uri.parse("smsto:0711366886")

                val intent = Intent(Intent.ACTION_SENDTO, uri)

                intent.putExtra("Hello", "How is todays weather")

                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "sms",
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254711366886"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "call",
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val phone = "+254711366886"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                context.startActivity(intent)

            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "dial",
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {

                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                startActivityForResult(context as Activity,takePictureIntent,1,null)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "camera",
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "share",
                fontSize = 20.sp
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val uri = Uri.parse("smsto:0711366886")

                val intent = Intent(Intent.ACTION_SENDTO, uri)

                intent.putExtra("Hello", "How is todays weather")

                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "mpesa",
                fontSize = 20.sp
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
                emailIntent.putExtra(Intent.EXTRA_TEXT,"body")
                 context.startActivity(Intent.createChooser(emailIntent,"Send email..."))
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "email",
                fontSize = 20.sp
            )

        }
    }
}


@Preview
@Composable
private fun Intentprev() {
    IntentScreen()
}