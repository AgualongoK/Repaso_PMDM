package com.example.t3_spinners.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t3_spinners.R
import com.example.t3_spinners.model.Pais

class AdaptadorPersonalizado(var listaElementos: ArrayList<Pais>, var contexto: Context): BaseAdapter() {

    override fun getCount(): Int {
        // retorna el nº de elementos que el spinner tiene que pitnar
        return listaElementos.size;
    }

    override fun getItem(position: Int): Any {
        // retorna el elemento que esta en una posicion indiciada como parametro
        return listaElementos.get(position)
    }

    override fun getItemId(position: Int): Long {
        // retorna el long asociado a un elemento que esta en una posicion indiciada como parametro
        return position.toLong();
    }

    fun agregarPais(pais: Pais){
        listaElementos.add(pais)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // retorna el view (fila) ya rellena con los datos que estan en una posicion indicada
        // para poder rellenar la fila -> XML
        var vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_spinner, parent, false);

        var nombre: TextView = vista.findViewById(R.id.texto_fila)
        var imagen: ImageView = vista.findViewById(R.id.imagen_fila)

        var elemento = listaElementos.get(position);

        nombre.text = elemento.nombre;
        imagen.setImageResource(elemento.imagen)

        return vista;
    }
}