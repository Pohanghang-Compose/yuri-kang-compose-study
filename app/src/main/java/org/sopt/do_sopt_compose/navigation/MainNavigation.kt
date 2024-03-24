package org.sopt.do_sopt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.do_sopt_compose.ui.pages.doandroid.DoAndroid
import org.sopt.do_sopt_compose.ui.pages.home.HomePage
import org.sopt.do_sopt_compose.ui.pages.login.LoginPage
import org.sopt.do_sopt_compose.ui.pages.mypage.MainPage
import org.sopt.do_sopt_compose.ui.pages.signup.SignUpPage

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = AuthScreenItems.Login.route) {
        addLogin(navController = navController)
        addSignUp(navController = navController)
        addMain(navController = navController)
        addDo(navController = navController)
        addHome(navController = navController)
        addMyPage(navController = navController)
    }
}

private fun NavGraphBuilder.addLogin(navController: NavController) {
    composable(route = AuthScreenItems.Login.route) {
        LoginPage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addSignUp(navController: NavController) {
    composable(route = AuthScreenItems.SignUp.route) {
        SignUpPage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addMain(navController: NavController) {
    composable(route = AuthScreenItems.Main.route) {
        MainPage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addDo(navController: NavController) {
    composable(route = BottomNaviItems.Do.route) {
        DoAndroid(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addHome(navController: NavController) {
    composable(route = BottomNaviItems.Home.route) {
        HomePage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addMyPage(navController: NavController) {
    composable(route = BottomNaviItems.MyPage.route) {
        MainPage(
            navController = navController,
        )
    }
}