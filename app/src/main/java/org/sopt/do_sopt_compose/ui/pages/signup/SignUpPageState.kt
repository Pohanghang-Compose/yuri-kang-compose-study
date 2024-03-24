package org.sopt.do_sopt_compose.ui.pages.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.sopt.do_sopt_compose.ui.UiStatus

data class SignUpPageState(
    var status: UiStatus? = UiStatus.Success,
    var id: String = "",
    var password: String = "",
    var nickname: String = "",
    var isSignUpEnabled: Boolean = false,
)
