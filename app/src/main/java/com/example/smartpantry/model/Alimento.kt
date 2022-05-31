package com.example.smartpantry.model

import com.example.smartpantry.enum.EstadoEnum

class Alimento(
    var nome: String,
    var quantidade: Int,
    var estoque: Int?,
    var data: String,
    var estado: EstadoEnum?
) {

}
