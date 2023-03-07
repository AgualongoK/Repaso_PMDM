package com.example.practicadialogos.model

class Usuario(var nombre:String, var apellido:String) {

    override fun toString(): String {
        return nombre + " " + apellido
    }
}