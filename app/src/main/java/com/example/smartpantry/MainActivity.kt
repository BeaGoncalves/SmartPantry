package com.example.smartpantry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.smartpantry.adapter.TabPagerAdapter
import com.example.smartpantry.databinding.ActivityMainBinding
import com.example.smartpantry.viewmodel.EstadoAppViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val controller by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    private val viewModel : EstadoAppViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener{controller, destination, arguments ->
            title = destination.label
            viewModel.componentes.observe(this, Observer {
                it?.let { temComponentes ->
                    if (temComponentes.appBar){
                        binding.appbarLayout.visibility = VISIBLE
                    } else {
                        binding.appbarLayout.visibility = GONE
                    }
                        if (temComponentes.bottomNavigation) {
                        binding.buttonNavigation.visibility = VISIBLE
                        }else {
                            binding.buttonNavigation.visibility = GONE
                    }
                }

            })
        }
        binding.buttonNavigation.setupWithNavController(navController)
    }
}