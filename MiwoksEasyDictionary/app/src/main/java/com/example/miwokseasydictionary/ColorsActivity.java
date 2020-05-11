package com.example.miwokseasydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("weṭeṭṭi", "red",  R.drawable.color_red,  R.raw.color_red));
        words.add(new Word("chokokki", "green",  R.drawable.color_green,  R.raw.color_green));
        words.add(new Word("ṭakaakki", "brown",  R.drawable.color_brown,  R.raw.color_brown));
        words.add(new Word("ṭopoppi", "gray",  R.drawable.color_gray,  R.raw.color_gray));
        words.add(new Word("kululli", "black",  R.drawable.color_black,  R.raw.color_black));
        words.add(new Word("kelelli", "white",  R.drawable.color_white,  R.raw.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow",  R.drawable.color_dusty_yellow,  R.raw.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow",  R.drawable.color_mustard_yellow,  R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Word currentWord = (Word) parent.getAdapter().getItem(position);

                Word currentWord = words.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getApplicationContext(), currentWord.getMiwokAudioResourceId());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(onCompletionListener);

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){

        if(mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
    }
}
