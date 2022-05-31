package com.example.smartpantry.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.smartpantry.R
import com.example.smartpantry.databinding.FragmentLoginBinding
import com.example.smartpantry.viewmodel.EstadoAppViewModel
import com.example.smartpantry.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {


   private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel : LoginViewModel by viewModel()
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLoginTelaLogin.setOnClickListener {
            var email = binding.editEmailLogin.text.toString()
            var senha = binding.editSenhaLogin.text.toString()
            viewModel.login(email, senha)
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToInicioFragment())
        }
        binding.buttonEsqueciSenhaLogin.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToResetSenhaFragment())
        }
    }

}