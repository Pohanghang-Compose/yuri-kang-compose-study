package org.sopt.do_sopt_compose.ui.pages.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageSideEffect
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageState
import org.sopt.do_sopt_compose.ui.pages.states.SignUpPageState

class LoginViewModel : ContainerHost<LoginPageState, LoginPageSideEffect>, ViewModel() {
    private val _signUpState = MutableStateFlow(SignUpPageState())

    override val container = container<LoginPageState, LoginPageSideEffect>(
        LoginPageState(),
    )

    init {
        updateLoginStatus()
    }

    fun updateLoginStatus() {
        intent {
            reduce {
                state.copy(id = state.id, password = state.password)
            }
            if ((state.id == _signUpState.value.id) && (state.password == _signUpState.value.password)) {
                reduce { state.copy(status = UiStatus.Success) }
            } else {
                reduce { state.copy(status = UiStatus.Fail) }
            }
        }
    }
}
