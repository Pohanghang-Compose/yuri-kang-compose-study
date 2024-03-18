package org.sopt.do_sopt_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun FriendsProfileMusic(
    profileImageUrl: Int,
    nickname: String,
    music: String,
    statusMessage: String?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Row {
            Image(
                bitmap = ImageBitmap.imageResource(profileImageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Column {
                Text(
                    text = nickname,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    modifier = Modifier.padding(start = 8.dp)
                )

                Text(
                    text = statusMessage ?: "",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 8.dp),
                    maxLines = 1
                )
            }
            Text(
                text = music,
                modifier = Modifier.padding(start = 8.dp),
                color = Color.Blue
            )

        }
    }
}