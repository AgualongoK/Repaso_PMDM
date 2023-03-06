package com.example.t3_spinners

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.t3_spinners.adaptadores.AdaptadorPersonalizado
import com.example.t3_spinners.databinding.ActivityMainBinding
import com.example.t3_spinners.model.Pais

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var arraySpinner : ArrayList<Pais>;
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado;
    lateinit var botonAgregar: Button;
    lateinit var pais: Pais;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        asociarDatos();
        //rellenarSpinner();
        //rellenarSpinnerPersonalizado();
        acciones();
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add(Pais("España", R.drawable.espania,1,"Morata"))
        arraySpinner.add(Pais("Brasil", R.drawable.brasil,5,"Neymar"))
        arraySpinner.add(Pais("Alemania", R.drawable.alemania,4,"Kroos"))
        arraySpinner.add(Pais("Francia", R.drawable.francia,2,"Mbappe"))
        arraySpinner.add(Pais("Qatar", R.drawable.qatar,0,"Abdullah"))
        arraySpinner.add(Pais("Ecuador", R.drawable.ecuador,0,"Valencia"))
        //adaptadorPersonalizado.notifyDataSetChanged()
    }

    private fun acciones() {
        binding.spinnerSimple.onItemSelectedListener = this;
        binding.spinnerComplejo.onItemSelectedListener = this;

        binding.botonAgregar.setOnClickListener{
            var pais = Pais("Croacia", R.drawable.croacia, 1, "Modric")
            adaptadorPersonalizado.agregarPais(pais)
        }

        binding.botonDetalle.setOnClickListener{
            // cambiar pantalla
            // pasando los datos del pais -> escudo, nombre, titulo, estrella
            var accionPasar: Intent = Intent(applicationContext, DetailActivity::class.java)
            // bundle -> pasar datos a otra activity
            var bundle = Bundle()
            /*
            bundle.putInt("imagen", pais.imagen)
            bundle.putInt("titulos", pais.numeroTitulos)
            bundle.putString("nombre", pais.nombre)
            bundle.putString("estrella", pais.estrella)*/
            bundle.putSerializable("equipo", pais);
            accionPasar.putExtras(bundle)
            startActivity(accionPasar)
        }
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList();
        //adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner);
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,R.array.paises, android.R.layout.simple_spinner_item)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // para rellenar un spinner complejo: lista + xml = adapter
        rellenarSpinnerPersonalizado()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner, applicationContext);

    }

    /*private fun rellenarSpinner() {
        // lista --> array o arrayList o un recurso-string
        arraySpinner.add("España")
        arraySpinner.add("Brasil")
        arraySpinner.add("Alemania")
        arraySpinner.add("Francia")
        arraySpinner.add("Qatar")
        arraySpinner.add("Ecuador")
    }*/

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0?.id){
            R.id.spinner_simple->{
                Toast.makeText(applicationContext, adaptadorSencillo.getItem(p2).toString(), Toast.LENGTH_SHORT).show()
            }
            R.id.spinner_complejo->{
               pais = adaptadorPersonalizado.getItem(p2) as Pais;
               binding.imagenPais.setImageResource(pais.imagen)
                binding.nombrePais.text = pais.nombre

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}