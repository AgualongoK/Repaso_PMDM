package com.example.t1_inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

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


        // Gestión de un botón simple
        /*botonPulsar.setOnClickListener({
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

         */

        botonPulsar.setOnClickListener(this)
        botonPasar.setOnClickListener(this)
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

    override fun onClick(p0: View?) {
        //Snackbar.make(p0!!, "Pulsado botón", Snackbar.LENGTH_SHORT).show()
        when(p0!!.id){
            R.id.boton_pulsar->{
                if(!campoTexto.text.isEmpty()){
                    val texto = campoTexto.text;
                    textoSaludo.setText(texto)
                    campoTexto.setText("")
                }else{
                    Toast.makeText(applicationContext, "Faltan datos", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.boton_pasar->{
                var notificacion=
                    Snackbar.make(p0!!, "Snack completado",Snackbar.LENGTH_INDEFINITE)
                    notificacion.setAction("Seguro que quieres cambiar de activity", {
                        // pasar de activity
                        // intent -> accion de pasar de pantalla (acciones)
                        var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                        startActivity(intent)
                        // metodo que hace que la pantalla anterior NO quede en segundo plano
                        //finish()

                        // bundle -> sirve para pasar datos entre activities
                        var datos: Bundle = Bundle()
                        datos.putString("nombre",campoTexto.text.toString())
                        datos.putInt("edad", 30)
                        intent.putExtras(datos)
                        startActivity(intent)
                    })
                notificacion.show();
            }
        }
    }
}