package com.gendigital.petstore;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ArrayList<PetInfo> listaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ImageButton imageButton = (ImageButton) actionBar.findViewById(R.id.btn_Fav5);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();
                verFavoritos(view);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rvPetInfo);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new GridLayoutManager(this, 2);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        cargaLista();
        mAdapter = new MyAdapter(listaData, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void cargaLista() {
        //PetInfo MisDatos = new PetInfo(); // para guardar el arreglo en la clase
        listaData = new ArrayList<PetInfo>();

        listaData.add(new PetInfo("Perro", R.drawable.perro, 13));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 15));
        listaData.add(new PetInfo("Loro", R.drawable.loro, 1));
        listaData.add(new PetInfo("Tortuga", R.drawable.tortuga, 2));
        listaData.add(new PetInfo("Pez", R.drawable.pez, 18));
        listaData.add(new PetInfo("Serpiente", R.drawable.serpiente));
        listaData.add(new PetInfo("Otro Perro", R.drawable.perro, 2));
        listaData.add(new PetInfo("Otro Gato", R.drawable.gato, 12));
        listaData.add(new PetInfo("Otro Loro", R.drawable.loro));
        listaData.add(new PetInfo("Otra Tortuga", R.drawable.tortuga, 10));
        listaData.add(new PetInfo("Otro Pez", R.drawable.pez, 2));
        listaData.add(new PetInfo("Otra Serpiente", R.drawable.serpiente));

        for (PetInfo pet : listaData) {
            PetInfo.setItem(pet);
        }
    }

    public void verFavoritos(View v) {
        Intent ventanaFav = new Intent(this, Prueba.class);
        ventanaFav.putExtra("i1", 4);
        ventanaFav.putExtra("i2", 1);
        ventanaFav.putExtra("i3", 0);
        ventanaFav.putExtra("i4", 7);
        ventanaFav.putExtra("i5", 9);
        startActivity(ventanaFav);
    }

}