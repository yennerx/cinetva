package com.yhx.cinetva

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sala.view.*
import kotlinx.android.synthetic.main.item_sala.view.*

class SalaAdapter(private val dataSala: List<DataSala>, private val contexto: Context):RecyclerView.Adapter<SalaAdapter.SalaHolder>() {

    class SalaHolder(private var vista: View, private var contexto: Context): RecyclerView.ViewHolder(vista){

        fun bind(dataSala : DataSala){
            var noAsiento: Int = 0
            vista.tbAsiento.textOn = "x"//dataSala.capacidad.toString()
            vista.tbAsiento.textOff = dataSala.capacidad.toString()
            //vista.tbAsiento.text = dataSala.no.toString()
            //vista.tbAsiento.text = (noAsiento+1).toString()
            vista.tbAsiento.setOnClickListener{
                Toast.makeText(vista.context,"Asientos Ocupados: ${dataSala.ocupados}", Toast.LENGTH_SHORT).show()
            }

        }

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
        holder.bind(dataSala[position])
    }

    override fun getItemCount(): Int {
        return dataSala.size
        //return dataSala.get(2).capacidad
    }
}