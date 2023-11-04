package com.halil.jetpackcomposesplash_login_createaccountscreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.halil.jetpackcomposesplash_login_createaccountscreen.ui.theme.LogoLightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponents(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector? = null,
    keyboardOptions: KeyboardOptions,
    singleLine: Boolean = true,
    trailingIcon: String? = null,
    painterResource: Int? = null,
    iconColor: Color? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 5.dp),
        label = {
            Text(
                text = label
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = LogoLightGreen,
            focusedLabelColor = LogoLightGreen
        ),
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        trailingIcon = {
            if (trailingIcon != null) {
                Text(
                    text = trailingIcon,
                    modifier = Modifier.padding(end = 7.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            if (painterResource != null && iconColor != null) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = painterResource),
                    contentDescription = "",
                    tint = iconColor
                )
            }
        },
    )
}

@Composable
fun ButtonComponents(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 12.dp)
        ,
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = LogoLightGreen
        )
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    menuItems: List<String>,
    keyboardOptions: KeyboardOptions,
) {

    var isExpand by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        expanded = isExpand,
        onExpandedChange = { isExpand = it }
    ) {

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpand)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = LogoLightGreen
            ),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            label = { Text(text = label) }
        )

        ExposedDropdownMenu(
            expanded = isExpand,
            onDismissRequest = { isExpand = false },
        ) {
            menuItems.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onValueChange(item)
                        isExpand = false
                    }
                )
            }
        }
    }
}