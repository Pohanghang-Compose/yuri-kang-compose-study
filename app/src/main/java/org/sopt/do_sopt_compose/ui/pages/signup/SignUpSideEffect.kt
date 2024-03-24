package org.sopt.do_sopt_compose.ui.pages.signup

sealed class SignUpSideEffect {
    object ToastSuccessMessage : SignUpSideEffect()
    object ToastFailedMessage : SignUpSideEffect()
    object NavigateToLogin : SignUpSideEffect()
}
