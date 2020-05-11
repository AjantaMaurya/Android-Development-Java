package com.example.miwokseasydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;


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

        mAudioManager = (AudioManager) getSystemService(NumbersActivity.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti", "one",  R.drawable.number_one,  R.raw.number_one));
        words.add(new Word("otiiko", "two",  R.drawable.number_two,  R.raw.number_two));
        words.add(new Word("tolookosu", "three",  R.drawable.number_three,  R.raw.number_three));
        words.add(new Word("oyyisa", "four",  R.drawable.number_four,  R.raw.number_four));
        words.add(new Word("massokka", "five",  R.drawable.number_five,  R.raw.number_five));
        words.add(new Word("temmokka", "six",  R.drawable.number_six,  R.raw.number_six));
        words.add(new Word("kenekaku", "seven",  R.drawable.number_seven,  R.raw.number_seven));
        words.add(new Word("kawinta", "eight",  R.drawable.number_eight,  R.raw.number_eight));
        words.add(new Word("wo'e", "nine",  R.drawable.number_nine,  R.raw.number_nine));
        words.add(new Word("na'aacha", "ten",  R.drawable.number_ten,  R.raw.number_ten));



        WordAdapter numbersList = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(numbersList);

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

            mediaPlayer = null;
        }
    }
}
