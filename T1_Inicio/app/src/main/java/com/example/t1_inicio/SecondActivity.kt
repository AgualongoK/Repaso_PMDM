package com.example.t1_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.log

class SecondActivity : AppCompatActivity() {

    lateinit var textoNombre: TextView
    lateinit var nombreRecuperado: String
    var edadRecuperada: Int = 0
    lateinit var imagen_android: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        instancias()
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {
        //textoNombre -> lo recuperado del Bundle
        textoNombre.setText(nombreRecuperado)
        Log.v("datos recuperados", edadRecuperada.toString())
        imagen_android.setImageResource(R.drawable.androide2)
    }

    private fun instancias() {
        textoNombre = findViewById(R.id.texto_nombre)
        imagen_android = findViewById(R.id.imagen_android)
    }

    private fun recuperarDatos(){
        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre","valor x defecto").toString()
        edadRecuperada = bundleRecuperado?.getInt("edad",18)?:0
    }
}