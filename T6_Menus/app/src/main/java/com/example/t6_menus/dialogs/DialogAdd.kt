package com.example.t6_menus.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.t6_menus.R
import com.example.t6_menus.adapter.AdaptadorCiclo
import com.example.t6_menus.model.Ciclo

class DialogAdd: DialogFragment() {

    private lateinit var vista: View
    private lateinit var editSiglas: EditText
    private lateinit var editProfesor: EditText
    private lateinit var editNombre: EditText
    private lateinit var spinnerHoras: Spinner
    private lateinit var adaptadorHoras: ArrayAdapter<CharSequence>
    private lateinit var spinnerCiclo: Spinner
    private lateinit var adaptadorCiclo: AdaptadorCiclo
    private lateinit var spinnerCurso: Spinner
    private lateinit var adaptadorCurso: ArrayAdapter<CharSequence>
    private lateinit var botonAdd : Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.personalizado_add_dialogo, null)
        adaptadorHoras = ArrayAdapter.createFromResource(context, R.array.coleccion_horas, android.R.layout.simple_spinner_item)
        adaptadorCurso = ArrayAdapter.createFromResource(context, R.array.coleccion_curso, android.R.layout.simple_spinner_item)
        var listaCiclos = ArrayList<Ciclo>()
        listaCiclos.add(Ciclo("DAM", R.drawable.dam))
        listaCiclos.add(Ciclo("DAW", R.drawable.daw))
        listaCiclos.add(Ciclo("ASIR", R.drawable.asir))
        adaptadorCiclo = AdaptadorCiclo(context, listaCiclos)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        // declaro
        editSiglas = vista.findViewById(R.id.edit_siglas)
        editNombre = vista.findViewById(R.id.edit_nombre_asig)
        editProfesor = vista.findViewById(R.id.edit_nombre_prof)
        spinnerHoras = vista.findViewById(R.id.spinner_horas)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        botonAdd = vista.findViewById(R.id.boton_agregar_asig)

        adaptadorHoras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adaptadorCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerHoras.adapter = adaptadorHoras
        spinnerCiclo.adapter = adaptadorCiclo
        spinnerCurso.adapter = adaptadorCurso
    }

    override fun onResume() {
        super.onResume()
        // utilizo
    }
}