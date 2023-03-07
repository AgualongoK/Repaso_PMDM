package com.example.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.t6_menus.adapter.AdaptadorAsignaturas
import com.example.t6_menus.databinding.ActivityMainBinding
import com.example.t6_menus.dialogs.DialogAdd
import com.example.t6_menus.model.Asignatura
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorAsignaturas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // camabios en el toolbar
        supportActionBar?.title = "Cambio en el titulo"

        adaptador = AdaptadorAsignaturas(ArrayList<Asignatura>(), this)
        binding.recyclerAsignaturas.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //binding.recyclerAsignaturas
        //logica
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.main_menu, menu)
        menuInflater.inflate(R.menu.menu_recycler, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /* PULSACIONES DE MAIN_MENU
        var texto: String = ""
        when(item.itemId){
            R.id.menu_op1 -> {
                texto = "Elemento 1"
            }
            R.id.menu_op2 -> {
                texto = "Elemento 2"
            }
            R.id.menu_op1_1 -> {
                texto = "Elemento 1_1"
            }
            R.id.menu_op1_2 -> {
                texto = "Elemento 1_2"
            }
            else -> {
                texto = "Elemento No identificado"
            }
        }

        Snackbar.make(binding.root,texto, Snackbar.LENGTH_SHORT).show()*/

        // PULSACIONES MENU_RECYCLER

        when(item.itemId){
            R.id.menu_add -> {
                DialogAdd().show(supportFragmentManager,null)
                // agregar algo al recycler --> adaptador

            }R.id.menu_clear -> {
                adaptador.clarAsignaturas()
            }
        }
        return true
    }
}