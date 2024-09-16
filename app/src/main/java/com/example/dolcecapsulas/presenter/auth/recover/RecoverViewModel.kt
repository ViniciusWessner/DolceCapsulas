package com.example.dolcecapsulas.presenter.auth.recover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dolcecapsulas.domain.auth.RecoverUseCase
import com.example.dolcecapsulas.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RecoverViewModel @Inject constructor(
    private val recoverUseCase: RecoverUseCase
): ViewModel() {
    fun recover(email: String) = liveData(Dispatchers.IO){
        try {
            emit(StateView.Loading())

            recoverUseCase.invoke(email)
            emit(StateView.Sucess(null))

        }catch (ex: Exception){
            emit(StateView.Error(ex.message))
        }
    }
}