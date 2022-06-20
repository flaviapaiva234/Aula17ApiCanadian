package com.example.aula17apilistaretornadaremotamente.api

import retrofit2.Response
import retrofit2.http.*


interface RoutesApi {

    //1. para a requisição acontecer em segundo plano, tem que declarar a função do tipo suspende
    //para diser que vai fazer uma requisição no metodo post, tem que usar o @ para diser que é uma anotação
    //tem que dar o sync nas bibliotecas do gradle, pq é retrofit
    @POST("/auth")//colocar o endpoint dentro das aspas
    //tem que enviar a senha do usuário e tem que ter jason
    suspend fun doAuthentication(
        //primeiro tem que fazer o corpo da requisição
        @Body body: LoginBody // está na activity LoginBody
    ):Response<LoginResponse> //Esse response é responsavel por filtar a API

    //nesse caso vai ser um Get pq ele está mandando uma variável específica, ele não está mandando o corpo da requisição, ele está mandando o cabeçalho
    @GET("/api/json/v1/1/filter.php")


    //declara a função
    suspend fun getMeals(
        // para fazer com que apareça a variável, no lugar doBody (pq não é mais um corpo) vai usar um Querry
        @Query("a") category: String  // query é algo que a gente passa como um filtro para poder retornar algo, e tem que vir umretorno de acordo com essa variável
    ): Response<MealResponse>
}