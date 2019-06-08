package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teste.dao.Database
import com.example.teste.domain.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun executar(v: View) {
        GlobalScope.launch(Dispatchers.Main) {
            val contatos = withContext(Dispatchers.IO) {
                val contatoDao = Database.getInstance(this@MainActivity).contatoDao()
                val contato = Contato("xxxx", "xxxx", "xxxxx")
                contatoDao.inserir(contato)
                contatoDao.findAll()
            }
            Toast.makeText(this@MainActivity, "Contatos: ${contatos}",
                Toast.LENGTH_LONG).show()
        }

        Toast.makeText(this, "Fim do método",
            Toast.LENGTH_SHORT).show()


    }
}
