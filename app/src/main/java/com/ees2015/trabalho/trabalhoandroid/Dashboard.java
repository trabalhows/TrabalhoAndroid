package com.ees2015.trabalho.trabalhoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Dashboard extends Activity implements OnClickListener {

    private Button bNovoPedido, bPagamento, bSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        bNovoPedido = (Button) findViewById(R.id.bNovoPedido);
        bNovoPedido.setOnClickListener(this);
        bPagamento = (Button) findViewById(R.id.bPagamento);
        bPagamento.setOnClickListener(this);
        bSair = (Button) findViewById(R.id.bSair);
        bSair.setOnClickListener(this);

//        bSair.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Login.class));
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNovoPedido:
                startActivity(new Intent(getApplicationContext(), NovoPedido.class));
                break;

            case R.id.bPagamento:
                startActivity(new Intent(getApplicationContext(), Pagamento.class));
                break;

            case R.id.bSair:
                Intent intent = new Intent(this, Login.class);
                intent.putExtra("finish", true);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }
}

