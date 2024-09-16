package com.example.dolcecapsulas.data.repository

import com.example.dolcecapsulas.data.model.User

interface AuthFirebaseDataSource {

    suspend fun login(
        email: String,
        senha: String,
    )

    suspend fun register(
        nome: String,
        email: String,
        celular: String,
        senha: String
    ): User

    suspend fun recover(
        email: String
    )
}