package com.example.t4_listasrecycler.adapter

import android.content.Context
import android.provider.SyncStateContract.Constants
import android.util.Log
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
import com.google.android.material.snackbar.Snackbar

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context) : RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>(){

    // Funcion vacia para comunicar
    var funcionComunicar: ((usuario:Usuario) -> Unit)? = null

    private lateinit var listener: OnRecyclerUsuarioListener

    init {
        listener = contexto as OnRecyclerUsuarioListener
    }

    fun cambiarDeLista(lista: ArrayList<Usuario>){
        lista.clear();
        this.lista = lista;
        notifyItemInserted(lista.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false) // xml -> con aspecto de cada fila
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre) // en el textview del xml
        holder.textoApellido.setText(usuarioActual.apellido) // en el textview del xml
        holder.imagenUsuario.setImageResource(usuarioActual.imagen) // en el textview del xml

        holder.constraintLayout.setOnClickListener{}

        holder.textoNombre.setOnClickListener{
            // comunicar el usuario
            listener.onUsuarioSelected(usuarioActual)
        }

        //holder.textoNombre.setOnClickListener{ Log.v("lista", "Texto nombre pulsado")}
        holder.textoApellido.setOnClickListener{ Log.v("lista", "Texto apellido pulsado")}
        /*holder.imagenUsuario.setOnClickListener{
            Snackbar.make(holder.imagenUsuario, "Pulsada imagen", Snackbar.LENGTH_SHORT).show()
        }*/

        holder.imagenUsuario.setOnLongClickListener{

            listener.onUsuarioSelected(usuarioActual,position)

            return@setOnLongClickListener true
        }

        funcionComunicar?.invoke(usuarioActual)
    }

    override fun getItemCount(): Int {
        // tamanio de la lista
        return lista.size
    }

    interface OnRecyclerUsuarioListener{
        fun onUsuarioSelected(usuario: Usuario)
        fun onUsuarioSelected(usuario: Usuario, posicion: Int)
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