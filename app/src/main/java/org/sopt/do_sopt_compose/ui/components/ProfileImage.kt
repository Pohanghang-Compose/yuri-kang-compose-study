package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImage(
    image: String,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(
            modifier = modifier.height(100.dp),
        ) {
            Image(
                painter = painterResource(id = image.toInt()),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
private fun ProfileImage_Preview() {
    ProfileImage(
        image = "R.drawable.poster1",
        modifier = Modifier,
    )
}
