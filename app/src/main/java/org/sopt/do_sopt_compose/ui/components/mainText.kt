package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(vertical = 3.dp, horizontal = 15.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview
@Composable
private fun MainText_Preview() {
    MainText("LogIn")
}