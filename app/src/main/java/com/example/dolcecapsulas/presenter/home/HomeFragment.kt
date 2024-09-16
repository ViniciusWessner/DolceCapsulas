package com.example.dolcecapsulas.presenter.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.databinding.FragmentHomeBinding
import com.example.dolcecapsulas.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        val navController = requireActivity().findNavController(R.id.nav_host_fragment)
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.btnv)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}