package org.sopt.do_sopt_compose.ui.pages.viewmodels

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.do_sopt_compose.ui.UiStatus
import org.sopt.do_sopt_compose.ui.pages.states.SignUpPageState
import org.sopt.do_sopt_compose.ui.pages.states.SignUpSideEffect

class SignUpViewModel : ContainerHost<SignUpPageState, SignUpSideEffect>, ViewModel() {

    override val container = container<SignUpPageState, SignUpSideEffect>(
        SignUpPageState(),
    )

    init {
        updateSignUpStatusIfValid()
    }

    fun updateSignUpStatusIfValid() {
        intent {
            reduce {
                state.copy(id = state.id, password = state.password, nickname = state.nickname)
            }
            if (state.id.isNotBlank() && state.password.isNotBlank() && state.nickname.isNotBlank()) {
                reduce { state.copy(status = UiStatus.Success) }
            } else {
                reduce { state.copy(status = UiStatus.Fail) }
            }
        }
    }
}
