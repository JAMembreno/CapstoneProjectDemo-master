package com.rhythm.quest.capstoneproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class RateUs extends AppCompatActivity {

    Button sendRating;
    ImageView rate1;
    ImageView rate2;
    ImageView rate3;
    ImageView rate4;
    ImageView rate5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        sendRating=findViewById(R.id.send);
        sendRating.setOnClickListener(v->finish());
        rate1=findViewById(R.id.starRating1);
        rate2=findViewById(R.id.starRating2);
        rate3=findViewById(R.id.starRating3);
        rate4=findViewById(R.id.starRating4);
        rate5=findViewById(R.id.starRating5);

        rate1.setOnClickListener(v-> {
            rate1.setImageResource(R.drawable.heart_full);
            rate2.setImageResource(R.drawable.heart_empty);
            rate3.setImageResource(R.drawable.heart_empty);
            rate4.setImageResource(R.drawable.heart_empty);
            rate5.setImageResource(R.drawable.heart_empty);
        });

        rate2.setOnClickListener(v->{
            rate1.setImageResource(R.drawable.heart_full);
            rate2.setImageResource(R.drawable.heart_full);
            rate3.setImageResource(R.drawable.heart_empty);
            rate4.setImageResource(R.drawable.heart_empty);
            rate5.setImageResource(R.drawable.heart_empty);
        });

        rate3.setOnClickListener(v->{
            rate1.setImageResource(R.drawable.heart_full);
            rate2.setImageResource(R.drawable.heart_full);
            rate3.setImageResource(R.drawable.heart_full);
            rate4.setImageResource(R.drawable.heart_empty);
            rate5.setImageResource(R.drawable.heart_empty);
        });

        rate4.setOnClickListener(v->{
            rate1.setImageResource(R.drawable.heart_full);
            rate2.setImageResource(R.drawable.heart_full);
            rate3.setImageResource(R.drawable.heart_full);
            rate4.setImageResource(R.drawable.heart_full);
            rate5.setImageResource(R.drawable.heart_empty);
        });

        rate5.setOnClickListener(v->{
            rate1.setImageResource(R.drawable.heart_full);
            rate2.setImageResource(R.drawable.heart_full);
            rate3.setImageResource(R.drawable.heart_full);
            rate4.setImageResource(R.drawable.heart_full);
            rate5.setImageResource(R.drawable.heart_full);
        });
    }
}
