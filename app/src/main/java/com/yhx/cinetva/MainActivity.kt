package com.yhx.cinetva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yhx.cinetva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var dataPelicula: List<DataPelicula> = listOf(
        DataPelicula(1,"Shrek","Un ogro se dispone a salvar a una princesa a cambio...","A","https://cdn.pixabay.com/photo/2015/04/14/17/08/alien-722415_960_720.jpg"),
        DataPelicula(2,"Duro de Matar 6", "veremos cómo un joven policía llamado John ...", "C", "https://cdn.pixabay.com/photo/2015/11/18/15/02/actor-1049257_960_720.jpg"),
        DataPelicula(3,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg")
    )

    private lateinit var recyclerView1: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView1 = binding.rvCartelera

        iniciarRecycler()
        title = "Cartelera para hoy"
    }

    fun iniciarRecycler(){
        recyclerView1.layoutManager = LinearLayoutManager(this)
        val adapter = CarteleraAdapter(dataPelicula)
        recyclerView1.adapter = adapter
    }
}