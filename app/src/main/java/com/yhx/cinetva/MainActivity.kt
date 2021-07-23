package com.yhx.cinetva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //title = "Cartelera para hoy"
        btIraCartelera.setOnClickListener{
            startActivity(Intent(this,CarteleraActivity::class.java))
        }
    }

}