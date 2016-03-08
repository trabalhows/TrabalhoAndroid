package com.ees2015.trabalho.trabalhoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etNomeUsuario;
    Button userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNomeUsuario = (EditText) findViewById(R.id.etNomeUsuario);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

     //   userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // assim que o usuário autentica, mostra os dados dele
        // se não estiver logado, abre a activity de login
        if (authenticate()){
            displayUserDetails();
        } else {
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    private boolean authenticate(){
        //return userLocalStore.getUserLoggedIn();
        return true;
    }

    private void displayUserDetails(){
        //User user =  userLocalStore.getLoggedInUser();
        //etNomeUsuario.setText(user.login);
    }

    // notificar o onClick quando clicar no Botão bLogout
    @Override
    public void onClick(View v){
        // para evitar sobrecarregar a tela pra capturar só o id do campo
        switch (v.getId()){
            case R.id.bLogout:
                //userLocalStore.clearUserData();
                //userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}
