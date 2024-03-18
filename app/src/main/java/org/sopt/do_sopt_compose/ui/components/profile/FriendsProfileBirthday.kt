package org.sopt.do_sopt_compose.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.sopt.do_sopt_compose.ui.components.Birthday


@Composable
fun FriendsProfileBirthday(
    profileImageUrl: Int,
    nickname: String,
    statusMessage: String?
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
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
                    modifier = Modifier.padding(start = 8.dp),
                )

                Text(
                    text = statusMessage ?: "",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )

                Birthday()
            }
        }
    }
}