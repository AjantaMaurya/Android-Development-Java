package com.example.miwokseasydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view numbers by id
        TextView numbers = (TextView) findViewById(R.id.numbers);

        //set on click listener to listen the click
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent for numbers view
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //start numbers activity
                startActivity(numbersIntent);
            }
        });

        //find the view of family members by id
        TextView family = (TextView) findViewById(R.id.family);

        //set on click listener for family
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                startActivity( familyIntent );
            }
        });

        //find the view of colors by id
        TextView colors = (TextView) findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                startActivity( colorsIntent);
            }
        });

        //find the view of phrases by id
        TextView phrases = (TextView) findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                startActivity(phrasesIntent);
            }
        });


    }
}
