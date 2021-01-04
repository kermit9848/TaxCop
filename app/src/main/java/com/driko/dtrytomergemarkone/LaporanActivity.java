package com.driko.dtrytomergemarkone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LaporanActivity extends AppCompatActivity {

    EditText det;
    Button glr, kmr, lapor;
    ImageView imgv;
    final int galery = 100, kamer = 99;
    Uri imageUri;
    static int REQUESTCODE = 1;
    static int PreqCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        det = (EditText) findViewById(R.id.det);
        glr = (Button) findViewById(R.id.glr);
        kmr = (Button) findViewById(R.id.kmr);
        lapor = (Button) findViewById(R.id.lapor);
        imgv = (ImageView) findViewById(R.id.ltgmbr);

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

        lapor.setOnClickListener(new View.OnClickListener() {
            String DET;
            @Override
            public void onClick(View v) {
                DET = det.getText().toString();
                if (TextUtils.isEmpty(DET)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                    Intent lapor = new Intent(getApplicationContext(), LaporanActivity.class);
                    startActivity(lapor);
                }
                else {
                    Toast.makeText(getApplication()," Laporan Terkirim ",Toast.LENGTH_LONG).show();
                    Intent lapor = new Intent(getApplicationContext(), HomepageActivity.class);
                    startActivity(lapor);
                }
            }
        });

    }

    private void OpnCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, kamer);
    }

    private void CheckPermission1(){
        if(ContextCompat.checkSelfPermission(LaporanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(LaporanActivity.this, Manifest.permission.CAMERA)){
                Toast.makeText(LaporanActivity.this, "Please Accept for Required Permission", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(LaporanActivity.this, new String[] {Manifest.permission.CAMERA},PreqCode);
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