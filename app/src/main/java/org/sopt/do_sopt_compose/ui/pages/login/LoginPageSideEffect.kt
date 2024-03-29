package org.sopt.do_sopt_compose.ui.pages.login

sealed class LoginPageSideEffect {
    object ToastFailedMessage : LoginPageSideEffect()
    object ToastSuccessMessage : LoginPageSideEffect()
    object NavigateToSignUp : LoginPageSideEffect()
    object NavigateToMain : LoginPageSideEffect()
}