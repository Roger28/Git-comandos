package com.example.android.gitcomandos.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 *  Primeira classe a ser criada
 *  Esta classe representa o seu objeto que será uma coluna no banco.
 **/

@Entity(tableName = "comandos")//seta o nome para sua tabela
public class Comando {

    /**
     * Lib Room
     * As anotações acima de cada atributo da classe são essencias para o Room identificar suas tabelas no banco.
     * Obrigatório declarar getters e setters em alguns casos.
     **/

    @PrimaryKey(autoGenerate = true)//gera a PK automaticamente
    @ColumnInfo(name = "id")// seta o nome da sua coluna
    private int id;

    @ColumnInfo(name = "comando")// seta o nome da sua coluna
    private String comando;

    @ColumnInfo(name = "descricao")// seta o nome da sua coluna
    private String descricao;

    public Comando(String comando, String descricao) {
        this.comando = comando;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
