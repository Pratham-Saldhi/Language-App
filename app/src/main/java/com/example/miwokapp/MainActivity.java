package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numbers, family, colors, phrases;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = findViewById(R.id.tvNumbers);
        family = findViewById(R.id.tvFamily);
        colors = findViewById(R.id.tvColors);
        phrases = findViewById(R.id.tvPhrases);


        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Going to Numbers", Toast.LENGTH_SHORT).show();

            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Going to Family Members", Toast.LENGTH_SHORT).show();
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Going to Colors", Toast.LENGTH_SHORT).show();
            }
        });
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Going to Phrases", Toast.LENGTH_SHORT).show();
            }
        });

    }
}