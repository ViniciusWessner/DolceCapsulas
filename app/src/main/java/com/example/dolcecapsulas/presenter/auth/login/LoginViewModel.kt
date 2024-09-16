package com.example.dolcecapsulas.presenter.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dolcecapsulas.domain.auth.LoginUseCase
import com.example.dolcecapsulas.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun login(email: String, senha: String) = liveData(Dispatchers.IO) {
        try {

            emit(StateView.Loading())

            loginUseCase.invoke(email, senha)

            emit(StateView.Sucess(null))

        }catch (ex: Exception){
            emit(StateView.Error(ex.message))
        }
    }

}