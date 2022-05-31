package com.example.smartpantry.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.smartpantry.databinding.FragmentHomeBinding
import com.example.smartpantry.viewmodel.ComponentesVisuais
import com.example.smartpantry.viewmodel.EstadoAppViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val estadoViewModel : EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        estadoViewModel.temComponentes = ComponentesVisuais(
            appBar = false,
            bottomNavigation = false

        )
        binding.btnLoginFragmentHome.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        }

        binding.btnPrimeiroAcessoFragmentHome.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCadastroFragment())
        }
    }

}