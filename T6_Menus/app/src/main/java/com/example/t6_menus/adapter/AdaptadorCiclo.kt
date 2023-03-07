package com.example.t6_menus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t6_menus.R
import com.example.t6_menus.model.Ciclo

class AdaptadorCiclo(var contexto: Context, var lista: ArrayList<Ciclo>): BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Ciclo {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val ciclo = lista[0]
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_spinner, p2, false)
        var textoNombre: TextView = vista.findViewById(R.id.nombre_spinner)
        var imagenImage: ImageView = vista.findViewById(R.id.imagen_spinner)

        textoNombre.setText(ciclo.nombre)
        imagenImage.setImageResource(ciclo.imagen)

        return vista
    }
}