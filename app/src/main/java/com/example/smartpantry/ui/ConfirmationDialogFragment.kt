package com.example.smartpantry.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.smartpantry.R
import com.example.smartpantry.viewmodel.GraphViewModel

class ConfirmationDialogFragment() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val navController = NavHostFragment.findNavController(this)
        val viewModelProvider = ViewModelProvider(navController.getViewModelStoreOwner(R.id.nav_graph))
        val vm = viewModelProvider.get(GraphViewModel::class.java)

        return AlertDialog.Builder(requireContext())
            .setTitle("Redefinição de senha")
            .setMessage("Enviamos um link para o email informado")
            .setPositiveButton("OK") {_, _ -> vm.onAccept()
                navController.navigate(ConfirmationDialogFragmentDirections.actionConfirmationDialogFragmentToLoginFragment())
            }
            .setOnCancelListener { vm.onDecline() }
            .create()
    }


}





