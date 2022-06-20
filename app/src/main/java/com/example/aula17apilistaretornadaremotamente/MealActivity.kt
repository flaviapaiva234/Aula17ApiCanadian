package com.example.aula17apilistaretornadaremotamente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.aula17apilistaretornadaremotamente.databinding.ActivityMealBinding
import com.example.aula17apilistaretornadaremotamente.viewmodel.MealViewModel


class MealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealBinding
    private lateinit var viewModel: MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)
        viewModel.getMeals("Canadian")

        onObserve()
    }

    private fun onObserve(){
        viewModel.apply {
            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.tvMealName0.text = mealResponse.meals[2].mealName
                binding.ivMealImage1.load(mealResponse.meals[2].mealImage)
            })
            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.tvMealName2.text = mealResponse.meals[4].mealName
                binding.ivMealImage2.load(mealResponse.meals[4].mealImage)
            })

            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.tvMealName3.text = mealResponse.meals[8].mealName
                binding.ivMealImage3.load(mealResponse.meals[8].mealImage)
            })

            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.tvMealName4.text = mealResponse.meals[10].mealName
                binding.ivMealImage4.load(mealResponse.meals[10].mealImage)
            })

            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.tvMealName5.text = mealResponse.meals[12].mealName
                binding.ivMealImage5.load(mealResponse.meals[12].mealImage)
            })
        }
    }
}