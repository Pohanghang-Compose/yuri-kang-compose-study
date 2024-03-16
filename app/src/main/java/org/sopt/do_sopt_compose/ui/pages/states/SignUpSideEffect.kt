package org.sopt.do_sopt_compose.ui.pages.states

sealed class SignUpSideEffect {
    object ToastSuccessMessage : SignUpSideEffect()
    object ToastFailedMessage : SignUpSideEffect()
    object NavigateToLogin : SignUpSideEffect()
}
