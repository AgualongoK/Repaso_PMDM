package com.example.practicadialogos.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos.R
import java.util.*

class DialogoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendarioActual: Calendar = Calendar.getInstance()
        val anio = calendarioActual.get(Calendar.YEAR)
        val dia = calendarioActual.get(Calendar.DATE)
        val mes = calendarioActual.get(Calendar.MONTH)

        val dialogoFecha = DatePickerDialog(requireContext(), requireContext() as DatePickerDialog.OnDateSetListener, anio, mes, dia)

        return dialogoFecha
    }
}