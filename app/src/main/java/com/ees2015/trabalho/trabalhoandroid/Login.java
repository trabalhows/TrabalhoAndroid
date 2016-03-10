package com.ees2015.trabalho.trabalhoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

// implements View.OnClickListener para aceitar e manipular clicks
public class Login extends AppCompatActivity  {

    // declara todas as views que a activity vai ter
    Button bLogin;
    EditText etLogin, etSenha;
    TextView tvRegistrarLink;
    private RequestQueue requestQueue;
    //private static final String URL = "http://trabalhoandroidees2015.site88.net/trab/login2.php";
    private static final String URL = "http://www.trabalhoandroid.esy.es/trab2/login.php";

    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // acha na content view os campo do XML
        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        bLogin = (Button) findViewById(R.id.bLogin);
        //tvRegistrarLink = (TextView) findViewById(R.id.tvRegistrarLink);

        requestQueue = Volley.newRequestQueue(this);

        // habilita a tela para capturar os cliques no botão de login
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringRequest = new StringRequest(Method.POST, URL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            // leitura que o app recebe do servidor
                            // deve retornar mensagem de sucesso ou de erro, ex: { "Sucesso. ": "Bem-vindo fulano" }
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success")){
                                // a resposta é positiva
                                // o "success" do jsonObject.getString("success") é o elemento do objeto
                                // o toast vai aparecer na tela vai ser: "SUCCESS <o conteúdo do campo sucess do json enviado pelo servidor>"
                                Toast.makeText(getApplicationContext(),"Sucesso. "+jsonObject.getString("success"),Toast.LENGTH_SHORT).show();
                                // chama a activity após o login
                                startActivity(new Intent(getApplicationContext(),Dashboard.class));
                            }else {
                                // se falhar o login, há algum erro de login ou senha
                                // o "error" do jsonObject.getString("error") é o elemento do objeto
                                Toast.makeText(getApplicationContext(), "Erro: " +jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    // parametros para o request body com os dados da tela de login
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("login", etLogin.getText().toString());
                        hashMap.put("senha",etSenha.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });
    }
}

