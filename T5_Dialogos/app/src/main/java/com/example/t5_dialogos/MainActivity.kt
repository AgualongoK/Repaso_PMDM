package com.example.t5_dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.t5_dialogos.databinding.ActivityMainBinding
import com.example.t5_dialogos.dialogs.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener, DialogoConfirmacion.OnDialogConfirmListener,
    DialogoLista.OnListaListener, DialogoListaSimple.OnListaSimpleListener,
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener{

    private lateinit var binding: ActivityMainBinding
    private var dialogoConfirm: DialogoConfirmacion;

    init {
        dialogoConfirm = DialogoConfirmacion()
        dialogoConfirm.funcionNula = {elemento ->
            if(elemento){
                Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones();

    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
        binding.botonListaSimple.setOnClickListener(this)
        binding.botonListaMultiple.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
        binding.botonComunicar.setOnClickListener(this)
        binding.botonHora.setOnClickListener(this)
        binding.botonFecha.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id -> {
                // saltar el cuadro de dialogo
                // show() parte del DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion();
                dialogoConfirmacion.show(supportFragmentManager, null);

            }
            binding.botonLista.id -> {
                val dialogoLista = DialogoLista();
                dialogoLista.show(supportFragmentManager,null)
            }
            binding.botonListaSimple.id -> {
                val dialogoListaSimple = DialogoListaSimple()
                dialogoListaSimple.show(supportFragmentManager, null)

            }
            binding.botonListaMultiple.id -> {
                val dialogoListaMultiple = DialogoMultiple();
                dialogoListaMultiple.show(supportFragmentManager,null)
            }
            binding.botonPersonalizado.id -> {
                val dialogoPersonalizado = DialogoPersonalizado();
                dialogoPersonalizado.show(supportFragmentManager, null)
            }
            binding.botonComunicar.id -> {
                // lanzar un cuadro dialogo con comunicacion
                DialogoComunicar.newInstance("Borja").show(supportFragmentManager, null)
            }
            binding.botonHora.id -> {
                DialogoHora().show(supportFragmentManager,null)

            }
            binding.botonFecha.id -> {
                var dialogoFecha: DialogoFecha = DialogoFecha();
                dialogoFecha.show(supportFragmentManager, null)
            }
        }
    }

    override fun onDialogoSelected(seleccionado: Boolean) {
        if(seleccionado){
            binding.textoConfirmacion.setText("Confirmado")
        }else{
            binding.textoConfirmacion.setText("Denegado")
        }
    }

    override fun onElementoListaSelected(elemento: String) {
        binding.listaConfirmacion.text = elemento
    }

    override fun onListaSelected(elemento: String) {
        binding.listaSimpleConfirmacion.text = elemento
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Snackbar.make(binding.root,"${p1} / ${p2+1} / ${p3}", Snackbar.LENGTH_SHORT).show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Snackbar.make(binding.root,"${p1} : ${p2}", Snackbar.LENGTH_SHORT).show()
    }
}