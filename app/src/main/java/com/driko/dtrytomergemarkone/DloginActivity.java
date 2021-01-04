package com.driko.dtrytomergemarkone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DloginActivity extends AppCompatActivity{
    Button Login, SignUp, Reset;
    EditText email, password;
    ImageView back;
    CheckBox ShowPass;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlogin);

        Reset = (Button) findViewById(R.id.btn_to_forgot);
        SignUp = (Button) findViewById(R.id.btn_to_register);
        Login = (Button) findViewById(R.id.dbutton_loginone);
        back = (ImageView) findViewById(R.id.BackButt);
        email = (EditText) findViewById(R.id.id_email);
        password = (EditText) findViewById(R.id.id_pass);
        ShowPass = (CheckBox) findViewById(R.id.showpass);

        mAuth = FirebaseAuth.getInstance();

        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ShowPass.isChecked()){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset = new Intent(DloginActivity.this, ForgotPassword.class);
                startActivity(reset);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DloginActivity.this, DwelcomeActivity.class);
                startActivity(back);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(DloginActivity.this, DregisterActivity.class);
                startActivity(signup);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if(Email.isEmpty()){
                    email.setError("Email is required");
                    email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("Please enter a valid email");
                    email.requestFocus();
                    return;
                }

                if(Password.isEmpty()){
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if(Password.length() < 6){
                    password.setError("Password at least 6 characters");
                    password.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if(user.isEmailVerified()) {
                                //user
                                startActivity(new Intent(DloginActivity.this, HomepageActivity.class));
                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(DloginActivity.this, "Check your email to verified",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(DloginActivity.this,"Failed to login! Please check your credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

}
