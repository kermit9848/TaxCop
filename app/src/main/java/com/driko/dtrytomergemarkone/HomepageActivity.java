package com.driko.dtrytomergemarkone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomepageActivity extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    ImageButton Pajak, Skck, Berita, Laporan, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Skck = (ImageButton) findViewById(R.id.SkckButt);
        Pajak = (ImageButton) findViewById(R.id.PajakOnlineButt);
        Berita = (ImageButton) findViewById(R.id.BeritaButt);
        Laporan = (ImageButton) findViewById(R.id.LaporanButt);
        Back = (ImageButton) findViewById(R.id.backButt);


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView Welcome = (TextView) findViewById(R.id.welcome);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    String nama = userProfile.nama;

                    Welcome.setText("Selamat Datang, " + nama);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomepageActivity.this, "Something wrong happened", Toast.LENGTH_LONG).show();
            }
        });

        Skck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skck = new Intent(HomepageActivity.this, SkckActivity.class);
                startActivity(skck);
            }
        });

        Pajak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pajak = new Intent(HomepageActivity.this, plpajakActivity.class);
                startActivity(pajak);
            }
        });

        Berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent berita = new Intent(HomepageActivity.this, BeritaActivity.class);
                startActivity(berita);
            }
        });

        Laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laporan = new Intent(HomepageActivity.this, LaporanActivity.class);
                startActivity(laporan);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomepageActivity.this, DloginActivity.class));
            }
        });
    }
}