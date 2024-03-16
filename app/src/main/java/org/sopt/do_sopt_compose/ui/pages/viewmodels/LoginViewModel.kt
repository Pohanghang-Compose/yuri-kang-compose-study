package org.sopt.do_sopt_compose.ui.pages.viewmodels

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageSideEffect
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageState

class LoginViewModel : ContainerHost<LoginPageState, LoginPageSideEffect>, ViewModel() {

    override val container = container<LoginPageState, LoginPageSideEffect>(
        LoginPageState(),
    )

    fun updateLoginId(id: String) {
        intent {
            reduce {
                state.copy(id = id)
            }
        }
    }

    fun updateLoginNickname(nickname: String) {
        intent {
            reduce {
                state.copy(nickname = nickname)
            }
        }
    }

    fun updateLoginPassword(password: String) {
        intent {
            reduce {
                state.copy(password = password)
            }
        }
    }

    fun chcekValidLogin() {
        intent {
            if (state.id.isNotEmpty() && state.password.isNotEmpty()) {
                reduce {
                    state.copy(isLoginEnabled = true)
                }
            }
        }
    }

    fun loginFailedClicked() {
        intent {
            postSideEffect(LoginPageSideEffect.NavigateToSignUp)
            postSideEffect(LoginPageSideEffect.ToastFailedMessage)
        }
    }

    fun loginSuccessClicked() {
        intent {
            postSideEffect(LoginPageSideEffect.NavigateToMain)
            postSideEffect(LoginPageSideEffect.ToastSuccessMessage)
        }
    }
}
