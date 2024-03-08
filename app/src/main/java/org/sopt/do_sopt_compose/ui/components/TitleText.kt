package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview
@Composable
private fun Message_Preview() {
    TitleText("LogIn")
}
