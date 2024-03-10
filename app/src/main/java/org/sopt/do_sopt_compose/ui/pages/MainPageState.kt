package org.sopt.do_sopt_compose.ui.pages

import org.sopt.do_sopt_compose.ui.UiStatus

data class MainPageState(
    val status: UiStatus? = UiStatus.Loading,

)
