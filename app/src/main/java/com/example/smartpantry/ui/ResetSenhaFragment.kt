package com.example.smartpantry.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.smartpantry.R
import com.example.smartpantry.databinding.FragmentResetSenhaBinding
import com.example.smartpantry.viewmodel.ResetSenhaViewModel

class ResetSenhaFragment : Fragment() {

    private var _binding: FragmentResetSenhaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResetSenhaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResetSenhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLoginTelaSenha.setOnClickListener {
            val email = binding.editEmailSenha.text.toString()
            viewModel.resetSenha(email)
            findNavController().navigate(ResetSenhaFragmentDirections.actionResetSenhaFragmentToConfirmationDialogFragment())
        }


    }
}


