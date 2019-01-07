package com.example.android.gitcomandos;

import android.app.Application;

import com.example.android.gitcomandos.database.AppDataBase;
import com.example.android.gitcomandos.repository.ComandoRepository;

public class BasicApp extends Application {

    /**
     * Reservado para futura implementações, mantenha comentado...
     **/

//    private AppExecutors mAppExecutors;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        this.mAppExecutors = new AppExecutors();
//    }

//    /**
//     * Cria uma única instância do banco.
//     **/
//    public AppDataBase getDataBase(){
//        return AppDataBase.getInstance(this, mAppExecutors);
//    }
//
//    /**
//     * Cria uma única instância do repositório.
//     **/
//    public ComandoRepository getRepository(){
//        return ComandoRepository.getInstance(getDataBase());
//    }
}
