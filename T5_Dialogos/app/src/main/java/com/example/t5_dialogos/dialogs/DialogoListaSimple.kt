package com.example.t5_dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoListaSimple: DialogFragment() {

    private lateinit var listener: OnListaSimpleListener;
    private lateinit var elementoSeleccionado: String;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListaSimpleListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Simple 1", "Simple 2","Simple 3")

        builder.setTitle("Titulo de lista simple")

        builder.setSingleChoiceItems(elementos, 0,
            DialogInterface.OnClickListener { dialogInterface, i ->
            elementoSeleccionado = elementos[i]
        })

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener
        {dialog, i ->
            // como comunico la seleccion a la activity
            listener.onListaSelected(elementoSeleccionado)
        })

        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener
        {dialog, which ->
            // como comunico la seleccion a la activity
            dismiss()
        })
        return builder.create()
    }

    interface OnListaSimpleListener{
        fun onListaSelected(elemento:String)
    }
}