package com.example.android.gitcomandos;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.gitcomandos.db.entity.Comando;
import com.example.android.gitcomandos.ui.ComandoAdapter;
import com.example.android.gitcomandos.viewmodel.ComandoViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ComandoAdapter mAdapter;
    private List<Comando> originalList;
    private RecyclerView mRecyclerView;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        originalList = new ArrayList<>();

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
                Toast.makeText(getActivity(), "" + comando.getComando(), Toast.LENGTH_SHORT).show());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAdapter.setComandos(null);
    }
}
