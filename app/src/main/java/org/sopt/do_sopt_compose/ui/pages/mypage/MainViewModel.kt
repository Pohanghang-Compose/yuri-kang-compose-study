package org.sopt.do_sopt_compose.ui.pages.mypage

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : ContainerHost<MainPageState, MainSideEffect>, ViewModel() {

    override val container = container<MainPageState, MainSideEffect>(
        MainPageState(),
    )

    fun updateMainState(
        id: String,
        nickname: String,
    ) {
        intent {
            reduce {
                state.copy(id = id, nickname = nickname)
            }
        }
    }
}
