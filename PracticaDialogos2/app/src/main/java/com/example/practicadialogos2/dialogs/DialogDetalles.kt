package com.example.practicadialogos2.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos2.R

class DialogDetalles: DialogFragment() {

    private lateinit var vista: View
    private lateinit var textNombre: TextView
    private lateinit var textApellidos: TextView
    private lateinit var textCorreo: TextView
    private lateinit var textEdad: TextView
    private lateinit var textPuestoTrabajo: TextView
    private lateinit var botonCerrar: Button

    private lateinit var nombre: String
    private lateinit var apellidos: String
    private lateinit var correo: String
    private lateinit var edad: String
    private lateinit var puestoTrabajo: String

    companion object{
        fun newInstance(nombre:String, apellidos: String, correo:String, edad: String, puestoTrabajo:String): DialogDetalles{
            val dialogo = DialogDetalles()
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("apellidos",apellidos)
            bundle.putString("correo",correo)
            bundle.putString("edad",edad)
            bundle.putString("puesto",puestoTrabajo)
            dialogo.arguments = bundle

            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.nombre = this.arguments?.getString("nombre")?: "Null"
        this.apellidos = this.arguments?.getString("apellidos")?: "Null"
        this.correo = this.arguments?.getString("correo")?: "Null"
        this.edad = this.arguments?.getString("edad")?: "Null"
        this.puestoTrabajo = this.arguments?.getString("puesto")?: "Null"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_detalles, null)
        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    private fun instancias() {
        textNombre = vista.findViewById(R.id.dialog_nombre)
        textApellidos = vista.findViewById(R.id.dialog_apellidos)
        textCorreo = vista.findViewById(R.id.dialog_correo)
        textEdad = vista.findViewById(R.id.dialog_edad)
        textPuestoTrabajo = vista.findViewById(R.id.dialog_puesto)
        botonCerrar = vista.findViewById(R.id.boton_cerrar)

        textNombre.text = "$nombre"
        textApellidos.text = "$apellidos"
        textCorreo.text = "$correo"
        textEdad.text = "$edad"
        textPuestoTrabajo.text = "$puestoTrabajo"
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        botonCerrar.setOnClickListener{
            dismiss()
        }
    }
}