package com.example.miwokseasydictionary;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.lang.Object;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    ImageView miwokAudioPlayButton;

    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId){

        super(context, 0, words);
        mColorResourceId = colorResourceId;

    }


    @Nullable
    @Override
    public View getView(int position,@Nullable View convertView,@Nullable ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID versi
        // on_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_Text_View);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_Text_View);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        //Find the ImageView in the list_item.xml layout with ID miwok_image_view
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        //Get the image view from the Word class object and
        // set this image on the miwok_image_view ImageView
        if(currentWord.hasImage())
        {
            miwokImageView.setImageResource(currentWord.getMiwokImageResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        else{
            miwokImageView.setVisibility(View.GONE);
        }

        //get id of View for filling background color
        View textContainer = listItemView.findViewById(R.id.text_container);

        //get the color
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //set the color of the textContainer by using above variable
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView


        //To set the audio pronunciation of miwok language at each listitem

        /**
         *

       final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWord.getMiwokAudioResourceId());

        miwokAudioPlayButton = (ImageView) listItemView.findViewById(R.id.miwok_audio_play_button);

        miwokAudioPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
         */



        return listItemView;
    }
}








