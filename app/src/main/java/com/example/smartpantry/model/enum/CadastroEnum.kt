package com.example.smartpantry.model.enum

enum class CadastroEnum {

}

enum class FrequenciadeComprasEnum (val descricao : String) {
    SEMANALMENTE("Semanalmente"),
    QUINZENALMENTE("Quinzenalmente"),
    MENSALMENTE("Mensalmente");
    companion object {
        fun getArrayListOfFrequencia(): ArrayList<String> {
            val frequencia = ArrayList <String> ()
            FrequenciadeComprasEnum.values().forEach { frequencia.add(it.descricao)}
            return frequencia
        }
    }
}

enum class QuantidadePessoasEnum(val descricao: String){
    UM("Um"),
    DOIS("Dois"),
    TRES("Três"),
    QUATRO("Quatro"),
    CINCO_OU_MAIS("Cinco ou mais");

    companion object {
        fun getArrayListOfFrequencia(): ArrayList<String>{
            val quantidade = ArrayList<String>()
            QuantidadePessoasEnum.values().forEach { quantidade.add(it.descricao) }
            return quantidade
        }

    }

}