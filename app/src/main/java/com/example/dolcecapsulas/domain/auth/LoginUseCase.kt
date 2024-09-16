package com.example.dolcecapsulas.domain.auth

import com.example.dolcecapsulas.data.repository.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
){
    suspend operator fun invoke(email: String, senha: String){
        return authFirebaseDataSourceImpl.login(email, senha)
    }
}