package org.sopt.do_sopt_compose.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Button(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
) {
    Button(
        onClick = { onClick.invoke() },
        text = text,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun Button_Preview() {
    Button(
        onClick = {},
        text = "Button",
        modifier = Modifier,
    )
}
