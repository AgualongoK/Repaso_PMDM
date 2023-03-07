package com.example.practicadialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.DialogFragment

class DialogoMult: DialogFragment() {

    private lateinit var listener: OnDialogMult

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogMult
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val listaAsignaturas = arrayOf("PMDP","DI","AD","SGE","EIE","ING")
        val asignaturasEscogidas = ArrayList<String>()

        builder.setTitle("¿De cuántas asignaturas te has evaluado?")

        builder.setMultiChoiceItems(listaAsignaturas,null){_, posicion, boolean ->
            if(boolean){
                asignaturasEscogidas.add(listaAsignaturas[posicion])
            }else{
                asignaturasEscogidas.remove(listaAsignaturas[posicion])
            }}

            builder.setPositiveButton("Aceptar", {_, _ ->
               listener.OnDialogMult(asignaturasEscogidas)
            })

            builder.setNegativeButton("Cancelar", {_, _ ->
                dismiss()
            })

           return builder.create()
        }

    interface OnDialogMult{
        fun OnDialogMult(lista: ArrayList<String>)
    }
}
