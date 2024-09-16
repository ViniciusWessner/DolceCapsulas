package com.example.dolcecapsulas.presenter.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dolcecapsulas.domain.auth.RegisterUseCase
import com.example.dolcecapsulas.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    fun register(nome: String, email: String, celular: String, senha: String) = liveData(Dispatchers.IO) {
            try {

                emit(StateView.Loading())

                val user = registerUseCase.invoke(nome, email, celular, senha)

                emit(StateView.Sucess(user))

            } catch (ex: Exception) {
                emit(StateView.Error(ex.message))
            }
        }

}