package com.br.currencyconversion.ui.fragment.historic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.currencyconversion.R
import com.br.currencyconversion.database.model.Historic
import kotlinx.android.synthetic.main.item_list_historic.view.*

class ListHistoricAdapter(private val itens:MutableList<Historic> = mutableListOf()): RecyclerView.Adapter<ListHistoricAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_historic,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(itens[position])
    }

    fun update(itensnew:List<Historic>){
        itens.clear()
        itens.addAll(itensnew)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        private val textTitle = itemView.title
        private val textConversion = itemView.conversion

        fun setItem(item:Historic){
            textTitle.text = "${item.currentCurrency} -> ${item.currencyConverter}"
            textConversion.text ="${item.currentCurrencyValue} -> ${item.currencyConverterValue}"
        }

    }
}