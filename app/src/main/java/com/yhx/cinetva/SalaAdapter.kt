package com.yhx.cinetva

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sala.view.*
import kotlinx.android.synthetic.main.item_sala.view.*

class SalaAdapter(private val dataSala: List<DataSala>, private val contexto: Context, private val capacidad: Int):RecyclerView.Adapter<SalaAdapter.SalaHolder>() {

    private val asientos = (1).rangeTo(capacidad).toList()

    class SalaHolder(private var vista: View, private var contexto: Context): RecyclerView.ViewHolder(vista){

           val button = vista.findViewById<ToggleButton>(R.id.tbAsiento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalaAdapter.SalaHolder {
        return SalaAdapter.SalaHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_sala,
                parent,
                false
            ), contexto
        )
    }

    override fun onBindViewHolder(holder: SalaHolder, position: Int) {
        val item = asientos.get(position)
        holder.button.textOff = item.toString()
        holder.button.textOn = "x"
        holder.button.setOnClickListener{
            holder.button.textOn.toString()
        }
    }

    override fun getItemCount(): Int {
        return asientos.size
    }
}