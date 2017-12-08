package com.ejemplo.rossv.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {//implements View.OnClickListener {

    EditText etName, etApellidos, etTelefono, etEmail;
    Button bRegistro;
    UsuarioControlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etName = (EditText) findViewById(R.id.etName);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        bRegistro = (Button) findViewById(R.id.bRegister);

        controlador = new UsuarioControlador(this);
        controlador.abriBD();
        // bRegistro.setOnClickListener(this);
        //}

        bRegistro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                controlador.abriBD();
                controlador.insertarDatos(etName.getText().toString(),
                        etApellidos.getText().toString(),
                        etTelefono.getText().toString(),
                        etEmail.getText().toString());
                Toast.makeText(getBaseContext(), "insertado correctamente", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(RegistroActivity.this, Contactos.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });
    }
}






