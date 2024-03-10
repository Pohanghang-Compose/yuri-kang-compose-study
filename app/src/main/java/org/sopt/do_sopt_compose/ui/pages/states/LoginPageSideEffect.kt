package org.sopt.do_sopt_compose.ui.pages.states

sealed class LoginPageSideEffect {
    object Completed : SignUpSideEffect()
}