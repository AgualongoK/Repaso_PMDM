package com.example.t4_listasrecycler.adapter

import android.content.Context
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t4_listasrecycler.R
import com.example.t4_listasrecycler.model.Usuario

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context) : RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false) // xml -> con aspecto de cada fila
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre) // en el textview del xml
        holder.textoApellido.setText(usuarioActual.apellido) // en el textview del xml
        holder.imagenUsuario.setImageResource(usuarioActual.imagen) // en el textview del xml
    }

    override fun getItemCount(): Int {
        // tamanio de la lista
        return lista.size
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView){

        var textoNombre: TextView;
        var textoApellido: TextView;
        var imagenUsuario: ImageView;
        var constraintLayout : ConstraintLayout;

        init{
            constraintLayout = itemView.findViewById(R.id.constraint_general);
            textoApellido = itemView.findViewById(R.id.apellido_item)
            textoNombre = itemView.findViewById(R.id.nombre_item)
            imagenUsuario = itemView.findViewById(R.id.imagen_item)
        }
    }
}