package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.do_sopt_compose.R

@Composable
fun ProfileImage(
    image: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .wrapContentWidth().wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(
            modifier = Modifier.wrapContentWidth().wrapContentHeight(),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
private fun ProfileImage_Preview() {

}
