package com.example.t7_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.t7_fragments.databinding.ActivityMainBinding
import com.example.t7_fragments.fragments.FragmentDos
import com.example.t7_fragments.fragments.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias();

    }

    private fun instancias() {
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_f1 -> {
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id, FragmentUno())
                ft.commit()
            }
            R.id.boton_f2 -> {
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id, FragmentDos())
                ft.commit()
            }
        }
    }


}