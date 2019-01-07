package com.example.android.gitcomandos;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.gitcomandos.db.entity.Comando;
import com.example.android.gitcomandos.ui.ComandoAdapter;
import com.example.android.gitcomandos.viewmodel.ComandoViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Para melhor entendimento olhar as classes na seguinte ordem
 * - Comando
 * - ComandoDao
 * - AppDataBase
 * - ComandoRepository/DataGenerator
 * - ComandoViewModel
 * - ComandoAdapter
 * - Main
 *
 *  Se acrescentar algo, comente...
 **/

public class MainActivity extends AppCompatActivity {
    private ComandoAdapter mAdapter;
    private List<Comando> originalList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originalList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new ComandoAdapter();
        mRecyclerView.setAdapter(mAdapter);

        // Recebe a instância do viewmodel
        ComandoViewModel mViewModel = ViewModelProviders.of(this).get(ComandoViewModel.class);

        // Trecho mais importante, os dados da UI são observados e notificará o banco assincronamente
        // atualizando instantaneamente a UI caso haja novos eventos
        mViewModel.getAllComandos().observe(this, comandos -> {

            // envia os dados vindo do banco para o adapter/recyclerview
            mAdapter.setComandos(comandos);
            originalList = comandos;
        });

        mAdapter.setOnItemClickListener(comando ->
                Toast.makeText(MainActivity.this, "" + comando.getComando(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                searchQuery(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRecyclerView.setAdapter(null);
    }

    /**
     * Métodos auxiliares para criar a busca do serchview
     **/

    private void searchQuery(MenuItem item) {
        final SearchView mSearchView = (SearchView) item.getActionView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processQuery(newText);
                mSearchView.setQueryHint("Search");
                return false;
            }
        });
    }

    private void processQuery(String query) {
        List<Comando> result = new ArrayList<>();

        for (Comando comando : originalList) {
            if (comando.getComando().toLowerCase().contains(query.toLowerCase())) {
                result.add(comando);
            }
        }
        mAdapter.setComandos(result);
    }
}
