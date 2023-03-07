package com.example.practicadialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos.R
import com.example.practicadialogos.model.Usuario

class DialogoResumen: DialogFragment() {

    companion object{
        fun newInstance(nombreCompleto: String, hora: String, fecha: String, asignatura: String, nota: String): DialogoResumen{
            val args = Bundle()
            args.putString("nombreCompleto", nombreCompleto)
            args.putString("hora", hora)
            args.putString("fecha", fecha)
            args.putString("asignatura", asignatura)
            args.putString("nota", nota)

            val dialogo = DialogoResumen()
            dialogo.arguments = args

            return dialogo
        }
    }

    private lateinit var textNombreCompleto: TextView
    private lateinit var textHora: TextView
    private lateinit var textFecha: TextView
    private lateinit var textAsignatura: TextView
    private lateinit var textNota: TextView
    private lateinit var botonCerrar: Button
    private lateinit var vista: View
    private lateinit var listener: OnDialogResumen

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogResumen
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_resumen, null)
        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    private fun instancias() {
        textNombreCompleto = vista.findViewById(R.id.text_nombre_completo)
        textHora = vista.findViewById(R.id.text_hora)
        textFecha = vista.findViewById(R.id.text_fecha)
        textAsignatura = vista.findViewById(R.id.text_asignaturas)
        textNota = vista.findViewById(R.id.text_nota)
        botonCerrar = vista.findViewById(R.id.boton_cerrar)
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        textNombreCompleto.text = this.arguments?.get("nombreCompleto").toString()
        textHora.text = this.arguments?.get("hora").toString()
        textFecha.text = this.arguments?.get("fecha").toString()
        textAsignatura.text = this.arguments?.get("asignatura").toString()
        textNota.text = this.arguments?.get("nota").toString()

        botonCerrar.setOnClickListener{
            dismiss()
        }
    }

    interface OnDialogResumen{
        fun onDialogResumen()
    }
}