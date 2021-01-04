package com.driko.dtrytomergemarkone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton SKCK, Pajak, Berita, Laporan, back;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SKCK = (ImageButton) findViewById(R.id.SkckButt);
        Pajak = (ImageButton) findViewById(R.id.PajakOnlineButt);
        Berita = (ImageButton) findViewById(R.id.BeritaButt);
        Laporan = (ImageButton) findViewById(R.id.LaporanButt);
        back = (ImageButton) findViewById(R.id.backButt);


        /*
        //BUTTON SET ONCLICK
        SKCK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Pajak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         */
    }
}