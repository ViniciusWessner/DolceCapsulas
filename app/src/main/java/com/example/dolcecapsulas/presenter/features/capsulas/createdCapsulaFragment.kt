package com.example.dolcecapsulas.presenter.features.capsulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.databinding.FragmentCreatedCapsulaBinding
import com.example.dolcecapsulas.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class createdCapsulaFragment : Fragment() {

    private var _binding: FragmentCreatedCapsulaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatedCapsulaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}