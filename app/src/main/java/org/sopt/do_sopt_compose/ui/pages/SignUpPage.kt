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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.do_sopt_compose.R
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.components.MainButton
import org.sopt.do_sopt_compose.ui.components.PasswordTextField
import org.sopt.do_sopt_compose.ui.components.TextField
import org.sopt.do_sopt_compose.ui.components.TitleText
import org.sopt.do_sopt_compose.ui.pages.states.SignUpPageState
import org.sopt.do_sopt_compose.ui.pages.viewmodels.SignUpViewModel

@Composable
fun SignUpPage(
    state: SignUpPageState,
    onNavigateToLogin: () -> Unit,
    onNavigateToMain: () -> Unit,
) {
    val signUpViewModel: SignUpViewModel = viewModel()

    Scaffold(
        topBar =
        { TitleText(text = "SignUp") },
    ) {
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
                            signUpViewModel.updateSignUpStatusIfValid()
                            Log.d("LoginPage", "Entered ID: $it")
                            Log.d("LoginPage", "State ID: ${state.id}")
                        },
                    )
                    PasswordTextField(
                        hintText = stringResource(R.string.password_hint),
                        labelText = stringResource(R.string.password),
                        onValueChange = {
                            state.password = it
                            signUpViewModel.updateSignUpStatusIfValid()
                            Log.d("LoginPage", "Entered ID: $it")
                            Log.d("LoginPage", "State ID: ${state.password}")
                        },
                    )
                    TextField(
                        labelText = "Nickname",
                        hintText = "닉네임을 입력해주세요.",
                        modifier = Modifier.padding(vertical = 50.dp),
                        onValueChange = {
                            state.nickname = it
                            signUpViewModel.updateSignUpStatusIfValid()
                        },
                    )
                    MainButton(
                        onClick = {
                            signUpViewModel.updateSignUpStatusIfValid()

                            when (state.status) {
                                UiStatus.Success -> {
                                    onNavigateToMain()
                                }

                                else -> {
                                    Log.d("SignUpPage", "SignUp Fail")
                                }
                            }
                        },
                        text = stringResource(R.string.signup_kr),
                    )
                }
            }
        }
    }
}
