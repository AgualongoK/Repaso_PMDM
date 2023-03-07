package com.example.practicadialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos.R

class DialogoNota: DialogFragment() {

    private lateinit var editNota: EditText
    private lateinit var botonAceptar: Button
    private lateinit var vista: View
    private lateinit var listener: OnDialogNota

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogNota
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_nota, null)
        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    private fun instancias() {
        editNota = vista.findViewById(R.id.edit_nota)
        botonAceptar = vista.findViewById(R.id.boton_aceptar_nota)
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        botonAceptar.setOnClickListener{
            var nota:String = editNota.text.toString()
            listener.onDialogNota(nota)

            dismiss()
        }
    }

    interface OnDialogNota{
        fun onDialogNota(nota:String)
    }
}