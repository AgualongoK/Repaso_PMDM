package com.example.practicadialogos

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.practicadialogos.databinding.ActivityMainBinding
import com.example.practicadialogos.dialogs.*
import com.example.practicadialogos.model.Usuario

class MainActivity : AppCompatActivity(), OnTimeSetListener, OnDateSetListener, DialogDatos.OnDialogDatos,
    DialogoConfirmacion.OnDialogConfirmacion, DialogoMult.OnDialogMult, DialogoNota.OnDialogNota,
    DialogoResumen.OnDialogResumen{

    private lateinit var binding: ActivityMainBinding
    private var hora = 0
    private var mins = 0
    private var anio = 0
    private  var mes = 0
    private var dia = 0
    private lateinit var usuario: Usuario
    private var mensaje: String = ""
    private lateinit var listaAsignaturas: ArrayList<String>
    private lateinit var numeroAsignaturas: String
    private lateinit var notaMedia: String
    private lateinit var nombreCompleto: String
    private lateinit var horaCompleta: String
    private lateinit var fechaCompleta: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun instancias() {
    }

    private fun acciones() {
        binding.botonInicar.setOnClickListener{
            DialogoHora().show(supportFragmentManager,null)
        }
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hora = hourOfDay
        mins = minute
        DialogoFecha().show(supportFragmentManager,null)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth
        DialogDatos().show(supportFragmentManager,null)
    }

    override fun onDialogDatos(usuario: Usuario) {
        this.usuario = usuario
        mensaje = "Buenos días ${usuario.nombre} ${usuario.apellido}, vas a registrar una respuesta el ${dia}/${mes} a las ${hora}:${mins} \n" +
                "\n¿Estás seguro que quieres continuar?";
        val dialogoConfirmacion = DialogoConfirmacion.newInstance(mensaje)
        dialogoConfirmacion.show(supportFragmentManager,null)
    }

    override fun onDialogConfirmacion(boolean: Boolean) {
        if(boolean){
            DialogoMult().show(supportFragmentManager,null)
        }
    }

    override fun OnDialogMult(lista: ArrayList<String>) {
        listaAsignaturas = lista
        numeroAsignaturas = listaAsignaturas.size.toString()
        DialogoNota().show(supportFragmentManager,null)
    }

    override fun onDialogNota(nota: String) {
        notaMedia = nota
        nombreCompleto = "${usuario.nombre} ${usuario.apellido}"
        horaCompleta = "${hora}:${mins}"
        fechaCompleta = "${dia}/${mes}/${anio}"

        val dialogoResumen = DialogoResumen.newInstance(nombreCompleto, horaCompleta, fechaCompleta, numeroAsignaturas, notaMedia)
        dialogoResumen.show(supportFragmentManager,null)
    }

    override fun onDialogResumen() {
        TODO("Not yet implemented")
    }
}