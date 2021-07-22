package com.yhx.cinetva

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yhx.cinetva.databinding.ItemCarteleraBinding

class CarteleraAdapter (val dataPelicula:List<DataPelicula>):RecyclerView.Adapter<CarteleraAdapter.CarteleraHolder>(){

    class CarteleraHolder(val vista: View):RecyclerView.ViewHolder(vista){
        //binding a el layout item_cartelera.xml
        val binding = ItemCarteleraBinding.bind(vista)

        fun render(dataPelicula: DataPelicula){
            binding.tvTitulo.text = dataPelicula.titulo
            binding.tvSinopsis.text = dataPelicula.sinopsis
            binding.tvClasificacion.text = dataPelicula.clasificacion
            Picasso.get().load(dataPelicula.poster).into(binding.ivPoster)

            vista.setOnClickListener{Toast.makeText(vista.context,"Proceder a película: ${dataPelicula.titulo}",Toast.LENGTH_SHORT).show()}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarteleraAdapter.CarteleraHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarteleraAdapter.CarteleraHolder(layoutInflater.inflate(R.layout.item_cartelera,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CarteleraHolder, position: Int) {
        holder.render(dataPelicula[position])
    }

    override fun getItemCount(): Int {
        return dataPelicula.size
    }
}