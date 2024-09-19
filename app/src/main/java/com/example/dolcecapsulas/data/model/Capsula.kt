package com.example.dolcecapsulas.data.model

import com.google.firebase.database.Exclude


data class Capsula(
    val id: String? = "",
    var name: String = "",
    val description: String = ""
)