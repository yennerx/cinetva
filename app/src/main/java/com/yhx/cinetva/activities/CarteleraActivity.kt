package com.yhx.cinetva.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R
import com.yhx.cinetva.adapters.CarteleraAdapter
import com.yhx.cinetva.data.DataPelicula
import kotlinx.android.synthetic.main.activity_cartelera.*

class CarteleraActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private fun peliculasPrueba():ArrayList<DataPelicula>{

        val peliculas = db.collection("peliculas")
        val lista = ArrayList<DataPelicula>()
        var prueba = "NA"

        peliculas.get().addOnSuccessListener { result ->
            for(document in result){
                //System.out.println("${document.id} => ${document.data.get("nombre")} -------${result}")
                lista.add(DataPelicula(document.id.toInt(),document.data.get("nombre").toString(),document.data.get("sinopsis").toString(),document.data.get("clasificacion").toString(),document.data.get("urlimagen").toString()))
                System.out.println(document.id)
                System.out.println(document.data.get("nombre").toString())
                System.out.println(document.data.get("sinopsis").toString())
                System.out.println(document.data.get("clasificacion").toString())
                System.out.println(document.data.get("urlimagen").toString())

                prueba += ","+document.data.get("nombre").toString()
                //Toast.makeText(this,"Película agregada: ${prueba}",Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(this,"Cantidad de Peliculas: ${result.size()}",Toast.LENGTH_SHORT).show()
        }

        Toast.makeText(this,"Película agregada: ${prueba}",Toast.LENGTH_SHORT).show()
        //lista.add(DataPelicula(1,"Shrek","Un ogro se dispone a salvar a una princesa a cambio...","A","https://cdn.pixabay.com/photo/2015/04/14/17/08/alien-722415_960_720.jpg"))
        return lista
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartelera)

        rvCartelera.layoutManager = LinearLayoutManager(this)
        rvCartelera.adapter = CarteleraAdapter(peliculasPrueba(), this)

        var titulo = "Cartelera para hoy"
        AppBarSecondary().show(this,titulo,true )
    }
}