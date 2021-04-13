package com.example.apiproject.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.modelEpisode.Result2

class AdapterEpisodios(
    private val listaOkEpisodios: MutableList<Result2>,
    private val context: Context
) : RecyclerView.Adapter<ViewHolderEpisodios>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEpisodios {
        val view = LayoutInflater.from(context).inflate(R.layout.detalhe_recycler_episodios, parent, false)
        return ViewHolderEpisodios(view)
    }

    override fun getItemCount(): Int = listaOkEpisodios.size


    override fun onBindViewHolder(holder: ViewHolderEpisodios, position: Int) {

        val nameEpisodio = holder.nameEpisodios
        nameEpisodio.text = listaOkEpisodios[position].name
    }

}
