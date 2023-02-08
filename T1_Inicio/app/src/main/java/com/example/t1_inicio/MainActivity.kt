package com.example.t1_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView
    lateinit var campoTexto : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml + kt
        // Log.v("ciclo_vida","Método onCreate ejecutando")
        // cuando pulse el boton que ponga un texto en el textview
        campoTexto = findViewById(R.id.mensaje)
        botonPulsar =  findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida)

        botonPulsar.setOnClickListener({
            /*// textoSaludo.setText("Primera app completa")
            textoSaludo.setText(campoTexto.text)
            campoTexto.setText("")
            Log.v("ciclo_vida","Boton pulsado")*/

            if (!campoTexto.text.isEmpty()){
                textoSaludo.setText(campoTexto.text)
                campoTexto.setText("")
            }else{
                Log.v("avisos"," texto introducido vacío")
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","Metodo onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","Metodo onResume ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","Metodo onPause ejecutado")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","Metodo onPause ejecutado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","Metodo onDestroy ejecutado")
    }
}