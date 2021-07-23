package com.yhx.cinetva.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R

class AgregarpeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregarpeli)

        var titulo = "Agregar Película"
        AppBarSecondary().show(this,titulo,true )

        }
    }
