package org.sopt.do_sopt_compose.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.do_sopt_compose.R
import org.sopt.do_sopt_compose.ui.components.ProfileImage
import org.sopt.do_sopt_compose.ui.components.TitleText
import org.sopt.do_sopt_compose.ui.pages.states.MainPageState
import org.sopt.do_sopt_compose.ui.pages.viewmodels.MainViewModel

@Composable
fun MainPage(
    state: MainPageState = MainPageState(),
) {
    val mainViewModel: MainViewModel = viewModel()
    mainViewModel.updateMainStatus()

    Scaffold(
        topBar = { TitleText(text = "홈 화면") },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                Column(modifier = Modifier.fillMaxSize().align(Alignment.Center)) {
                    Row(
                        modifier = Modifier.padding(vertical = 50.dp, horizontal = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ProfileImage(
                            image = R.drawable.profile_image,
                            modifier = Modifier.padding(start = 20.dp, end = 10.dp),
                        )
                        Text(
                            text = state.nickname,
                            modifier = Modifier.padding(horizontal = 20.dp),
                            style = MaterialTheme.typography.displaySmall,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "아노란어하ㅓㄴㅌㄹ쟈도항ㄴㄹsssssss",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    Text(
                        text = "ID",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                    )
                    Text(
                        text = state.id,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(horizontal = 20.dp),
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun MainPage_Preview() {
    MainPage()
}
