package com.ees2015.trabalho.trabalhoandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.package.ACTION_LOGOUT");
            registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d("onReceive", "Logout in progress");
                    //At this point you should start the login activity and finish this one
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();

                }
            }, intentFilter);
    }
}
