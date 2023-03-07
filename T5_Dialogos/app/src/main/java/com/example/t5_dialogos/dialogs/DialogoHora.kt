package com.example.t5_dialogos.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R
import java.util.*

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendario = Calendar.getInstance()
        val hora = calendario.get(Calendar.HOUR_OF_DAY)
        val minutos = calendario.get(Calendar.MINUTE)
        val dialogo = TimePickerDialog(requireContext(), R.style.DialogoColores, requireContext() as OnTimeSetListener, hora, minutos,true)
        return dialogo
    }
}