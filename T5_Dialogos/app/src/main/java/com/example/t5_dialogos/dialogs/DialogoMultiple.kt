package com.example.t5_dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoMultiple: DialogFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Multiple 1", "Multiple 2", "Multiple 3")

        builder.setTitle("Titulo lista multiple")

        builder.setMultiChoiceItems(elementos, null,
            {dialogo, posicion, boolean ->
                Log.v("dialogos", "${posicion.toString()} ${boolean.toString()}")
            })

        return builder.create()
    }
}