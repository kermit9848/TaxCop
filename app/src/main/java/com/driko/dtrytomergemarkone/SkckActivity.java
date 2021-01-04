package com.driko.dtrytomergemarkone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SkckActivity extends AppCompatActivity {

    ImageView imgv;
    EditText nama, telp, kk, ktp, email;
    Button glr, kmr, kembali, kirim;
    final int galery = 100, kamer = 99;
    Uri imageUri;
    static int REQUESTCODE = 1;
    static int PreqCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skck);
        imgv = (ImageView) findViewById(R.id.ltgmbr);
        glr = (Button) findViewById(R.id.glr);
        kmr = (Button) findViewById(R.id.kmr);
        kembali = (Button) findViewById(R.id.kembali);
        kirim = (Button) findViewById(R.id.kirim);
        nama = (EditText) findViewById(R.id.nama);
        telp = (EditText) findViewById(R.id.telp);
        kk = (EditText) findViewById(R.id.kk);
        ktp = (EditText) findViewById(R.id.ktp);
        email = (EditText) findViewById(R.id.email);

        glr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, galery);
            }
        });

        kmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=18){
                    CheckPermission1();
                }else {
                    OpnCamera();
                }
            }
        });


        kirim.setOnClickListener(new View.OnClickListener() {
            String NAMA,KTP,KK,TELP,EMAIL;

            @Override
            public void onClick(View v) {
                NAMA = nama.getText().toString();
                KTP = ktp.getText().toString();
                KK = kk.getText().toString();
                TELP = telp.getText().toString();
                EMAIL = email.getText().toString();
                if (TextUtils.isEmpty(NAMA)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(KTP)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(KK)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(TELP)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(EMAIL)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(SkckActivity.this, "Data Terkirim", Toast.LENGTH_SHORT).show();
                    Intent skck = new Intent(getApplicationContext(), SkckActivity.class);
                    startActivity(skck);
                }
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(),HomepageActivity.class);
                startActivity(menu);
            }
        });


    }

    private void OpnCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, kamer);
    }

    private void CheckPermission1(){
        if(ContextCompat.checkSelfPermission(SkckActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(SkckActivity.this, Manifest.permission.CAMERA)){
                Toast.makeText(SkckActivity.this, "Please Accept for Required Permission", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(SkckActivity.this, new String[] {Manifest.permission.CAMERA},PreqCode);
            }
        }else {
            OpnCamera();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == galery && resultCode == RESULT_OK){
            imageUri = data.getData();
            imgv.setImageURI(imageUri);
        }else if(requestCode == kamer && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgv.setImageBitmap(bitmap);
        }
    }





}