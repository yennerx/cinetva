package com.yhx.cinetva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cartelera.*

class CarteleraActivity : AppCompatActivity() {

    private fun peliculasPrueba():ArrayList<DataPelicula>{
        val lista = ArrayList<DataPelicula>()
        lista.add(DataPelicula(1,"Shrek","Un ogro se dispone a salvar a una princesa a cambio...","A","https://cdn.pixabay.com/photo/2015/04/14/17/08/alien-722415_960_720.jpg"))
        lista.add(DataPelicula(2,"Duro de Matar 6", "veremos cómo un joven policía llamado John ...", "C", "https://cdn.pixabay.com/photo/2015/11/18/15/02/actor-1049257_960_720.jpg"),)
        lista.add(DataPelicula(3,"Avengers Infinity War","Los superhéroes se alían para vencer al poderoso Thanos...", "B", "https://cdn.pixabay.com/photo/2019/05/31/02/08/iron-man-4241268_960_720.jpg"))
        lista.add(DataPelicula(4,"Mortal Kombat","Nueva adaptación del popular videojuego con el aval de la presencia como productor de James Wan.", "B", "https://i.blogs.es/f9d649/mortal-kombay/1366_2000.jpeg"))
        lista.add(DataPelicula(5,"Chaos Walking","Una película a la que no dejan de acompañar los problemas. Se terminó de rodar en noviembre de 2017 y no se estrena hasta ahora", "C", "https://i.blogs.es/75cbdd/chaos-walking/1366_2000.jpeg"))
        lista.add(DataPelicula(6,"Raya y el último dragón","El nuevo clásico animado de Disney, el primero desde 'Frozen 2'. Dirigida por Paul Briggs y Dean Wellins", "A", "https://i.blogs.es/28ca41/raya/1366_2000.jpeg"))
        lista.add(DataPelicula(7,"The Many Saints of Newark","Precuela de 'Los Soprano', una de las series de televisión más aclamadas de todos los tiempos.", "C", "https://i.blogs.es/a8ffff/newark/1366_2000.jpeg"))
        lista.add(DataPelicula(8,"Bob's Burgers: The Movie","Salto a la gran pantalla de la querida serie animada que ya va por su undécima temporada.", "C", "https://i.blogs.es/21b473/burgers/1366_2000.jpeg"))
        lista.add(DataPelicula(9,"Last Night in Soho","La nueva película de Edgar Wright es un thriller sobre una mujer que conoce a su ídolo en los años 60 en Londres, a donde llega de forma misteriosa.", "C", "https://i.blogs.es/f9c0f2/soho/1366_2000.jpeg"))
        lista.add(DataPelicula(10,"Godzilla vs. Kong","Adam Wingard dirige el enfrentamiento entre dos de los monstruos cinematográficos más míticos de todos los tiempos. ", "A", "https://i.blogs.es/9228a8/godzilla-kong/1366_2000.jpeg"))
        return lista
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartelera)

        rvCartelera.layoutManager = LinearLayoutManager(this)
        rvCartelera.adapter = CarteleraAdapter(peliculasPrueba(), this)

        title = "Cartelera para hoy"
    }
}