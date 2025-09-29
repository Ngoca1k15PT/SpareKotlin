package com.hn.sprase.presentation.screen.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hn.sprase.R
import androidx.core.graphics.toColorInt

@Composable
fun LoginScreen(){
    var name by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var visiblePassword by remember {
        mutableStateOf(false)
    }

    var checked by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
        ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Welcome ,",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
            )
        Text("Hope you are doing great?",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFA2A2A2)
        )

        Spacer(Modifier.height(150.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {Text("name")},
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFFA2A2A2)) },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth(),
            colors =  OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF407AFF),
            unfocusedBorderColor = Color(0xFF407AFF),
            cursorColor = Color(0xFF407AFF)
        )
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {Text("Password")},
            leadingIcon = {Icon(Icons.Default.Lock, contentDescription = null, tint = Color(0xFFA2A2A2))},
            trailingIcon = {
                val image = painterResource(if(visiblePassword){
                    R.drawable.outline_visibility
                } else {
                    R.drawable.outline_visibility_off
                })
                IconButton(onClick = {visiblePassword = !visiblePassword}) {
                    Icon(image, contentDescription = if(visiblePassword) "Hide Password" else "Show Password", tint = Color(0xFFA2A2A2))
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            visualTransformation = if(visiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardActions = KeyboardActions {KeyboardType.Password },
            modifier = Modifier.fillMaxWidth(),
            colors =  OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF407AFF),
                unfocusedBorderColor = Color(0xFF407AFF),
                cursorColor = Color(0xFF407AFF)
            )
        )

        Spacer(Modifier.height(1.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF407AFF),
                        uncheckedColor = Color(0xFFCCCCCC),
                        checkmarkColor = Color.White
                    )
                )
                Text("Remember me", fontWeight = FontWeight.Medium, color = Color(0xFFA2A2A2), fontSize = 14.sp)
            }
            Text("Forget your password?", modifier = Modifier.clickable(onClick = {}), color = Color(0xFF407AFF), fontWeight = FontWeight.Medium, fontSize = 14.sp)
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color("#407AFF".toColorInt())
            ),
            modifier = Modifier.fillMaxWidth()
                .height(46.dp)
            ) {
            Text("Sign In")
        }

        Spacer(Modifier.height(15.dp))

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .height(46.dp),
            border = BorderStroke(1.dp, Color(0xFFA2A2A2)),
        ) {
            Text("Sign Up", color = Color("#407AFF".toColorInt()))
        }


    }
}