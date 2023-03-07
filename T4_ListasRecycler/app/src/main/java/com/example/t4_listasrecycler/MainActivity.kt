package com.example.t4_listasrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t4_listasrecycler.adapter.AdaptadorUsuarios
import com.example.t4_listasrecycler.databinding.ActivityMainBinding
import com.example.t4_listasrecycler.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorUsuarios.OnRecyclerUsuarioListener{

    private lateinit var binding: ActivityMainBinding;
    private lateinit var listaUsuarios: ArrayList<Usuario>
    private lateinit var listaUsuariosFiltrada: ArrayList<Usuario>
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //lista con todos los usuarios que se llaman borja y su telefono es 1234
        listaUsuariosFiltrada = listaUsuarios.filter { usuario -> usuario.nombre == "Borja" && usuario.telefono == 1234 } as ArrayList<Usuario>
        adaptadorUsuarios.cambiarDeLista(listaUsuariosFiltrada)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias();
        configurarRecycler();
        acciones();

        binding.listaRecycler
    }

    private fun acciones() {

    }

    private fun configurarRecycler() {
        // 2 poner un adaptador dentro del recycler
        binding.listaRecycler.adapter = adaptadorUsuarios;

        // 3 poner un layout dentro del recycler --> linear o grid
        // la propiedad LinearLayoutManager.VERTICAL indica el tipo de scroll (vertical u horizontal)
        //binding.listaRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        binding.listaRecycler.layoutManager = GridLayoutManager(this, 2);


    }

    private fun instancias() {
        //  1 tener una lista de datos a representar
        listaUsuarios = ArrayList();
        listaUsuarios.add(Usuario("Borja","Martin",1234,R.drawable.hombre))
        listaUsuarios.add(Usuario("Angel","Villalobos",2345,R.drawable.hombre))
        listaUsuarios.add(Usuario("Sofia","Martinez",6789,R.drawable.mujer))
        listaUsuarios.add(Usuario("Angelica","Castañeda",1456,R.drawable.mujer))
        listaUsuarios.add(Usuario("Ricardo","Santini",7854,R.drawable.hombre))
        listaUsuarios.add(Usuario("Juan","Sanchez",4673,R.drawable.hombre))
        listaUsuarios.add(Usuario("Steven","Pineda",9273,R.drawable.hombre))
        listaUsuarios.add(Usuario("Naiara","Montesinos",7392,R.drawable.mujer))
        listaUsuarios.add(Usuario("Julieta","Roseda",9284,R.drawable.mujer))
        listaUsuarios.add(Usuario("Austin","Smith",8367,R.drawable.hombre))

        adaptadorUsuarios = AdaptadorUsuarios(listaUsuarios, this);

        adaptadorUsuarios.funcionComunicar = { Snackbar.make(binding.root, it.nombre, Snackbar.LENGTH_SHORT).show() }
    }

    override fun onUsuarioSelected(usuario: Usuario) {
        Snackbar.make(binding.root, "Comunicado ${usuario.nombre}", Snackbar.LENGTH_SHORT).show()
    }

    override fun onUsuarioSelected(usuario: Usuario, posicion: Int) {
        Snackbar.make(binding.root, "Comunicado ${usuario.nombre} ${posicion}", Snackbar.LENGTH_SHORT).show()
    }


}