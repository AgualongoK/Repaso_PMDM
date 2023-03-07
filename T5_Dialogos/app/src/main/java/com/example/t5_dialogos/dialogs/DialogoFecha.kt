package com.example.t5_dialogos.dialogs

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DialogoFecha: DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // builder
        // settear elementos del builder
        // return builder.create
        val calendarioActual: Calendar = Calendar.getInstance()
        val anio = calendarioActual.get(Calendar.YEAR)
        val dia = calendarioActual.get(Calendar.DATE)
        val mes = calendarioActual.get(Calendar.MONTH)

        val dialogoFecha = DatePickerDialog(requireContext(), requireContext() as OnDateSetListener, anio, mes, dia)

        return dialogoFecha
    }
}