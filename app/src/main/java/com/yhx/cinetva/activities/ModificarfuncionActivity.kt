package com.yhx.cinetva.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yhx.cinetva.AppBarSecondary
import com.yhx.cinetva.R

class ModificarfuncionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificarfuncion)

        var titulo = "Modificar Función"
        AppBarSecondary().show(this,titulo,true )
    }
}