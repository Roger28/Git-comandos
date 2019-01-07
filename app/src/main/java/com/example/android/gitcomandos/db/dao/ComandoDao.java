package com.example.android.gitcomandos.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.gitcomandos.db.entity.Comando;

import java.util.List;

/**
 * Segunda classe a ser criada
 *  Sempre colocar a anotação Dao para a interface que contém os métodos/queries pro seu objeto
 *  Sempre colocar a anotação para o seu respectivo método/query (@Insert, @Update, @Delete)
 *  LiveData é uma parte da arquitetura que implementa um observer, membro importantissímo para
 *  notificar a UI e atualizar o BD assincronamente.
 **/

@Dao // anotaçao obrigatória
public interface ComandoDao {

    // insere uma lista de objetos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Comando> comandos);

    // anotação query para busca no banco, pode-se criar qualquer tipo desde que seja vãlido
    @Query("SELECT * FROM comandos ORDER BY comando ASC")
    LiveData<List<Comando>> getAllComandos();
}
