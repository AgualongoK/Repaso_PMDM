package com.example.t8_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t8_firebase.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database("https://fir-ceskap-default-rtdb.firebaseio.com/")
        setContentView(binding.root)

        binding.botonCrear.setOnClickListener{
            auth.createUserWithEmailAndPassword("hola@gmail.com","Hola@123")
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        Snackbar.make(binding.botonCrear, "Usuario creado con exito", Snackbar.LENGTH_SHORT).show()
                    }else{
                        Snackbar.make(binding.botonCrear, "Error al crear usuario", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }

        binding.botonLogin.setOnClickListener{
            auth.signInWithEmailAndPassword("hola@gmail.com","Hola@123")
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        Snackbar.make(binding.botonLogin, "Usuario logeado con exito con identificador: " + auth.currentUser!!.uid, Snackbar.LENGTH_SHORT).show()
                    }else{
                        Snackbar.make(binding.botonLogin, "Error en el login del usuario", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }

        binding.botonCrearNodo.setOnClickListener{
            // crear la referencia
            database.getReference("ejemplo").setValue("Valor del nodo ejemplo")
            database.getReference("nodo_nuevo").child("ejemplo_hijo").child("nodo_agregar").setValue("Valor del nodo")
        }
    }
}