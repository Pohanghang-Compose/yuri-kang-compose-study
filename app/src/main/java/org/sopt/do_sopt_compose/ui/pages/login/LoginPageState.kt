package org.sopt.do_sopt_compose.ui.pages.login

import org.sopt.do_sopt_compose.ui.UiStatus

data class LoginPageState(
    var status: UiStatus = UiStatus.Fail,
    var id: String = "",
    var password: String = "",
    var nickname: String = "",
    var isLoginEnabled: Boolean = false,
)
