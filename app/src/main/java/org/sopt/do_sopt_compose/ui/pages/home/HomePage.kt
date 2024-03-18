package org.sopt.do_sopt_compose.ui.pages.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.sopt.do_sopt_compose.data.DummyFriendData
import org.sopt.do_sopt_compose.data.Friends
import org.sopt.do_sopt_compose.navigation.BottomNavigation
import org.sopt.do_sopt_compose.ui.components.FriendsProfileBirthday
import org.sopt.do_sopt_compose.ui.components.FriendsProfileMe
import org.sopt.do_sopt_compose.ui.components.FriendsProfileMusic
import org.sopt.do_sopt_compose.ui.components.FriendsProfileNormal
import org.sopt.do_sopt_compose.ui.components.MainText

@Composable
fun HomePage(
    navController: NavController,
) {

    val friendsList = remember { DummyFriendData.dummyFriendList }
    Scaffold(
        topBar = { MainText(text = "Home", modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) },
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                items(friendsList.size) {
                    friendsList.forEach { friend ->
                        when (friend) {
                            is Friends.FriendsMe -> {
                                FriendsProfileMe(
                                    profileImageUrl = friend.profileImage,
                                    nickname = friend.name,
                                )
                            }

                            is Friends.FriendsNomal -> {
                                FriendsProfileNormal(
                                    profileImageUrl = friend.profileImage,
                                    nickname = friend.name,
                                    statusMessage = friend.description,
                                )
                            }

                            is Friends.FriendsBirthday -> {
                                FriendsProfileBirthday(
                                    profileImageUrl = friend.profileImage,
                                    nickname = friend.name,
                                    statusMessage = friend.description,
                                )
                            }

                            is Friends.FriendsMusic -> {
                                FriendsProfileMusic(
                                    profileImageUrl = friend.profileImage,
                                    nickname = friend.name,
                                    statusMessage = friend.description,
                                    music = friend.music,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
