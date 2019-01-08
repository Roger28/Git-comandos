package com.example.android.gitcomandos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Para melhor entendimento olhar as classes na seguinte ordem
 * - Comando
 * - ComandoDao
 * - AppDataBase
 * - ComandoRepository/DataGenerator
 * - ComandoViewModel
 * - ComandoAdapter
 * - Main
 * <p>
 * Se acrescentar algo, comente...
 **/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(new MainFragment());
    }

    private void openFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment, fragment);
        ft.commit();
    }
}
