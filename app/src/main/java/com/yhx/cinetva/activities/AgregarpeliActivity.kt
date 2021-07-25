package com.yhx.cinetva.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R
import kotlinx.android.synthetic.main.activity_agregarpeli.*
import kotlinx.android.synthetic.main.activity_modificarpeli.*

class AgregarpeliActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregarpeli)

        var titulo = "Agregar Película"
        AppBarSecondary().show(this,titulo,true )

        btPeliAgregar.setOnClickListener {
            peliAgregar()
        }

    }

    fun peliAgregar(){
        val peliId: String = etPeliId.text.toString()
        val peliNombre:String = etPeliNombre.text.toString()
        val peliSinopsis:String = etPeliSinopsis.text.toString()
        val peliClasificacion:String = etPeliClasificacion.text.toString()
        val peliUrlImagen:String = etPeliPoster.text.toString()

        if(peliId != ""){
            db.collection("peliculas").document(peliId).set(
                hashMapOf("nombre" to peliNombre,
                    "sinopsis" to peliSinopsis,
                    "clasificacion" to peliClasificacion,
                    "urlimagen" to peliUrlImagen)
            )

            etPeliId.setText("")
            etPeliNombre.setText("")
            etPeliSinopsis.setText("")
            etPeliClasificacion.setText("")
            etPeliPoster.setText("")
        }else{
            Toast.makeText(this,"Por favor ingresar un ID",Toast.LENGTH_SHORT).show()
        }

    }
}
