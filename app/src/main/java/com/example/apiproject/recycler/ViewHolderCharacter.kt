package com.example.apiproject.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R

class ViewHolderCharacter (view: View) : RecyclerView.ViewHolder(view) {

    val nameCharacter by lazy { view.findViewById<TextView>(R.id.nome_personagem) }
    val imageCharacter by lazy { view.findViewById<ImageView>(R.id.image_personagem) }

}