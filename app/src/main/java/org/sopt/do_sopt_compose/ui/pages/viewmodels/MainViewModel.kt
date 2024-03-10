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
import org.sopt.do_sopt_compose.ui.pages.states.MainPageState
import org.sopt.do_sopt_compose.ui.pages.states.MainSideEffect
import org.sopt.do_sopt_compose.ui.pages.states.SignUpPageState

class MainViewModel : ContainerHost<MainPageState, MainSideEffect>, ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpPageState())
    override val container = container<MainPageState, MainSideEffect>(
        MainPageState(),
    )

    init {
        updateMainStatus()
    }

    fun updateMainStatus() {
        intent {
            reduce {
                state.copy(id = _signUpState.value.id, nickname = _signUpState.value.nickname)
            }
        }
    }
}
