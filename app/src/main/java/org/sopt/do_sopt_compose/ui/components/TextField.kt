package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
    onValueChange: (String) -> Unit,
    labelText: String,
    hintText: String,
    modifier: Modifier = Modifier,
) {
    var data by rememberSaveable { mutableStateOf("") }

    TextField(
        value = data,
        placeholder = { Text(text = hintText) },
        label = { Text(text = labelText) },
        onValueChange = {
            data = it
            onValueChange(it)
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
    )
}

@Preview
@Composable
private fun preview_EditText() {
}
