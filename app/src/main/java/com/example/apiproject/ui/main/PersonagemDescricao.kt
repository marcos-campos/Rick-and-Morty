package com.example.apiproject.ui.main

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.apiproject.R
import com.example.apiproject.modelCharacter.Location
import com.example.apiproject.modelCharacter.Origin
import com.example.apiproject.modelCharacter.Result3
import com.squareup.picasso.Picasso

class PersonagemDescricao: AppCompatActivity() {

    val nomeDoPersonagemOk by lazy { findViewById<TextView>(R.id.nome_personagem_descricao) }
    val especiePersonagem by lazy { findViewById<TextView>(R.id.species) }
    val imagemViewPersonsagem by lazy { findViewById<ImageView>(R.id.imagem_personagem_descricao) }
    val origemPersonsagem by lazy { findViewById<TextView>(R.id.origin_api) }
    val statusPersonsagem by lazy { findViewById<TextView>(R.id.status_api) }
    val localPersonsagem by lazy { findViewById<TextView>(R.id.location_api) }
    val dataPersonsagem by lazy { findViewById<TextView>(R.id.criacao_api) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.descricao_personagem)

        val informacoes = intent.extras

        if (informacoes != null){

            val nameCharacterOk = informacoes.getString("NOME")
            val imagemOk = informacoes.getString("IMAGEM")
            val specieCharacterOk = informacoes.getString("ESPECIE")
            val origemCharacterOk = informacoes.getString("ORIGINNAME")
            val statusCharacterOk = informacoes.getString("STATUS")
            val localCharacterOk = informacoes.getString("LOCATION")
            val dataCharacterOk = informacoes.getString("CREATED")

            nomeDoPersonagemOk.text = nameCharacterOk
            especiePersonagem.text = specieCharacterOk
            origemPersonsagem.text = origemCharacterOk
            statusPersonsagem.text = statusCharacterOk
            localPersonsagem.text = localCharacterOk
            dataPersonsagem.text = dataCharacterOk


            Picasso.with(this).load(imagemOk).into(imagemViewPersonsagem)


        }else{

            Toast.makeText(this, "Erro ao carregar dados", Toast.LENGTH_LONG).show()

        }


    }
}