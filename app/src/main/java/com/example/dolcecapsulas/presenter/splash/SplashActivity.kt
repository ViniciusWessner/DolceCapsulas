package com.example.dolcecapsulas.presenter.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.presenter.MainActivity

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Navegar para a MainActivity após o splash
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finaliza a SplashActivity para que não possa ser retornada
        }, 2000) // 2 segundos de delay
    }
}
