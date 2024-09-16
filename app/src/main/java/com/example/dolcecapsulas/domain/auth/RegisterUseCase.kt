package com.example.dolcecapsulas.domain.auth

import com.example.dolcecapsulas.data.model.User
import com.example.dolcecapsulas.data.repository.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
) {

    suspend operator fun invoke(nome: String, email: String, celular: String, senha: String): User {
        return authFirebaseDataSourceImpl.register(nome, email, celular, senha)
    }

}