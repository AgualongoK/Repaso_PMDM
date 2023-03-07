package com.example.t6_menus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t6_menus.R
import com.example.t6_menus.model.Asignatura

class AdaptadorAsignaturas(var listaAsignaturas: ArrayList<Asignatura>, var contexto: Context): RecyclerView.Adapter<AdaptadorAsignaturas.MyHolder>() {

    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemNombre: TextView

        init {
            itemNombre = itemView.findViewById(R.id.nombre_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val asignatura = listaAsignaturas[position]
        holder.itemNombre.setText(asignatura.nombre)

    }

    override fun getItemCount(): Int {
        return listaAsignaturas.size
    }



    fun clarAsignaturas(){
        this.listaAsignaturas.clear()
        this.notifyDataSetChanged()
    }
}