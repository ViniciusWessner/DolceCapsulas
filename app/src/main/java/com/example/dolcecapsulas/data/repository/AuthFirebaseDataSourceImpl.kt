package com.example.dolcecapsulas.data.repository

import com.example.dolcecapsulas.data.model.User
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine


class AuthFirebaseDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthFirebaseDataSource {


    override suspend fun login(email: String, senha: String) {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        continuation.resumeWith(Result.success(Unit))
                    }else{
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }

    override suspend fun register(nome: String, email: String, celular: String, senha: String): User {
        return suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val userId = task.result.user?.uid ?: ""
                        val user = User(
                            id = userId,
                            name = nome,
                            email = email,
                            celular = celular,
                            senha = senha
                        )
                        continuation.resumeWith(Result.success(user))
                    } else{
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }

                }
        }
    }

    override suspend fun recover(email: String) {
        return suspendCoroutine { continuation ->
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        continuation.resumeWith(Result.success(Unit))
                    } else{
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }

}