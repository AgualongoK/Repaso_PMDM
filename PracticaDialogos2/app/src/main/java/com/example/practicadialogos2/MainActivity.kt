package com.example.practicadialogos2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicadialogos2.adapters.AdaptadorTrbajadores
import com.example.practicadialogos2.databinding.ActivityMainBinding
import com.example.practicadialogos2.dialogs.DialogDetalles
import com.example.practicadialogos2.model.Trabajador
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorTrbajadores.OnDialogRecycler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorTrabajadores: AdaptadorTrbajadores


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias();
        acciones();
    }

    private fun acciones() {
        binding.botonGuardar.setOnClickListener {
            adaptadorTrabajadores.anadirTrabajador(
                Trabajador(
                binding.editNombre.text.toString(),
                binding.editApellidos.text.toString(),
                binding.editCorreo.text.toString(),
                binding.editEdad.text.toString(),
                binding.spinnerPuesto.selectedItem.toString()))
        }
    }


    private fun instancias() {
        val adapterSpinner = ArrayAdapter.createFromResource(this, R.array.puestosTrabajo, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        binding.spinnerPuesto.adapter = adapterSpinner

        adaptadorTrabajadores = AdaptadorTrbajadores(ArrayList(), this)
        binding.recyclerTrabajadores.adapter = adaptadorTrabajadores
        binding.recyclerTrabajadores.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDialogRecycler(trabajador: Trabajador) {
        DialogDetalles.newInstance(trabajador.nombre, trabajador.apellidos, trabajador.correo, trabajador.edad, trabajador.puesto).show(supportFragmentManager, null);
    }
}