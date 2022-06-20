package com.example.aula17apilistaretornadaremotamente.repository

import com.example.aula17apilistaretornadaremotamente.api.LoginBody
import com.example.aula17apilistaretornadaremotamente.api.LoginResponse
import com.example.aula17apilistaretornadaremotamente.api.MyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class LoginRepository {

    private var loginRoute = MyApi("https://api-desafios-usemobile.herokuapp.com").create()


    suspend fun doTheAuthentication( // sunpend pq vai fazer tudo em segundo plano usando o coroutines
        login: String, // nome de usuário
        password:String // senha
    ): Flow<LoginResponse>{  // o flow retorna a corrente de dados
        return flow {
            //Faz a requisição passando o corpo da requisição
            loginRoute.doAuthentication( LoginBody(login, password)
            ).let { response ->
                //O Response é retornado e validado
                if (response.isSuccessful){
                    //esse response esta lá na activity RoutesApi na linha 17, esse response é o proprio Json e quando chama o body ele vem o <LoginResponse> também da linha 17
                    response.body()
                } else {
                    throw HttpException(response) // essa é uma exeção específica, como parametro coloca o response
                }
            }?.let {
                //Response é enviado
                emit(it)
            }
        }
    }


}