package com.example.aula17apilistaretornadaremotamente.api

import okhttp3.OkHttpClient
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApi(private val baseUrl: String) {
    // retornar a biblioteca Retrifit
    fun create():RoutesApi{
        return Retrofit
            .Builder() // O construtor,Avisa que algo vai ser construído
            .baseUrl(baseUrl) // Atribuião da base url
            .addConverterFactory(GsonConverterFactory.create()) // Criação do conversor de JSON para classe kotlin
            .client(OkHttpClient.Builder().build()) // Atribuição do agente que irá efetuar a requisição em si
            .build()// termino de construr, passo o build
            .create(RoutesApi::class.java)// crio a minha URL com a end point //  é a junção da URL com o endpoint
    }
}