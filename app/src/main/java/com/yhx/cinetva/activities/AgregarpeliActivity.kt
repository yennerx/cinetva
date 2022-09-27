package com.yhx.cinetva.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R
import kotlinx.android.synthetic.main.activity_agregarpeli.*
import kotlinx.android.synthetic.main.activity_modificarpeli.*

class AgregarpeliActivity : AppCompatActivity() {

    //private val db = FirebaseFirestore.getInstance()
    val db = Firebase.firestore

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
            val pelicula = hashMapOf(
                "clasificacion" to peliClasificacion,
                "id" to peliId,
                "nombre" to peliNombre,
                "sinopsis" to peliSinopsis,
                "urlimagen" to peliUrlImagen)

            db.collection("peliculas")
                .add(pelicula)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    Toast.makeText(this,"Pelicula Agregada: ${documentReference.id}",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                    Toast.makeText(this, "Error: ${e}",Toast.LENGTH_SHORT).show()
                }


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
