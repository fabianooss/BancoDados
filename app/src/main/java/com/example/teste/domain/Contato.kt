package com.example.teste.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato(val nome: String, val email: String, val fone: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}