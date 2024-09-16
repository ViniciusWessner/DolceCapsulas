package com.example.dolcecapsulas.presenter.auth.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.data.model.User
import com.example.dolcecapsulas.databinding.FragmentLoginBinding
import com.example.dolcecapsulas.databinding.FragmentRegisterBinding
import com.example.dolcecapsulas.util.FirebaseHelper
import com.example.dolcecapsulas.util.StateView
import com.example.dolcecapsulas.util.initToolbar
import com.example.dolcecapsulas.util.showBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListenear()
    }

    private fun initListenear() {
       binding.btnRegister.setOnClickListener {
           validateData()
       }
    }

    private fun validateData(){
        val nome = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString().trim()
        val celular = binding.editTelefone.text.toString()
        val senha = binding.editSenha.text.toString().trim()
        val confirmaSenha = binding.editConfirmSenha.text.toString().trim()

        if (nome.isNotEmpty()){
            if (email.isNotEmpty()){
                if (celular.isNotEmpty()){
                    if (senha.isNotEmpty()){
                        if (confirmaSenha.isNotEmpty() && confirmaSenha == senha){
                            //criar conta
                            registerUser(nome, email, celular, senha)
                        } else{
                            showBottomSheet(message = "Suas senhas nao estao iguais")
                        }
                    }else{
                        showBottomSheet(message = "Digite a senha")
                    }
                }else{
                    showBottomSheet(message = "Digite o telefone")
                }
            }else{
                showBottomSheet(message = "Digite o email")
            }
        }else{
            showBottomSheet(message = "Digite o nome")
        }

    }
    
    
    private fun registerUser(nome: String, email: String, celular: String, senha: String){
        registerViewModel.register(nome, email, celular, senha).observe(viewLifecycleOwner){ stateView ->
            when(stateView){
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is StateView.Sucess -> {
                    binding.progressBar.isVisible = false
                }
                is StateView.Error -> {
                    binding.progressBar.isVisible = true
                    showBottomSheet(message =  getString(FirebaseHelper.validErrors(stateView.message ?: "Ocorreu um erro")))
                }
            }
            
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}