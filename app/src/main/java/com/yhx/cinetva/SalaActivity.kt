package com.yhx.cinetva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pelicula.*
import kotlinx.android.synthetic.main.activity_sala.*

class SalaActivity : AppCompatActivity() {

    private fun salasPrueba(): ArrayList<DataSala>{
        val lista = ArrayList<DataSala>()
        lista.add(DataSala(1,20,8,"Estandar",1))
        lista.add(DataSala(2,16,4,"VIP",1))
        lista.add(DataSala(3,30,20,"3D",1))
        return lista
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sala)

        val funcion = intent.getSerializableExtra("pel") as DataFuncion

        tvNoSala.setText("Sala No. ${funcion.sala}")
        tvCategoria.setText("Categoria: ${salasPrueba().get(funcion.sala-1).categoria}")
        tvCapacidad.setText("Capacidad: ${salasPrueba().get(funcion.sala -1).capacidad}")
        tvOcupados.setText("Ocupados: ${salasPrueba().get(funcion.sala-1).ocupados}")
        tvDisponibles.setText("Disponibles: ${salasPrueba().get(funcion.sala-1).capacidad - salasPrueba().get(funcion.sala-1).ocupados}")

        rvSala.layoutManager = GridLayoutManager(this,4)
        rvSala.adapter = SalaAdapter(salasPrueba(), this, salasPrueba().get(funcion.sala -1).capacidad)

        btFinalizar.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        title = "Seleccione Asientos"
    }
}