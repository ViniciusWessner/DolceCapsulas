package com.example.dolcecapsulas.domain.auth

import com.example.dolcecapsulas.data.repository.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RecoverUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
) {

    suspend operator fun invoke(email: String){
        return authFirebaseDataSourceImpl.recover(email)
    }

}