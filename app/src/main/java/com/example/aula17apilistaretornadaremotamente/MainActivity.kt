package com.example.aula17apilistaretornadaremotamente

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aula17apilistaretornadaremotamente.databinding.ActivityMainBinding
import com.example.aula17apilistaretornadaremotamente.viewmodel.LoginViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        onClick()
        onObserve()
    }

    private fun onClick(){
        // coloquei o apply para poder chanmar outras coisas
        binding.apply {
            //peguei o que está escrito nos meus editTexts e vou usar como parametro
            btnLogin.setOnClickListener {
                viewModel.authenticate(
                    etName.text.toString(),
                    etPassword.text.toString()
                )
            }
        }
    }

    private fun onObserve(){
        viewModel.apply {
            // agora tem que observar os LiveDatas, para conseguir ver o retorno
            loginRight.observe(this@MainActivity, Observer {
                Toast.makeText(
                    this@MainActivity, " Hello ${it.userInfo.userName}",Toast.LENGTH_LONG
                ).show()
                //se der sucesso vai levar para minha MealActivity
                val intent = Intent(this@MainActivity, MealActivity::class.java)
                startActivity(intent)
            })
            // vai ficar observando se vai vir erro
            error.observe(this@MainActivity, Observer {
                Toast.makeText( this@MainActivity, it, Toast.LENGTH_LONG
                ).show()
            })
        }
    }
}