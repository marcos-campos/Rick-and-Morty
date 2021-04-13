package com.example.apiproject.recycler

import android.content.Context
import android.content.Intent
import android.media.CamcorderProfile.get
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.modelCharacter.Location
import com.example.apiproject.modelCharacter.Origin
import com.example.apiproject.modelCharacter.Result3
import com.example.apiproject.modelEpisode.Result2
import com.example.apiproject.ui.main.PersonagemDescricao
import com.squareup.picasso.Picasso
import okhttp3.HttpUrl.Companion.get
import okhttp3.internal.http.StatusLine.Companion.get
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class AdapterCharacter(
    private val listaOkCharacter: MutableList<Result3>,
    private val context: Context
) : RecyclerView.Adapter<ViewHolderCharacter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        val view = LayoutInflater.from(context).inflate(R.layout.detalhe_recycler_personagem, parent, false)
        return ViewHolderCharacter(view)
    }

    override fun getItemCount(): Int = listaOkCharacter.size


    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {

        val nameEpisodio = holder.nameCharacter
        nameEpisodio.text = listaOkCharacter[position].name

        val character = listaOkCharacter.elementAt(position)
        Picasso.with(context).load(character.image).into(holder.imageCharacter)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, PersonagemDescricao::class.java)

            intent.putExtra("CREATED", listaOkCharacter[position].created)
            intent.putExtra("EPISODE", listaOkCharacter[position].episode.toString())
            intent.putExtra("GENDER", listaOkCharacter[position].gender)
            intent.putExtra("ID", listaOkCharacter[position].id)
            intent.putExtra("IMAGEM", listaOkCharacter[position].image)
            intent.putExtra("LOCATION", listaOkCharacter[position].location?.name.toString())
            intent.putExtra("NOME", listaOkCharacter[position].name)
            intent.putExtra("ORIGINURL", listaOkCharacter[position].origin?.url.toString())
            intent.putExtra("ORIGINNAME", listaOkCharacter[position].origin?.name.toString())
            intent.putExtra("ESPECIE", listaOkCharacter[position].species)
            intent.putExtra("STATUS", listaOkCharacter[position].status)
            intent.putExtra("TYPE", listaOkCharacter[position].type)
            intent.putExtra("URL", listaOkCharacter[position].url)

            it.context.startActivity(intent)


        }


    }

}