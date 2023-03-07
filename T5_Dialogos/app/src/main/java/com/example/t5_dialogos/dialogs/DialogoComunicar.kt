package com.example.t5_dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoComunicar: DialogFragment() {

    private lateinit var nombre: String
    private lateinit var mensaje: String

    companion object {
        // tod0 lo declarado aqui es directamente accesible
        // 1º Crear metodo newInstance como parametro lo que va a recibir el dialogo
        // devuelve el objeto del tipo que quiere construir
        fun newInstance(nombre: String): DialogoComunicar {
            val dialogo = DialogoComunicar();

            // 2º Creo los argumentos con los datos que van en los parametros y se los pongo al cuadro
             val bundle = Bundle();
            bundle.putString("nombre", nombre);
            bundle.putString("mensaje", "Esto es un ejemplo de mensaje pasado");
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 3º// Recupero todos los argumentos que quiere utilizar
        this.nombre = this.arguments?.getString("nombre","sobre el tag") ?: "Sin nombre"
        this.mensaje = this.arguments?.getString("mensaje","sobre el tag")?: "Sin mensaje"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =  AlertDialog.Builder(requireContext())
        builder.setTitle(nombre)
        builder.setMessage(mensaje)

        return builder.create()
    }
}