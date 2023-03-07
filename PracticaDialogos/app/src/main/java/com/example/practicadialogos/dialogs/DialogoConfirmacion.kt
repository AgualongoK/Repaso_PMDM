package com.example.practicadialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoConfirmacion: DialogFragment() {

    companion object{

        fun newInstance(mensaje:String): DialogoConfirmacion{
            val args = Bundle()
            args.putString("mensaje",mensaje)
            val dialogo = DialogoConfirmacion()
            dialogo.arguments = args
            return dialogo
        }
    }

    private lateinit var listener: OnDialogConfirmacion

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogConfirmacion
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireActivity())
        var mensaje = this.arguments?.get("mensaje")

        builder.setMessage(mensaje.toString())

        builder.setPositiveButton("Aceptar", { dialogInterface, i ->
            listener.onDialogConfirmacion(true)
        })
        builder.setNegativeButton("Cancelar", { dialogInterface, i ->
            listener.onDialogConfirmacion(false)
        })

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogConfirmacion{
        fun onDialogConfirmacion(boolean: Boolean)
    }
}