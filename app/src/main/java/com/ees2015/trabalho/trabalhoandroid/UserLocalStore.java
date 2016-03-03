package com.ees2015.trabalho.trabalhoandroid;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    // usando Context para poder usar o SharedPreferences pois não dá pra instanciar a classe no construtor do UserLocalStore
    public UserLocalStore(Context context){
         userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        // pegar os dados do SharedPreferences do usuário
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        // atualiza os atributos do usuário no SharedPreferences
        spEditor.putString("nomeUsuario", user.nomeUsuario);
        spEditor.putString("senha", user.senha);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String nomeUsuario = userLocalDatabase.getString("nomeUsuario", "");
        String senha = userLocalDatabase.getString("senha", "");

        return new User(nomeUsuario, senha);
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false) == true){
            return true;
        } else {
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
