package com.example.android.gitcomandos.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.android.gitcomandos.database.AppDataBase;
import com.example.android.gitcomandos.db.dao.ComandoDao;
import com.example.android.gitcomandos.db.entity.Comando;

import java.util.List;

/**
 * Quarta classe a ser criada
 *
 **/

public class ComandoRepository {

    // interface com as queries
    private ComandoDao comandoDao;
    // lista de objetos sendo observados (LiveData)
    private LiveData<List<Comando>> allComandos;

    public ComandoRepository(Application application) {
        // instancia a classe abstrata que se comunica com o banco
        AppDataBase appDataBase = AppDataBase.getInstance(application);

        //recebe a interface
        this.comandoDao = appDataBase.comandoDao();

        // preenche a lista com os dados vindo do banco
        this.allComandos = this.comandoDao.getAllComandos();
    }

    // retorna a lista com os dados
    public LiveData<List<Comando>> getAllComandos() {
        return this.allComandos;
    }

    /**
     * Reservado para futuras implementações, mantenha comentado...
     **/

//    private static ComandoRepository instance;

//    private final AppDataBase dataBase;

//    private MediatorLiveData<List<Comando>> mObservableCommands;

//    private ComandoRepository(final AppDataBase dataBase) {

    //        this.dataBase = dataBase;
    //        this.mObservableCommands = new MediatorLiveData<>();
    //
    //        mObservableCommands.addSource(this.dataBase.comandoDao().getAllComandos(),
    //                comandos -> {
    //                    if (dataBase.getDatabaseCreated().getValue() != null) {
    //                        mObservableCommands.postValue(comandos);
    //                    }
    //                });
    //    }
    //
    //    public static ComandoRepository getInstance(final AppDataBase dataBase){
    //        if(instance == null){
    //            synchronized (ComandoRepository.class){
    //                if(instance == null){
    //                    instance = new ComandoRepository(dataBase);
    //                }
    //            }
    //        }
    //        return instance;
    //    }
}
