package com.example.apiproject.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.modelLocation.Result

class AdapterLocalizacao(
    private val listaOk: MutableList<Result>,
    private val context: Context
) : RecyclerView.Adapter<ViewHolderLocalizacao>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLocalizacao {
        val view = LayoutInflater.from(context).inflate(R.layout.detalhe_recycler_localizacao, parent, false)
        return ViewHolderLocalizacao(view)
    }

    override fun getItemCount(): Int = listaOk.size


    override fun onBindViewHolder(holder: ViewHolderLocalizacao, position: Int) {

        val name = holder.nameLocation
        name.text = listaOk[position].name

    }


}