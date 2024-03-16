package org.sopt.do_sopt_compose.ui.pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import org.sopt.do_sopt_compose.R
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.components.MainButton
import org.sopt.do_sopt_compose.ui.components.PasswordTextField
import org.sopt.do_sopt_compose.ui.components.TextField
import org.sopt.do_sopt_compose.ui.components.TitleText
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageSideEffect
import org.sopt.do_sopt_compose.ui.pages.viewmodels.LoginViewModel

@Composable
fun LoginPage(
    navController: NavController,
) {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.collectAsState()
    val context = LocalContext.current

    // sideEffect
    // Composable 함수 안에서 코루틴 suspend 실행, 코루틴 코드를 통해 state 값에 영향을 줌
    // 코루틴 Launch 시점 : Compsable composition, state 값의 변화에 따른 recomposition, LaunchedEffect key 값의 변화에 따른 recomposition
    LaunchedEffect(key1 = true) {
        navController.previousBackStackEntry?.savedStateHandle?.run {
            val id = get<String>("id") ?: ""
            val password = get<String>("password") ?: ""
            val nickname = get<String>("nickname") ?: ""

            viewModel.updateLoginId(id = id)
            viewModel.updateLoginPassword(password = password)
            viewModel.updateLoginNickname(nickname = nickname)
            viewModel.chcekValidLogin()
        }
    }

    Scaffold(
        topBar = { TitleText(text = "login") },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                TextField(
                    labelText = stringResource(R.string.id),
                    hintText = stringResource(R.string.id_hint),
                    modifier = Modifier.padding(vertical = 50.dp),
                    onValueChange = {
                        viewModel.updateLoginId(id = it)
                        viewModel.chcekValidLogin()
                    },
                )
                PasswordTextField(
                    hintText = stringResource(R.string.password_hint),
                    labelText = stringResource(R.string.password),
                    modifier = Modifier.padding(bottom = 50.dp),
                    onValueChange = {
                        viewModel.updateLoginPassword(password = it)
                        viewModel.chcekValidLogin()
                    },
                )

                MainButton(
                    onClick = {
                        when (state.isLoginEnabled) {
                            true -> {
                                viewModel.loginSuccessClicked()
                            }
                            else -> {
                                viewModel.loginFailedClicked()
                            }
                        }
                    },
                    text = "로그인",
                )
            }
        }
    }

    viewModel.collectSideEffect {
        when (it) {
            LoginPageSideEffect.NavigateToSignUp -> {
                navController.navigate("signup")
            }

            LoginPageSideEffect.ToastFailedMessage -> {
                Toast.makeText(
                    context,
                    context.getString(R.string.failed_login),
                    Toast.LENGTH_SHORT,
                ).show()
            }

            LoginPageSideEffect.ToastSuccessMessage -> {
                Toast.makeText(
                    context,
                    context.getString(R.string.success_login),
                    Toast.LENGTH_SHORT,
                ).show()
            }

            LoginPageSideEffect.NavigateToMain -> {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "id",
                    value = state.id,
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "nickname",
                    value = state.nickname,
                )
                Log.d("LoginPage", "id: ${state.id}, nickname: ${state.nickname}")
                navController.navigate("main")
            }

            else -> {}
        }
    }
}

@Preview
@Composable
private fun LoginPage_Preview() {
    LoginPage(
        navController = NavController(LocalContext.current),
    )
}
