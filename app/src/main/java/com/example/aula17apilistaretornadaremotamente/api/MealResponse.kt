package com.example.aula17apilistaretornadaremotamente.api

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals") // vai ser uma lista, tem que declara um objeto
    val meals: List<Meal> // tendo o response, tem que ir até a activity RoutsApi e criar mais uma end poit, e nesse caso vai ser um Get pq ele está mandando uma variável específica, ele não está mandando o corpo da requisição, ele está mandando o cabeçalho
)
//tem que declarar o objeto da lista que nesse caso é o meals
data class Meal(

    @SerializedName("strMeal")
    val mealName: String,

    @SerializedName("strMealThumb")
    val mealImage: String,

    @SerializedName("idMeal")
    val idMeal: Int
)

//{
//    "meals": [
//    {
//        "strMeal": "BeaverTails",
//        "strMealThumb": "https:\/\/www.themealdb.com\/images\/media\/meals\/ryppsv1511815505.jpg",
//        "idMeal": "52928"
//    }