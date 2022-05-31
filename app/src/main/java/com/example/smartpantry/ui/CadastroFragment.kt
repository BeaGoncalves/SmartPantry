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
import com.example.smartpantry.databinding.FragmentCadastroBinding
import com.example.smartpantry.viewmodel.CadastroViewModel

class CadastroFragment : Fragment() {

    private var _binding : FragmentCadastroBinding? = null
    private val binding get() = _binding!!
    private val viewModel : CadastroViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnProximoCadastro.setOnClickListener {
            val nomeCadastro = binding.editNomeCadastro.text.toString()
            val email = binding.editEmailCadastro.text.toString()
            val senha = binding.editSenhaCadastro.text.toString()
            val confirmaSenha = binding.editConfirmaSenhaCadastro.text.toString()

            if (senha == confirmaSenha){
                viewModel.cadastro(email, senha, nomeCadastro)
                viewModel.salvarUser(nomeCadastro, email)
                findNavController().navigate(CadastroFragmentDirections.actionCadastroFragmentToDadosSecundariosCadastroFragment())
            }

        }
    }


}