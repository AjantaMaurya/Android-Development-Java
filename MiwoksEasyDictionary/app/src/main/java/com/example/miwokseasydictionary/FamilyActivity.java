package com.example.miwokseasydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        words.add(new Word("әpә", "father",  R.drawable.family_father,  R.raw.family_father));
        words.add(new Word("әṭa",  "mother",  R.drawable.family_mother,  R.raw.family_mother));
        words.add(new Word("angsi", "son",  R.drawable.family_son,  R.raw.family_son));
        words.add(new Word("tune", "daughter",  R.drawable.family_daughter,  R.raw.family_daughter));
        words.add(new Word("taachi", "older brother",  R.drawable.family_older_brother,  R.raw.family_older_brother));
        words.add(new Word("chalitti", "younger brother",  R.drawable.family_younger_brother,  R.raw.family_younger_brother));
        words.add(new Word("teṭe", "older sister",  R.drawable.family_older_sister,  R.raw.family_older_sister));
        words.add(new Word("kolliti", "younger sister",  R.drawable.family_younger_sister,  R.raw.family_younger_sister));
        words.add(new Word("ama", "grandmother",  R.drawable.family_grandmother,  R.raw.family_grandmother));
        words.add(new Word("paapa", "grandfather",  R.drawable.family_grandfather,  R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Word currentWord = (Word) parent.getAdapter().getItem(position);

                Word currentWord = words.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getApplicationContext(),  currentWord.getMiwokAudioResourceId());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener( onCompletionListener );

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
