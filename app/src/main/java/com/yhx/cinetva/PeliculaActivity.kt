package com.yhx.cinetva

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pelicula.*


class PeliculaActivity : AppCompatActivity(){
    private fun funcionesPrueba(): ArrayList<DataFuncion>{
        val lista = ArrayList<DataFuncion>()
        lista.add(DataFuncion(1,"10:00","24/07/2021",1,1))
        lista.add(DataFuncion(5,"11:30","24/07/2021",1,2))
        lista.add(DataFuncion(7,"13:10","24/07/2021",1,2))
        lista.add(DataFuncion(10,"14:40","24/07/2021",1,3))
        lista.add(DataFuncion(11,"16:20","24/07/2021",1,1))
        lista.add(DataFuncion(14,"17:50","24/07/2021",1,2))
        return lista
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        val pelicula = intent.getSerializableExtra("pel") as DataPelicula

        tvTituloPeli.setText(pelicula.titulo)
        tvSinopsisPeli.setText(pelicula.sinopsis)
        tvClasificacionPeli.setText("Clasificación: ${pelicula.clasificacion}")
        Picasso.get().load(pelicula.poster).into(ivPosterPeli)

        rvFunciones.layoutManager = LinearLayoutManager(this)
        rvFunciones.adapter = FuncionAdapter(funcionesPrueba(), this)

        title = "Funciones para: ${pelicula.titulo}"
    }
}