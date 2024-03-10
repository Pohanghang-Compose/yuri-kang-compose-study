package org.sopt.do_sopt_compose.ui.pages.states

import org.sopt.do_sopt_compose.ui.UiStatus

data class LoginPageState(
    var status: UiStatus? = UiStatus.Fail,
    var id: String = "",
    var password: String = "",
)
