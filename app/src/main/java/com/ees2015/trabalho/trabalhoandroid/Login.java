package com.ees2015.trabalho.trabalhoandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// implements View.OnClickListener para aceitar e manipular clicks
public class Login extends AppCompatActivity implements View.OnClickListener {

    // declara todas as views que a activity vai ter
    Button bLogin;
    EditText etNomeUsuario, etSenha;
    TextView tvRegistrarLink;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // acha na content view os campo do XML
        etNomeUsuario = (EditText) findViewById(R.id.etNomeUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegistrarLink = (TextView) findViewById(R.id.tvRegistrarLink);

        // habilita a tela para capturar os cliques no botão de login
        bLogin.setOnClickListener(this);
        tvRegistrarLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }

    // notificar o onClick quando clicar no Botão bLogin
    @Override
    public void onClick(View v){
        // para evitar sobrecarregar a tela pra capturar só o id do campo
        switch (v.getId()){
            case R.id.bLogin:

                User user = new User(null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                break;

            case R.id.tvRegistrarLink:
                // quando for clicado para registrar
                startActivity(new Intent(this, Register.class));
                break;
        }
    }
}
