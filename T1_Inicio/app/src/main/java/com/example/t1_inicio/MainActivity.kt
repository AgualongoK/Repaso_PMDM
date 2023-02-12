package com.example.t1_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView
    lateinit var campoTexto : EditText
    lateinit var botonPasar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml + kt
        // Log.v("ciclo_vida","Método onCreate ejecutando")
        // cuando pulse el boton que ponga un texto en el textview
        campoTexto = findViewById(R.id.mensaje)
        botonPulsar =  findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida)
        botonPasar = findViewById(R.id.boton_pasar)

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

        // onClickListener --> recibe un View (elemento grafico), elemento que ha producido el evento
        botonPasar.setOnClickListener({view : View ->
            // Toast --> notificacion basica
            //Toast.makeText(applicationContext, "Toast completada", Toast.LENGTH_LONG).show()

                var notification = Snackbar.make(view,"Seguro que quieres cerrar la notificacion?",Snackbar.LENGTH_INDEFINITE)
                notification.setAction("Aceptar", {
                    notification.dismiss()
                })
                notification.show()
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