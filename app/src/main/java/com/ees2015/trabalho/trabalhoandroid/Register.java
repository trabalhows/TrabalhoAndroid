package com.ees2015.trabalho.trabalhoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegistrar;
    EditText etNomeUsuario, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNomeUsuario = (EditText) findViewById(R.id.etNomeUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);

        bRegistrar.setOnClickListener(this);
    }

    // notificar o onClick quando clicar no Botão bRegistrar
    @Override
    public void onClick(View v){
        // para evitar sobrecarregar a tela pra capturar só o id do campo
        switch (v.getId()){
            case R.id.bRegistrar:
                String nomeUsuario = etNomeUsuario.getText().toString();
                String senha = etSenha.getText().toString();
                User registeredData = new User(nomeUsuario, senha);
                break;
        }
    }
}
