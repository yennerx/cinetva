package com.yhx.cinetva.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R
import kotlinx.android.synthetic.main.activity_agregarpeli.*

class AgregarpeliActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregarpeli)

        var titulo = "Agregar Película"
        AppBarSecondary().show(this,titulo,true )

        btPeliAgregar.setOnClickListener {
            peliAgregar(etPeliId.text.toString(),
                etPeliNombre.text.toString(),
                etPeliSinopsis.text.toString(),
                etPeliClasificacion.text.toString(),
                etPeliPoster.text.toString())

            etPeliId.setText("")
            etPeliNombre.setText("")
            etPeliSinopsis.setText("")
            etPeliClasificacion.setText("")
            etPeliPoster.setText("")
            //etPeliId.isEnabled = false
        }

    }

    fun peliAgregar(peliId: String, peliNombre:String, peliSinopsis:String, peliClasificacion:String, peliUrlImagen:String){

        if(peliId != ""){
            db.collection("peliculas").document(peliId).set(
                hashMapOf("nombre" to peliNombre,
                    "sinopsis" to peliSinopsis,
                    "clasificacion" to peliClasificacion,
                    "urlimagen" to peliUrlImagen)
            )
        }else{
            Toast.makeText(this,"Por favor ingresar un ID",Toast.LENGTH_SHORT).show()
        }

    }
}
