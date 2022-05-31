package com.example.smartpantry

import com.example.smartpantry.adapter.AlimentoAdapter
import com.example.smartpantry.data.repository.AuthenticationRepository
import com.example.smartpantry.data.repository.ProdutoRepository
import com.example.smartpantry.ui.*
import com.example.smartpantry.viewmodel.AlimentosViewModel
import com.example.smartpantry.viewmodel.CadastroViewModel
import com.example.smartpantry.viewmodel.EstadoAppViewModel
import com.example.smartpantry.viewmodel.LoginViewModel
import get
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val daoModule = module {
    single<ProdutoRepository>{ ProdutoRepository() }
    single<AuthenticationRepository> { AuthenticationRepository()  }
}

val uiModule = module {
    single { CadastroFragment() }
    single { LoginFragment() }
    single { CadastroProdutoFragment() }
    single { DadosSecundariosCadastroFragment() }
    single { AlimentoAdapter(get()) }

}

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { CadastroViewModel()}
    viewModel { AlimentosViewModel() }
    viewModel { EstadoAppViewModel() }
}