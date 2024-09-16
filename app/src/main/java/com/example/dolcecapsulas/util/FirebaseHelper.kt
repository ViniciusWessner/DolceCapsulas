package com.example.dolcecapsulas.util

import com.example.dolcecapsulas.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FirebaseHelper {

    companion object{

        fun getAuth() = FirebaseAuth.getInstance()

        fun isAuthenticated() = getAuth().currentUser != null

        fun getUserId() = getAuth().currentUser?.uid ?: ""

        fun validErrors(error: String): Int {
            return when {
                error.contains("There is no user record corresponding to this identifier") -> {
                    R.string.account_not_registered_register_fragment
                }
                error.contains("The supplied auth credential is incorrect, malformed or has expired.") -> {
                    R.string.login_or_password_error
                }

                error.contains("The email address is badly formatted") -> {
                    R.string.invalid_email_register_fragment
                }

                error.contains("The password is invalid or the user does") -> {
                    R.string.invalid_password_register_fragment
                }

                error.contains("The email address is already in use") -> {
                    R.string.email_in_use_register_fragment
                }

                error.contains("The given password is invalid.") -> {
                    R.string.strong_password_register_fragment
                }

                else -> R.string.ocorreu_um_erro
            }
        }

        fun generateId() = FirebaseDatabase.getInstance().reference.push().key ?: ""
    }

}