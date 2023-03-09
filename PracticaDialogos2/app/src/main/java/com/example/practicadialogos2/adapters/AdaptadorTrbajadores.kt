package com.example.practicadialogos2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practicadialogos2.R
import com.example.practicadialogos2.model.Trabajador

class AdaptadorTrbajadores(var lista: ArrayList<Trabajador>, var contexto: Context): RecyclerView.Adapter<AdaptadorTrbajadores.MyHolder>() {

    private lateinit var listener: OnDialogRecycler

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        listener = contexto as OnDialogRecycler
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var trabajadorActual: Trabajador = lista.get(position)
        holder.textNombre.setText(trabajadorActual.nombre)
        holder.textApellidos.setText(trabajadorActual.apellidos)

        holder.layoutItem.setOnClickListener{
            listener.onDialogRecycler(trabajadorActual)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun anadirTrabajador(trabajador: Trabajador){
        this.lista.add(trabajador)
        notifyDataSetChanged()
    }

    inner class MyHolder(var itemView: View): ViewHolder(itemView){
        var layoutItem: LinearLayout
        var textNombre: TextView
        var textApellidos: TextView

        init {
            textNombre = itemView.findViewById(R.id.text_nombre)
            textApellidos = itemView.findViewById(R.id.text_apellido)
            layoutItem = itemView.findViewById(R.id.layout_item)
        }
    }

    interface OnDialogRecycler{
        fun onDialogRecycler(trabajador: Trabajador)
    }
}
