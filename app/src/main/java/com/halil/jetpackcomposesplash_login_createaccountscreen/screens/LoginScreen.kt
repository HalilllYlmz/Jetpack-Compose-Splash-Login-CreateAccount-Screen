package com.halil.jetpackcomposesplash_login_createaccountscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.halil.jetpackcomposesplash_login_createaccountscreen.R
import com.halil.jetpackcomposesplash_login_createaccountscreen.components.TextFieldComponents
import com.halil.jetpackcomposesplash_login_createaccountscreen.ui.theme.LogoLightGreen
import com.halil.sosyalkampus.navigation.SocialCampusScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    val icon = if(passwordVisibility)
        painterResource(id = R.drawable.visibile)
    else
        painterResource(id = R.drawable.unvisible)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .clip(CircleShape)
                .size(120.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 25.dp),
            text = "Sosyal Kampüs \n  Sistem Girişi",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        TextFieldComponents(
            value = email,
            onValueChange = { email = it },
            label = "E Posta",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            trailingIcon = "@ogr.cbu.edu.tr",
            icon = Icons.Default.Person
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 5.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Parola") },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(modifier = Modifier.size(25.dp), painter = icon, contentDescription = "Visibility Icon")
                }
            },
            visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = LogoLightGreen,
                focusedLabelColor = LogoLightGreen
            ),
            singleLine = true
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = LogoLightGreen
            )
        ) {
            Text(
                text = "Giriş Yap",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 4.dp)
        ) {
            Text(text = "Herhangi bir hesabın yok mu?")
            Text(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable {
                        navController.navigate(SocialCampusScreens.CreateAccountScreenFirst.name)
                    },
                text = "Hesap Oluştur"
            )
        }
    }


}