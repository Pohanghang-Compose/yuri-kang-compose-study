package org.sopt.do_sopt_compose.ui.pages

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.do_sopt_compose.R
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.components.MainButton
import org.sopt.do_sopt_compose.ui.components.PasswordTextField
import org.sopt.do_sopt_compose.ui.components.TextField
import org.sopt.do_sopt_compose.ui.components.TitleText
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageState
import org.sopt.do_sopt_compose.ui.pages.viewmodels.LoginViewModel

@Composable
fun LoginPage(
    state: LoginPageState,
    onNavigateToSignUp: () -> Unit,
    onNavigateToMainUp: () -> Unit,
) {
    val loginViewModel: LoginViewModel = viewModel()

    Scaffold(
        topBar = { TitleText(text = "login") },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        TextField(
                            labelText = stringResource(R.string.id),
                            hintText = stringResource(R.string.id_hint),
                            modifier = Modifier.padding(vertical = 50.dp),
                            onValueChange = {
                                state.id = it
                                loginViewModel.updateLoginStatus()
                                Log.d("LoginPage", "Entered ID: $it")
                                Log.d("LoginPage", "State ID: ${state.id}")
                            },
                        )
                        PasswordTextField(
                            hintText = stringResource(R.string.password_hint),
                            labelText = stringResource(R.string.password),
                            modifier = Modifier.padding(bottom = 50.dp),
                            onValueChange = {
                                state.password = it
                                loginViewModel.updateLoginStatus()
                                Log.d("LoginPage", "Entered ID: $it")
                                Log.d("LoginPage", "State ID: ${state.password}")
                            },
                        )

                        MainButton(
                            onClick = {
                                loginViewModel.updateLoginStatus()
                                Log.d("LoginPage", "State: ${state.status}")

                                when (state.status) {
                                    UiStatus.Success -> {
                                        onNavigateToMainUp()
                                    }

                                    UiStatus.Fail -> {
                                        onNavigateToSignUp()
                                    }

                                    else -> {
                                        // do nothing
                                    }
                                }
                            },
                            text = "로그인",
                        )
                    }
                }
            }
        },
    )
}

@Preview
@Composable
private fun LoginPage_Preview() {
    LoginPage(
        state = LoginPageState(),
        onNavigateToSignUp = {},
        onNavigateToMainUp = {},
    )
}
