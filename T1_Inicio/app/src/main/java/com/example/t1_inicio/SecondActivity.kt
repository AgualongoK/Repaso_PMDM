package com.example.t1_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textoNombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        instancias()
    }

    private fun instancias() {
        textoNombre = findViewById(R.id.texto_nombre)
    }

}