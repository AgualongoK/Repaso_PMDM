package com.example.t3_listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.t3_listas.adapter.AdaptadorPais
import com.example.t3_listas.databinding.ActivityMainBinding
import com.example.t3_listas.model.Pais
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSencillo: ArrayAdapter<Pais>
    lateinit var listaPaises: ArrayList<Pais>
    private lateinit var adaptadorComplejo: AdaptadorPais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        asociarDatos();
        acciones();
    }

    private fun acciones() {
        binding.listaPaises.setOnItemClickListener { parent, view, position, id ->
            var pais: Pais = adaptadorComplejo.getItem(position)
            Snackbar.make(view,"Número de títulos ${pais.titulos}", Snackbar.LENGTH_SHORT).show();
        }
    }

    private fun asociarDatos() {
        binding.listaPaises.adapter = adaptadorComplejo;
    }

    private fun instancias() {
        listaPaises = ArrayList();
        listaPaises.add((Pais("España",R.drawable.espania,1,"Morata")))
        listaPaises.add((Pais("Brasil",R.drawable.brasil,5,"Neymar")))
        listaPaises.add((Pais("Alemania",R.drawable.alemania,4,"Kroos")))
        listaPaises.add((Pais("Francia",R.drawable.francia,2,"Mbappe")))
        listaPaises.add((Pais("Qatar",R.drawable.qatar,0,"Abdullah")))
        listaPaises.add((Pais("Ecuador",R.drawable.ecuador,1,"Valencia")))

        //adaptadorSencillo = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,listaPaises)
        //adaptadorSencillo.notifyDataSetChanged();

        adaptadorComplejo = AdaptadorPais(listaPaises, applicationContext)
    }
}