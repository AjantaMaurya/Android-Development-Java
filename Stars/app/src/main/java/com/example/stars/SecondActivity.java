package com.example.stars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView Star_Colour;
    public static int getImageId(Context context, String imageName){
        return context.getResources().getIdentifier("drawable/"+imageName, null,context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ImageView imageView = (ImageView) findViewById(R.id.starcolour);


        Intent intent = getIntent();

        Toast.makeText(this, intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();

        String Name = intent.getStringExtra("name");
        imageView.setImageResource(getImageId(getApplicationContext(),Name));
        Star_Colour = (TextView) findViewById(R.id.ColorName);
        Star_Colour.setText(Name+ "Star");

        Intent intent1 = new Intent(SecondActivity.this,MainActivity.class);

    }
}
