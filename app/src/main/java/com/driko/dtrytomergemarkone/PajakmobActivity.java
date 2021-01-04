package com.driko.dtrytomergemarkone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PajakmobActivity extends AppCompatActivity {
    EditText pbk;
    EditText swk;
    EditText bln;
    Button htng;
    TextView hsl;
    Button bayar, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pajakmob);
        pbk = (EditText) findViewById(R.id.pbk);
        swk = (EditText) findViewById(R.id.swk);
        bln = (EditText) findViewById(R.id.bln);
        htng = (Button) findViewById(R.id.htng);
        hsl = (TextView) findViewById(R.id.hsl);

        htng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PBK, SWK, BLN;
                PBK = pbk.getText().toString();
                SWK = swk.getText().toString();
                BLN = bln.getText().toString();

                DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                formatRp.setCurrencySymbol("Rp. ");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');

                kursIndonesia.setDecimalFormatSymbols(formatRp);

                if (TextUtils.isEmpty(BLN)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(SWK)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(PBK)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else {
                    double bk = Double.parseDouble(pbk.getText().toString());
                    double sw = Double.parseDouble(swk.getText().toString());
                    double bl = Double.parseDouble(bln.getText().toString());

                    if(bl == 0) {
                        double pajak = bk + sw;
                        hsl.setText("Jumlah Yang Harus Dibayar = " + pajak);
                    }
                    else {
                        double pajak = ((bk * (0.25) * (bl / 12)) + 100000) + bk + sw;

                        hsl.setText(" Jumlah Pajak  " + kursIndonesia.format(pajak));
                    }
                }
            }
        });

        bayar = (Button) findViewById(R.id.bayar);

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PBK, SWK, BLN;
                PBK = pbk.getText().toString();
                SWK = swk.getText().toString();
                BLN = bln.getText().toString();
                if (TextUtils.isEmpty(BLN)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(SWK)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(PBK)){
                    Toast.makeText(getApplication()," Tolong Lengkapi Data-nya ",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), BayarActivity.class);
                    startActivity(i);
                }
            }
        });

        kembali = (Button) findViewById(R.id.kembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), plpajakActivity.class);
                startActivity(i);
            }
        });
    }
}