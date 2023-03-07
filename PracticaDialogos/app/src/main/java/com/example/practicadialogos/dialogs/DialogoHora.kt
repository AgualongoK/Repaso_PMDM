package com.example.practicadialogos.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos.R
import java.util.*

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendario = Calendar.getInstance()
        val hora = calendario.get(Calendar.HOUR_OF_DAY)
        val minutos = calendario.get(Calendar.MINUTE)
        val dialogo = TimePickerDialog(requireContext(), requireContext() as TimePickerDialog.OnTimeSetListener, hora, minutos,true)
        return dialogo
    }
}