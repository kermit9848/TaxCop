package com.driko.dtrytomergemarkone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DwelcomeActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwelcome);

        button = (Button) findViewById(R.id.dwelcomebutton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent_login = new Intent(DwelcomeActivity.this, DloginActivity.class);
                startActivity(intent_login);
            }
        });

    }


}

