package com.example.apiproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.modelCharacter.Result3
import com.example.apiproject.modelLocation.Result
import com.example.apiproject.modelEpisode.Result2
import com.example.apiproject.recycler.AdapterCharacter
import com.example.apiproject.recycler.AdapterEpisodios
import com.example.apiproject.recycler.AdapterLocalizacao

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view) }
    val recycler2 by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view_2) }
    val recycler3 by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view_3) }
    private var listaLocalidades = mutableListOf<Result>()
    private var listaEpisodios = mutableListOf<Result2>()
    private var listaPersonagens = mutableListOf<Result3>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        recycler?.layoutManager = LinearLayoutManager(activity)
        recycler2?.layoutManager = LinearLayoutManager(activity)
        recycler3?.layoutManager = LinearLayoutManager(activity)

        val adapter = activity?.let { AdapterLocalizacao(listaLocalidades, it) }
        recycler?.adapter = adapter

        val adapter2 = activity?.let { AdapterEpisodios(listaEpisodios, it) }
        recycler2?.adapter = adapter2

        val adapter3 = activity?.let { AdapterCharacter(listaPersonagens, it) }
        recycler3?.adapter = adapter3


        viewModel.chamarLocalizacaoCoroutineOk()
        viewModel.localizacaoLiveData.observe(this, Observer { lista ->
            lista?.let {
             listaLocalidades.addAll(it)
            }
            adapter?.notifyDataSetChanged()

        })


        viewModel.chamarEpisodiosCoroutinesOk()
        viewModel.episodiosLiveData.observe(this, Observer { lista2 ->
            lista2?.let {
                listaEpisodios.addAll(it)
            }
            adapter2?.notifyDataSetChanged()

        })

        viewModel.chamarPersonagemCoroutineOk()
        viewModel.personagensLiveData.observe(this, Observer { lista3 ->
            lista3?.let {
                listaPersonagens.addAll(it)
            }
            adapter3?.notifyDataSetChanged()

        })

    }



}