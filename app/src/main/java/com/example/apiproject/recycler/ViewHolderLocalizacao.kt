package com.example.apiproject.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R

class ViewHolderLocalizacao(view: View) : RecyclerView.ViewHolder(view) {

    val nameLocation by lazy { view.findViewById<TextView>(R.id.nome_localizacao) }

}
