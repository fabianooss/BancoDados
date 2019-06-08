package com.example.teste.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.teste.domain.Contato

@Database(entities = arrayOf(Contato::class), exportSchema = true, version = 2)
abstract class Database() : RoomDatabase(){

    abstract fun contatoDao(): ContatoDao

    companion object {

        private var instance: com.example.teste.dao.Database? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table contato add column fone text not null default ''")
            }

        }

        fun getInstance(context: Context): com.example.teste.dao.Database {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    com.example.teste.dao.Database::class.java,
                    "dados"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return instance as com.example.teste.dao.Database
        }

    }

}