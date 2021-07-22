package com.yhx.cinetva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun peliculasPrueba():ArrayList<DataPelicula>{
        val lista = ArrayList<DataPelicula>()
        lista.add(DataPelicula(1,"Shrek","Un ogro se dispone a salvar a una princesa a cambio...","A","https://cdn.pixabay.com/photo/2015/04/14/17/08/alien-722415_960_720.jpg"))
        lista.add(DataPelicula(2,"Duro de Matar 6", "veremos cómo un joven policía llamado John ...", "C", "https://cdn.pixabay.com/photo/2015/11/18/15/02/actor-1049257_960_720.jpg"),)
        lista.add(DataPelicula(3,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(4,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(5,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(6,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(7,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(8,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(9,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(10,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        return lista
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCartelera.layoutManager = LinearLayoutManager(this)
        rvCartelera.adapter = CarteleraAdapter(peliculasPrueba(), this)

        title = "Cartelera para hoy"
    }

}