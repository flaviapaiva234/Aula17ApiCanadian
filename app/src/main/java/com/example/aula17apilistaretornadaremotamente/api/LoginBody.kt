package com.example.aula17apilistaretornadaremotamente.api
//    {
//         "login": "user_login",   String
//         "password": "password"  String
//    }

data class LoginBody(
    val login: String,
    val password: String,
)