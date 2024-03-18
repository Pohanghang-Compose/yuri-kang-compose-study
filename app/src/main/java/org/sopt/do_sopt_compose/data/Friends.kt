package org.sopt.do_sopt_compose.data

sealed class Friends {
    data class FriendsMe(
        val name: String,
        val profileImage: Int,
    ) : Friends()

    data class FriendsNomal(
        val name: String,
        val description: String?,
        val profileImage: Int,
    ) : Friends()

    data class FriendsMusic(
        val name: String,
        val description: String?,
        val profileImage: Int,
        val music: String
    ) : Friends()

    data class FriendsBirthday(
        val name: String,
        val description: String?,
        val profileImage: Int,
    ) : Friends()
}