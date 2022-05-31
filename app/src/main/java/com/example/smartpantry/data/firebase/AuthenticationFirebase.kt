package com.example.smartpantry.data.firebase

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

class AuthenticationFirebase {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val application = Application()
    private val firebaseUserMutableLiveData = MutableLiveData<FirebaseUser>()
    private val userLoggedMutableLiveData = MutableLiveData<Boolean>()
    private val firebaseRealtimedatabase = FirebaseRealTimeDatabase()

    init {
        if (firebaseAuth.currentUser != null) firebaseUserMutableLiveData.postValue(firebaseAuth.currentUser)
    }

    fun cadastroUsuario(email: String, senha: String ) {
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    firebaseUserMutableLiveData.postValue(firebaseAuth.currentUser)

                }
            }
    }
        fun login(email: String, senha: String) {
            firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        firebaseUserMutableLiveData.postValue(firebaseAuth.currentUser)
                    }
                }
        }

        fun logout() {
            firebaseAuth.signOut()
            userLoggedMutableLiveData.postValue(true)
        }

        fun resetSenha(email: String) {
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { firebaseUserMutableLiveData.postValue(firebaseAuth.currentUser) }
        }

        fun userLogado(): Boolean = firebaseAuth.currentUser != null

        fun getId() = firebaseAuth.uid
    }

