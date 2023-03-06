package com.example.calculadora

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding;
    private lateinit var editNumeros: EditText;
    private lateinit var botonUno: Button;
    private lateinit var botonDos: Button;
    private var botonTres: Button? = null;
    private var botonCuatro: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view : View = binding.root;
        setContentView(view)
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //instancias();
        acciones();

        if(resources.configuration.orientation== ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            //accionesLand();
        }
    }

    private fun accionesLand() {
        botonTres!!.setOnClickListener(this)
        botonCuatro!!.setOnClickListener(this)
    }

    private fun acciones() {
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres?.setOnClickListener(this)
        binding.botonCuatro?.setOnClickListener(this)
    }

    /*private fun instancias() {
        botonUno = findViewById(R.id.boton_uno);
        botonDos = findViewById(R.id.boton_dos);
        botonTres = findViewById(R.id.boton_tres);
        botonCuatro = findViewById(R.id.boton_cuatro);
        editNumeros = findViewById(R.id.edit_numeros);
    }*/

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_uno->{
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_dos->{
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_tres->{
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_cuatro->{
                binding.editNumeros.append((p0 as Button).text)
            }
        }
    }
}