package org.sopt.do_sopt_compose.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.components.MainButton
import org.sopt.do_sopt_compose.ui.components.PasswordTextField
import org.sopt.do_sopt_compose.ui.components.TextField
import org.sopt.do_sopt_compose.ui.components.TitleText

@Composable
fun SignUpPage(
    state: SignUpPageState,
    onNavigateToLogin: () -> Unit,
) {
    Scaffold(
        topBar =
        { TitleText(text = "SignUp") },
        content =
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        TextField(
                            labelText = "ID",
                            hintText = "아이디를 입력해주세요.",
                            modifier = Modifier.padding(vertical = 50.dp),
                        )
                        PasswordTextField(
                            hintText = "비밀번호를 입력해주세요.",
                            labelText = "Password",
                        )
                        TextField(
                            labelText = "Nickname",
                            hintText = "닉네임을 입력해주세요.",
                            modifier = Modifier.padding(vertical = 50.dp),
                        )
                        MainButton(
                            onClick = if (state.status == UiStatus.Success) {
                                onNavigateToLogin
                            } else {
                                { }
                            },
                            text = "회원가입",
                        )
                    }
                }
            }
        },
    )
}

@Preview
@Composable
private fun SignUpPage_Preview() {
    SignUpPage(
        state = SignUpPageState(),
        onNavigateToLogin = {},
    )
}