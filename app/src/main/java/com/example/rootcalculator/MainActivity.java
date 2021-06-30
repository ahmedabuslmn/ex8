package com.example.rootcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity implements DialogR.DialogListener {
    private ImageView add ;
    RootAdapter rootAdapter ;
    BroadcastReceiver bcr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add =findViewById(R.id.add) ;
        RecyclerView recyclerView = findViewById(R.id.rv);
        rootAdapter = new RootAdapter() ;
        recyclerView.setAdapter(rootAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialoge() ;
            }

        });
        bcr = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("dp_has_changed")) {
                    rootAdapter.notifyDataSetChanged();
                }
            }
        };

        registerReceiver(bcr, new IntentFilter("dp_has_changed"));

    }

    public  void  openDialoge()
    {
      DialogR dialog = new DialogR() ;
      dialog.show(getSupportFragmentManager() , "dialog");
    }


    @Override
    public void applayDialog(String number) {
        if(number.isEmpty()){return; }
        }
    }