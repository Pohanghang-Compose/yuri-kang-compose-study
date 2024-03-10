package org.sopt.do_sopt_compose.ui

sealed class UiStatus {
    object Loading : UiStatus()
    object Success : UiStatus()
    object Fail : UiStatus()

}