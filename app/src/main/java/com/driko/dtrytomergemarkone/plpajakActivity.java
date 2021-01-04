package com.driko.dtrytomergemarkone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class plpajakActivity extends AppCompatActivity {
    private Button pmb, pmt, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plpajak);

        pmb=(Button)findViewById(R.id.pmb);
        pmt=(Button)findViewById(R.id.pmt);
        kembali=(Button)findViewById(R.id.kembali);

        pmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pmb = new Intent(getApplicationContext(),PajakmobActivity.class);
                startActivity(pmb);
            }
        });

        pmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pmt = new Intent(getApplicationContext(),PajakmotActivity.class);
                startActivity(pmt);
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(getApplicationContext(),HomepageActivity.class);
                startActivity(kembali);
            }
        });
    }
}