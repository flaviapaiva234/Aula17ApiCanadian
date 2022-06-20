package com.example.aula17apilistaretornadaremotamente.repository

import com.example.aula17apilistaretornadaremotamente.api.MealResponse
import com.example.aula17apilistaretornadaremotamente.api.MyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class MealRepository {

    //tem que passar uma Url da aquisição, dá um create e vai retornar um routesApi já como end poit juntado
    private var routesApi = MyApi("https://www.themealdb.com/").create()

    //agora só precisa cria a função, pegando os dados das refeições
    suspend fun getTheMeals( category: String ): Flow<MealResponse>{
        return flow {
            routesApi.getMeals(category).let { response ->
                if(response.isSuccessful){
                    response.body()
                } else {
                    throw HttpException(response)
                }
            }?.let {
                emit(it)
            }
        }
    }
}
//passa uma categoria