package com.example.smartpantry.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartpantry.R
import com.example.smartpantry.R.layout.fragment_despensa
import com.example.smartpantry.R.layout.fragment_geladeira
import com.example.smartpantry.adapter.AlimentoAdapter
import com.example.smartpantry.adapter.TabPagerAdapter
import com.example.smartpantry.databinding.FragmentInicioBinding
import com.example.smartpantry.model.Alimento
import com.example.smartpantry.viewmodel.AlimentosViewModel
import com.example.smartpantry.viewmodel.ComponentesVisuais
import com.example.smartpantry.viewmodel.EstadoAppViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

class InicioFragment : Fragment() {

    private var _binding : FragmentInicioBinding? = null
    private val binding get() = _binding!!
    private val viewModel : AlimentosViewModel by viewModels()
    private val estadoAppModel: EstadoAppViewModel by sharedViewModel()
    private val alimentos = ArrayList<Alimento>()
    private lateinit var adapter : AlimentoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        estadoAppModel.temComponentes = ComponentesVisuais(appBar = true, bottomNavigation = true)
        configuraRecyclerView()

    }

    private fun configuraRecyclerView() {
        adapter = AlimentoAdapter(alimentos)
        binding.recyclerViewAlimentosCadastrados.adapter = adapter
        binding.recyclerViewAlimentosCadastrados.layoutManager = LinearLayoutManager(requireContext())
    }


}