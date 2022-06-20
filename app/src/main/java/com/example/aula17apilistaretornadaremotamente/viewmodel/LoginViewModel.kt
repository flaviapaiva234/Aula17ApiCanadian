package com.example.aula17apilistaretornadaremotamente.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aula17apilistaretornadaremotamente.api.LoginResponse
import com.example.aula17apilistaretornadaremotamente.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// tem que extender a ViewModel(e importa-la) para pega-la mais abaixo na linha 33
class LoginViewModel: ViewModel() {
    //essa parte não utiliza do retrofit, mas utiliza da MVVM
    val repository: LoginRepository = LoginRepository()

    //vai ter dois LiveData
    //se der sucesso ele vai retornar a estrutura de Json que foi montada na forma de classe
    private val _loginRight: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginRight: LiveData<LoginResponse> = _loginRight // esse não pode ser privado pq vai ter que acessar na activity

    // e se ser erro vai voltar uma string com uma menssagem de erro
    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    // tem que fazer a função do repositório que por sua vez vai fazer a chamada na API
    fun authenticate(login: String, password: String) {

        // tem que declara o coroutine pq tudo aquilo lá vai ser feito em segundo plano
        // chama a Coroutine com a viewModelScope // o contexto em backgrownd  tem que declarar alguma coisa em segundo plano como o Dispatchers.IO, tem que respeitar a entrada e saida de dados
        viewModelScope.launch(Dispatchers.IO) {
            repository.doTheAuthentication(login, password  // fazer a chamada da função dentro do repositório

                //coma função .catch, consigo pegar a excessão que está na activity LoginRepository na linha:28 que é a minha throw
            ).catch { exception -> // captua a exception
                _error.postValue(exception.message) // se der erro essa exception vai carregar uma menssagem de erro// colocando esse LiveData e lá,
            }.collect { loginResponse -> // se não der erro, então os dados serão colhidos
                //esse login response vai atribuir a Live Data _loginSuccess
                _loginRight.postValue(loginResponse)
            }
        }
    }
}