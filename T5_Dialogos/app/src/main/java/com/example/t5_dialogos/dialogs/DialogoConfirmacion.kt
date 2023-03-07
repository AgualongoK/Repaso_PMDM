package com.example.t5_dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R

class DialogoConfirmacion: DialogFragment() {
    // PASOS FUNCION CALL-BACK
    // crear interfaz
    // crear objeto de interfaz
    // inicializo el objeto --> listener = context
        // llamo al método desde la pulsacion o accion
    // implementarla en el destino
    // utilizo los métodos implementados

    private lateinit var listener: OnDialogConfirmListener
    var funcionNula: ((Boolean)->Unit)? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogConfirmListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // Builder --> creador
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // Titulo
        builder.setTitle("Título del cuadro de confirmación")
        //builder.setTitle(R.string.titulo_dialogo)
        //builder.setTitle(requireContext().resources.getString(R.string.titulo_dialogo))

        // Mensaje
        builder.setMessage("¿Estás seguro que quieres continuar el proceso?")
        
        // Botones
        builder.setPositiveButton("OK"){ dialogInterface, i ->
            funcionNula?.invoke(true)
            //listener.onDialogoSelected(true);
            Toast.makeText(requireContext(), "Pulsado positivo", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("CANCELAR"){ dialogInterface, i ->
            funcionNula?.invoke(false)
            //listener.onDialogoSelected(false);
            Toast.makeText(requireContext(), "Pulsado negativo", Toast.LENGTH_SHORT).show()
        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogConfirmListener{
        fun onDialogoSelected(seleccionado : Boolean)
    }
}