package com.example.dolcecapsulas.presenter.auth.recover

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.databinding.FragmentLoginBinding
import com.example.dolcecapsulas.databinding.FragmentRecoverBinding
import com.example.dolcecapsulas.util.FirebaseHelper
import com.example.dolcecapsulas.util.StateView
import com.example.dolcecapsulas.util.initToolbar
import com.example.dolcecapsulas.util.showBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoverFragment : Fragment() {

    private var _binding: FragmentRecoverBinding? = null
    private val binding get() = _binding!!

    private val recoverViewModel: RecoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.btnRecover.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        val email = binding.editEmailRecover.text.toString().trim()

        if (email.isNotEmpty()){
            recoverAccount(email)
        } else{
            showBottomSheet(message = "Não encontramos seu e-mail")
        }
    }

    private fun recoverAccount(email: String){
        recoverViewModel.recover(email).observe(viewLifecycleOwner){ stateView ->
            when(stateView){
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is StateView.Sucess -> {
                    binding.progressBar.isVisible = false
                    showBottomSheet(message = "E-mail de recuperação de senha enviado com sucesso")
                    findNavController().popBackStack()
                }
                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    showBottomSheet(message = getString(FirebaseHelper.validErrors(stateView.message ?:  "OCORREU ALGUM ERRO NO ENVIO DO LINK")))

                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}