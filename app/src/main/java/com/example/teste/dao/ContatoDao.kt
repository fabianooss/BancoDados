package com.example.teste.dao

import androidx.room.*
import com.example.teste.domain.Contato

@Dao
interface ContatoDao {

    @Insert
    fun inserir(contato: Contato)

    @Insert
    fun inserir(contatos: List<Contato>)

    @Update
    fun update(contato: Contato)

    @Delete
    fun delete(contato: Contato)

    @Query("select * from Contato order by nome")
    fun findAll(): List<Contato>

    @Query("select * from Contato where id=:id")
    fun findById(id: Int): Contato




}