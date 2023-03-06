package com.example.t3_listas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t3_listas.R
import com.example.t3_listas.model.Pais

class AdaptadorPais(private var listaPaises: ArrayList<Pais>, private var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return listaPaises.size
    }

    override fun getItem(p0: Int): Pais {
        return listaPaises.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_lista, p2, false);
        // recupero el objeto con el que tengo que trbajar
        var pais: Pais = listaPaises.get(p0)

        // recuperar los elemento graficos doonde poner las cosas
        var textoNombre: TextView = view.findViewById(R.id.nombre_fila)
        var estrellaNombre: TextView = view.findViewById(R.id.estrella_fila)
        var escudoImagen: ImageView = view.findViewById(R.id.imagen_fila)
        var titulosNombre: TextView = view.findViewById(R.id.titulos_fila)

        textoNombre.setText(pais.nombre)
        estrellaNombre.setText(pais.estrella)
        escudoImagen.setImageResource(pais.imagen)
        titulosNombre.setText(pais.titulos.toString())

        return view;
    }
}