package com.example.dolcecapsulas.presenter.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.databinding.FragmentSplashBinding
import com.example.dolcecapsulas.util.FirebaseHelper

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(this::verifyAuth, 3000) //3s para chamar a funcao verifyAuth()
    }

    private fun verifyAuth(){
        if (FirebaseHelper.isAuthenticated()){
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment3)
        } else {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}