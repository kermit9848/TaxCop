package com.driko.dtrytomergemarkone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {

    //Initialize variable
    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    ArrayList<MainModel> mainModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Assign Variable
        recyclerView = findViewById(R.id.drecycler_view);

        //Create Integer Array
        Integer[] cardLogo = {R.drawable.cardvisa, R.drawable.mastercard};

        //Create String Array
        String[] cardName = {"CardVisa", "MasterCard"};

        //Initial Card List
        mainModels = new ArrayList<>();
        for (int i = 0; i < cardLogo.length; i++) {
            MainModel model = new MainModel(cardLogo[i], cardName[i]);
            mainModels.add(model);
        }

        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                PaymentActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //Initialize Main Adapter
        mainAdapter = new MainAdapter(PaymentActivity.this,mainModels);
        //Set MainAdapter to RecycleView
        recyclerView.setAdapter(mainAdapter);


    }
}