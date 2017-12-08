package com.ejemplo.rossv.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Contactos extends AppCompatActivity {

    ListView listView;
    UsuarioControlador dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);


        Intent i = getIntent();


        dbcon = new UsuarioControlador(this);
        dbcon.abriBD();
        String personalID = i.getStringExtra("personalId");
        String personalNom = i.getStringExtra("personalNombre");

        ListView listView= (ListView)findViewById(R.id.listView);
        //empezar a instanciar la list view


    }
/*
    @Override
    public void onClick(View v) {

                controlador.insertarDatos(etName.getText().toString());
                Intent i = new Intent(Contactos.this,null)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


    }*/
}
