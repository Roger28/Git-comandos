package com.example.android.gitcomandos.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.gitcomandos.db.entity.Comando;
import com.example.android.gitcomandos.repository.ComandoRepository;

import java.util.List;

/**
 * Quinta classe a ser criada
 * Esta classe é a intermediaria entre o repositório e as activities/fragments
 * Ela é responsável por atualizar a UI e enviar novos dados para o repositório
 * Remove toda responsabilidade da activity/fragmento
 **/

public class ComandoViewModel extends AndroidViewModel {

    // instancia do repositorio
    private ComandoRepository repository;
    // lista de objetos observados (LiveData)
    private LiveData<List<Comando>> allComandos;

    public ComandoViewModel(@NonNull Application application) {
        super(application);
        // recebe a instancia do repositório
        this.repository = new ComandoRepository(application);

        // preenche a lista com o conteúdo que posteriormente irá ser mostrada na UI através do adapter
        this.allComandos = this.repository.getAllComandos();
    }

    // retorna os conteúdos
    public LiveData<List<Comando>> getAllComandos() {
        return this.allComandos;
    }
}
