package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextField(
    value: (String) -> Unit,
    labelText: String,
) {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        label = { Text(text = labelText) },
        onValueChange = {
            password = it
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}

@Preview
@Composable
private fun preview_EditText() {
    PasswordTextField(
        value = {},
        labelText = "Password",
    )
}
