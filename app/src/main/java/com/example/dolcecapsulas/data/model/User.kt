package com.example.dolcecapsulas.data.model

import com.google.firebase.database.Exclude

data class User(
    val id: String? = "",
    var name: String = "",
    val email: String = "",
    var celular: String = "",
    @get:Exclude
    val senha: String = "" //nao salvar no firebase usando o Exclude
)
