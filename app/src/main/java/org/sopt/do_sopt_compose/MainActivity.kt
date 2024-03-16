package org.sopt.do_sopt_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.do_sopt_compose.ui.pages.LoginPage
import org.sopt.do_sopt_compose.ui.pages.states.LoginPageState
import org.sopt.do_sopt_compose.ui.pages.MainPage
import org.sopt.do_sopt_compose.ui.pages.SignUpPage
import org.sopt.do_sopt_compose.ui.pages.states.MainPageState
import org.sopt.do_sopt_compose.ui.pages.states.SignUpPageState
import org.sopt.do_sopt_compose.ui.theme.Do_sopt_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Do_sopt_composeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()
                        NavHost(navController, startDestination = Screen.Login.route) {
                            addLogin(navController = navController)
                            addSignUp(navController = navController)
                            addMain(navController = navController)
                        }
                    }
                }
            }
        }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Do_sopt_composeTheme {
        Greeting("Android")
    }
}
