package com.example.t3_spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_spinners.databinding.ActivityDetailBinding
import com.example.t3_spinners.databinding.ActivityMainBinding
import com.example.t3_spinners.model.Pais

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarDatos();
    }

    private fun recuperarDatos() {
        // intent--> bundle --> data
        var bundle = intent.extras;
        var equipo: Pais = bundle!!.getSerializable("equipo") as Pais
        binding.tituloDetalle.setText(equipo.numeroTitulos.toString());
        binding.estrellaDetalle.setText(equipo.estrella.toString())
        binding.nombreDetalle.setText(equipo.nombre.toString())
        binding.imagenDetalle.setImageResource(equipo.imagen)
    }

    }
