package com.yhx.cinetva

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pelicula.*


class PeliculaActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        val pelicula = intent.getSerializableExtra("pel") as DataPelicula

        tvTituloPeli.setText(pelicula.titulo)
        tvSinopsisPeli.setText(pelicula.sinopsis)
        tvClasificacionPeli.setText("Clasificación: ${pelicula.clasificacion}")
        Picasso.get().load(pelicula.poster).into(ivPosterPeli)
    }
}