package org.sopt.do_sopt_compose.navigation

import org.sopt.do_sopt_compose.R

sealed class BottomNaviItems(
    val title: Int,
    val icon: Int,
    val route: String,
) {
    object Do : BottomNaviItems(R.string.bottom_navi_ando, R.drawable.ic_android_24dp, "Do")
    object Home : BottomNaviItems(R.string.bottom_navi_home, R.drawable.ic_home_24, "Home")
    object MyPage : BottomNaviItems(R.string.bottom_navi_mypage, R.drawable.ic_person_24, "MyPage")
}
