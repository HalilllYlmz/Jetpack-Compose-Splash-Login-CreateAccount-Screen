package com.halil.sosyalkampus.navigation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.halil.jetpackcomposesplash_login_createaccountscreen.R
import com.halil.jetpackcomposesplash_login_createaccountscreen.components.ButtonComponents
import com.halil.jetpackcomposesplash_login_createaccountscreen.components.DropDownTextField
import com.halil.jetpackcomposesplash_login_createaccountscreen.components.TextFieldComponents
import com.halil.jetpackcomposesplash_login_createaccountscreen.ui.theme.LogoBlue
import com.halil.jetpackcomposesplash_login_createaccountscreen.ui.theme.LogoDarkBlue

@Composable
fun CreateAccountScreenFirst(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var className by remember { mutableStateOf("") }

    val classNameList = listOf(
        "Yazılım Mühendisliği 1.Sınıf",
        "Yazılım Mühendisliği 2.Sınıf",
        "Yazılım Mühendisliği 3.Sınıf",
        "Yazılım Mühendisliği 4.Sınıf",
        "Mezun"
    )

    var uri by remember {
        mutableStateOf<Uri?>(null)
    }

    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
        }
    )

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 12.dp),
                contentAlignment = Alignment.Center
            ) {

                if (uri == null) {
                    Image(
                        painter = painterResource(id = R.drawable.choose_image),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(150.dp)
                            .clickable {
                                singlePhotoPicker.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                        contentScale = ContentScale.Crop
                    )
                } else {
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(150.dp)
                            .clickable {
                                singlePhotoPicker.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            }
            TextFieldComponents(
                value = name,
                onValueChange = { name = it },
                label = "Ad",
                modifier = Modifier.padding(top = 20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.name,
                iconColor = Color.Unspecified
            )
            TextFieldComponents(
                value = surname,
                onValueChange = { surname = it },
                label = "Soyad",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.name,
                iconColor = Color.Unspecified
            )
            TextFieldComponents(
                value = email,
                onValueChange = { email = it },
                label = "E Posta",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                trailingIcon = "@ogr.cbu.edu.tr"
            )
            TextFieldComponents(
                value = phone,
                onValueChange = { phone = it },
                label = "Telefon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.phone2,
                iconColor = Color.Unspecified
            )
            TextFieldComponents(
                value = number,
                onValueChange = {
                    if (it.length <= 9) {
                        number = it
                    }
                },
                label = "Okul Numarası",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                painterResource = R.drawable.number,
                iconColor = Color.Unspecified
            )
            DropDownTextField(
                value = className,
                onValueChange = { className = it },
                label = "Sınıf",
                menuItems = classNameList,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            ButtonComponents(text = "Devam Et", onClick = { navController.navigate(SocialCampusScreens.CreateAccountScreenSecond.name) })
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountScreenSecond(navController: NavController) {

    var linkedin by remember { mutableStateOf("") }
    var github by remember { mutableStateOf("") }
    var ilgiAlanlari by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visibile)
    else
        painterResource(id = R.drawable.unvisible)



    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldComponents(
                value = linkedin,
                onValueChange = { linkedin = it },
                label = "Linkedin",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.linkedin,
                iconColor = Color(0xFF0077b7)
            )
            TextFieldComponents(
                value = github,
                onValueChange = { github = it },
                label = "GitHub",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.github,
                iconColor = Color.Black
            )
            TextFieldComponents(
                value = company,
                onValueChange = { company = it },
                label = "Şirket",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                painterResource = R.drawable.company,
                iconColor = Color.Unspecified
            )
            TextFieldComponents(
                value = ilgiAlanlari,
                onValueChange = { ilgiAlanlari = it },
                label = "İlgi Alanları",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.height(120.dp),
                singleLine = false,
                painterResource = R.drawable.software,
                iconColor = Color.Unspecified
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
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = icon,
                            contentDescription = "Visibility Icon"
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = LogoDarkBlue,
                    focusedBorderColor = LogoBlue,
                    focusedLabelColor = LogoDarkBlue
                ),
                singleLine = true
            )
            ButtonComponents(
                text = "Kayıt Ol",
                modifier = Modifier.padding(top = 45.dp)
            ) {

            }
        }
    }
}