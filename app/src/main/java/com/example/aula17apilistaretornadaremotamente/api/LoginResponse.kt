package com.example.aula17apilistaretornadaremotamente.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("user_info")
    val userInfo: UserInfo,

    @SerializedName("user_credentials")
    val userCredentials: UserCredentials,

    @SerializedName("has_notifications")
    val hasNotifications: Boolean
)



data class UserInfo(
    @SerializedName("user_name")
    val userName: String,

    @SerializedName("account_code")
    val accountCode: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("use_coins")
    val useCoins: Int,

    @SerializedName("photo")
    val photo: String
)

data class UserCredentials(

    @SerializedName("login")
    val login:String,

    @SerializedName("password")
    val password:String
)


