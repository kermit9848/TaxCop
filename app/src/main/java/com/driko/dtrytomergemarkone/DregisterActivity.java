package com.driko.dtrytomergemarkone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class DregisterActivity extends AppCompatActivity {
    EditText Nama,NIK,NPWP,Alamat,NoTelp,Email,Password,ConPass;
    Button Regist;
    TextView Login;
    //FirebaseDatabase rootNode;
    //DatabaseReference reference;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dregister);

        mAuth = FirebaseAuth.getInstance();

        Nama = findViewById(R.id.id_nama);
        NIK = findViewById(R.id.id_nik);
        NPWP = findViewById(R.id.id_npwp);
        Alamat = findViewById(R.id.id_alamat);
        NoTelp = findViewById(R.id.id_notelp);
        Email = findViewById(R.id.id_email);
        Password = findViewById(R.id.id_pass);
        ConPass = findViewById(R.id.id_conPass);
        Regist = findViewById(R.id.button_register);
        Login = findViewById(R.id.Login1);

        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = Nama.getText().toString().trim();
                String nik = NIK.getText().toString().trim();
                String npwp = NPWP.getText().toString().trim();
                String alamat = Alamat.getText().toString().trim();
                String notelp = NoTelp.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String conpass = ConPass.getText().toString().trim();

                if(nama.isEmpty()){
                    Nama.setError("Field tidak boleh kosong");
                    Nama.requestFocus();
                    return;
                }

                if(nik.isEmpty()){
                    NIK.setError("Field tidak boleh kosong");
                    NIK.requestFocus();
                    return;
                }

                if(npwp.isEmpty()){
                    NPWP.setError("Field tidak boleh kosong");
                    NPWP.requestFocus();
                    return;
                }

                if(alamat.isEmpty()){
                    Alamat.setError("Field tidak boleh kosong");
                    Alamat.requestFocus();
                    return;
                }

                if(notelp.isEmpty()){
                    NoTelp.setError("Field tidak boleh kosong");
                    NoTelp.requestFocus();
                    return;
                }

                if(email.isEmpty()){
                    Email.setError("Field tidak boleh kosong");
                    Email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Email.setError("Please provide valid email");
                    Email.requestFocus();

                }

                if(password.isEmpty()){
                    Password.setError("Field tidak boleh kosong");
                    Password.requestFocus();
                    return;
                }

                if(password.length()<6){
                    Password.setError("Password at least more than 6 character");
                    Password.requestFocus();
                }

                if(conpass.isEmpty()){
                    ConPass.setError("Field tidak boleh kosong");
                    ConPass.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User user = new User(nama, nik, npwp, alamat, notelp, email);

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()){
                                                Toast.makeText(DregisterActivity.this,"User has been registered successfully", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(DregisterActivity.this,"Failed to register and try again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else{
                                    Toast.makeText(DregisterActivity.this,"Failed to register and try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(DregisterActivity.this, DloginActivity.class);
                startActivity(login);
            }
        });

    }

}