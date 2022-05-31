package com.example.smartpantry.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.smartpantry.data.firebase.AuthenticationFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository() {

    private val firebase = AuthenticationFirebase()
    private val userLiveData = MutableLiveData<FirebaseUser>()

    fun login(email: String, password: String) = firebase.login(email, password)

    fun cadastro(email: String, password: String) = firebase.cadastroUsuario(email, password)

    fun userLogado() = firebase.userLogado()

    fun logout() = firebase.logout()

    fun resetSenha(email: String) = firebase.resetSenha(email)

    fun getUserLiveData(): MutableLiveData<FirebaseUser> = userLiveData

    fun getId() = FirebaseAuth.getInstance().currentUser?.uid


}