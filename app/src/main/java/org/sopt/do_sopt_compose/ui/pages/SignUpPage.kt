package org.sopt.do_sopt_compose.ui.pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import org.sopt.do_sopt_compose.R
import org.sopt.do_sopt_compose.Screen
import org.sopt.do_sopt_compose.ui.components.MainButton
import org.sopt.do_sopt_compose.ui.components.PasswordTextField
import org.sopt.do_sopt_compose.ui.components.TextField
import org.sopt.do_sopt_compose.ui.components.TitleText
import org.sopt.do_sopt_compose.ui.pages.states.SignUpSideEffect
import org.sopt.do_sopt_compose.ui.pages.viewmodels.SignUpViewModel

@Composable
fun SignUpPage(
    navController: NavController,
) {
    val viewModel: SignUpViewModel = viewModel()
    val state by viewModel.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = { TitleText(text = "SignUp") },
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
                        state.id = it
                        viewModel.updateSignUpStatusIfValid()
                        Log.d("LoginPage", "Entered ID: $it")
                        Log.d("LoginPage", "State ID: ${state.id}")
                    },
                )
                PasswordTextField(
                    hintText = stringResource(R.string.password_hint),
                    labelText = stringResource(R.string.password),
                    onValueChange = {
                        state.password = it
                        viewModel.updateSignUpStatusIfValid()
                    },
                )
                TextField(
                    labelText = stringResource(R.string.nickname),
                    hintText = stringResource(R.string.nickname_hint),
                    modifier = Modifier.padding(vertical = 50.dp),
                    onValueChange = {
                        state.nickname = it
                        viewModel.updateSignUpStatusIfValid()
                    },
                )
                MainButton(
                    onClick = {
                        viewModel.updateSignUpStatusIfValid()

                        when (state.isSignUpEnabled) {
                            true -> {
                                viewModel.signUpBtnSuccessClicked()
                                navController.popBackStack()
                            }

                            else -> {
                                viewModel.signUpBtnFailedClicked()
                            }
                        }
                    },
                    text = stringResource(R.string.signup_kr),
                )
            }
        }
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            SignUpSideEffect.NavigateToLogin -> {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "id",
                    value = state.id,
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "nickname",
                    value = state.nickname,
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "password",
                    value = state.password,
                )
                navController.navigate(Screen.Login.route)
                navController.popBackStack()
            }

            SignUpSideEffect.ToastSuccessMessage -> {
                Toast.makeText(
                    context,
                    context.getString(R.string.success_signup),
                    Toast.LENGTH_SHORT,
                ).show()
            }

            SignUpSideEffect.ToastFailedMessage -> {
                Toast.makeText(
                    context,
                    context.getString(R.string.failed_signup),
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}
