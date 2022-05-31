package com.example.smartpantry.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.smartpantry.R
import com.example.smartpantry.databinding.FragmentDadosSecundariosCadastroBinding
import com.example.smartpantry.model.enum.FrequenciadeComprasEnum
import com.example.smartpantry.model.enum.QuantidadePessoasEnum
import com.google.android.material.datepicker.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import android.widget.ArrayAdapter as ArrayAdapter

class DadosSecundariosCadastroFragment : Fragment() {

    private var _binding : FragmentDadosSecundariosCadastroBinding? = null
    private val binding get() = _binding!!
    private var dataValida = Date()
    private val datePicker: MaterialDatePicker<Long> by lazy { setupDatePicker() }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDadosSecundariosCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()
        binding.btnSalvarSegundaTelaCadastro.setOnClickListener {
            findNavController().navigate(DadosSecundariosCadastroFragmentDirections.actionDadosSecundariosCadastroFragmentToInicioFragment())
        }
    }

    private fun setupSpinner() {
        val adapterPessoas = ArrayAdapter(activity?.baseContext!!, R.layout.item_list_spinner, QuantidadePessoasEnum.getArrayListOfFrequencia())
        binding.materialAutoCompleteTextViewQuantidadePessoas.setAdapter(adapterPessoas)

        val adapterFrequencia = ArrayAdapter(activity?.baseContext!!, R.layout.item_list_spinner, FrequenciadeComprasEnum.getArrayListOfFrequencia())
        binding.autoCompleteTextViewFrequenciaCompras.setAdapter(adapterFrequencia)
    }

    private fun setupDatePicker(): MaterialDatePicker<Long> {
        val datePicker = MaterialDatePicker
            .Builder
            .datePicker()
            .setCalendarConstraints(limites())
            .setTitleText("Selecione a data")
            .build()

        datePicker.addOnPositiveButtonClickListener { data ->
            var dateString = ""
            try {
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
                dateString = simpleDateFormat.format(data)
                dataValida = Date(data)
            } catch (ex: Exception) {
                Log.e(
                    "SegundaTelaCadastro",
                    "SimpleDateFormat exception \n${ex.message}"
                )
            }
            binding.editDataCompraSegundaTelaCadastro.setText(dateString)
        }
        return datePicker
    }

    private fun limites(): CalendarConstraints {
        val constraintsBuilderRange = CalendarConstraints.Builder()

        val calendarStart = Calendar.getInstance()
        val calendarEnd = Calendar.getInstance()

        calendarStart.add(Calendar.YEAR, -1)

        val minDate = calendarStart.timeInMillis
        val maxDate = calendarEnd.timeInMillis
        constraintsBuilderRange.setStart(minDate)
        constraintsBuilderRange.setEnd(maxDate)
        val dateValidatorMin: CalendarConstraints.DateValidator =
            DateValidatorPointForward.from(minDate)
        val dateValidatorMax: CalendarConstraints.DateValidator =
            DateValidatorPointBackward.before(maxDate)

        var listValidators = ArrayList<CalendarConstraints.DateValidator>()
        listValidators.add(dateValidatorMin)
        listValidators.add(dateValidatorMax)
        var validators = CompositeDateValidator.allOf(listValidators)
        constraintsBuilderRange.setValidator(validators)

        return constraintsBuilderRange.build()
    }

}