package org.sopt.do_sopt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.do_sopt_compose.ui.pages.LoginPage
import org.sopt.do_sopt_compose.ui.pages.MainPage
import org.sopt.do_sopt_compose.ui.pages.SignUpPage

@Composable
fun AuthNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Login.route) {
        addLogin(navController = navController)
        addSignUp(navController = navController)
        addMain(navController = navController)
    }
}

private fun NavGraphBuilder.addLogin(navController: NavController) {
    composable(route = Screen.Login.route) {
        // 버튼 클릭 시 화면 이동
        LoginPage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addSignUp(navController: NavController) {
    composable(route = Screen.SignUp.route) {
        SignUpPage(
            navController = navController,
        )
    }
}

private fun NavGraphBuilder.addMain(navController: NavController) {
    composable(route = Screen.Main.route) {
        MainPage(
            navController = navController,
        )
    }
}
