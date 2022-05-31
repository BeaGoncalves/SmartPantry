package com.example.smartpantry.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartpantry.databinding.ItemListProdutosCadastradosBinding
import com.example.smartpantry.model.Alimento

class AlimentoAdapter(
    val list: List<Alimento>,
    private val alimento: MutableList<Alimento> = mutableListOf()
): RecyclerView.Adapter<AlimentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
        return AlimentoViewHolder(ItemListProdutosCadastradosBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
        val item = list[position]
        if (item.estoque == 0){ holder.itemView.visibility = View.GONE }
        holder.binding.apply {
            tvNomeAlimentoCadastrado.text = item.nome
            itemProdutosCadastradoData.text = item.data

        }
    }

    override fun getItemCount(): Int = list.size

    fun update(novoAlimento: List<Alimento>) {
        notifyItemRangeRemoved(0, alimento.size)
        alimento.clear()
        alimento.addAll(novoAlimento)
        notifyItemRangeInserted(0, alimento.size)
    }
}

class AlimentoViewHolder(val binding: ItemListProdutosCadastradosBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var alimento: Alimento
        

}
