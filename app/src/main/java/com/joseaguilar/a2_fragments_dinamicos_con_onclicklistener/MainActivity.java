package com.joseaguilar.a2_fragments_dinamicos_con_onclicklistener;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joseaguilar.a2_fragments_dinamicos_con_onclicklistener.Fragments.Fragment_Azul;
import com.joseaguilar.a2_fragments_dinamicos_con_onclicklistener.Fragments.Fragment_Rojo;
import com.joseaguilar.a2_fragments_dinamicos_con_onclicklistener.Fragments.Fragment_Verde;

//Paso 1: implementamos los fragments
public class MainActivity extends AppCompatActivity
        implements Fragment_Azul.OnFragmentInteractionListener,
        Fragment_Rojo.OnFragmentInteractionListener,
        Fragment_Verde.OnFragmentInteractionListener {

    //Paso 2: Creamos instancias que referencian a nuestros fragments
    Fragment_Verde fragment_verde;
    Fragment_Rojo fragment_rojo;
    Fragment_Azul fragment_azul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Paso 3: Creamos la instancias
        fragment_azul = new Fragment_Azul();
        fragment_rojo = new Fragment_Rojo();
        fragment_verde = new Fragment_Verde();

        //Paso 4: creamos instancia para que el fragment Rojo inicialice por defecto en la aplicacion
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragment_rojo).commit();

    }

    // Paso 5: creamos condicional para la transicion entre fragments
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnrojo:
                fragmentTransaction.replace(R.id.contenedorFragment,fragment_rojo);
                break;
            case R.id.btnazul:
                fragmentTransaction.replace(R.id.contenedorFragment,fragment_azul);
                break;
            case R.id.btnverde:
                fragmentTransaction.replace(R.id.contenedorFragment,fragment_verde);
                break;

        }


        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
