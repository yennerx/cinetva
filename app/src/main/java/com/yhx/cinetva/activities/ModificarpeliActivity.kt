package com.yhx.cinetva.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R

class ModificarpeliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificarpeli)

        var titulo = "Modificar Película"
        AppBarSecondary().show(this,titulo,true )
    }
}