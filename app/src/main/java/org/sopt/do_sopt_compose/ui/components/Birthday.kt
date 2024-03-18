package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import org.sopt.do_sopt_compose.R

@Composable
fun Birthday(
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(0.dp, 12.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        border = BorderStroke(1.dp, Color.Red)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_cake_24),
                contentDescription = null,
                alignment = Alignment.Center
            )
            Text(
                text = "생일인 친구",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
private fun MelonMusic_Preview() {
    MelonMusic("sssssssssss")
}