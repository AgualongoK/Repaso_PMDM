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
import com.example.practicadialogos.model.Usuario

class DialogDatos: DialogFragment() {

    private lateinit var editNombre: EditText
    private lateinit var editApellido: EditText
    private lateinit var botonAceptar: Button
    private lateinit var contexto: Context
    private lateinit var vista: View
    private lateinit var listener: OnDialogDatos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogDatos
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_datos,null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    private fun instancias() {
        editNombre = vista.findViewById(R.id.edit_nombre)
        editApellido = vista.findViewById(R.id.edit_apellido)
        botonAceptar = vista.findViewById(R.id.boton_aceptar)
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        botonAceptar.setOnClickListener{
            var usuario:Usuario = (Usuario(editNombre.text.toString(),editApellido.text.toString()))
            listener.onDialogDatos(usuario)
            dismiss()
        }
    }

    interface OnDialogDatos{
        fun onDialogDatos(usuario: Usuario)
    }
}