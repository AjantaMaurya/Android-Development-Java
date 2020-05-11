package com.example.miwokseasydictionary;

public class Word {

    /**
     * It contains miwok word and its default translation for the dictionary
     */

    //default translation of the miwok word
    private String mDefaultTranslation;

    //miwok word
    private String mMiwokTranslation;

    //miwok representation image
    private int mMiwokImageResource = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    //miwok language pronunciation
    private int mMiwokAudioResourceId;



    //constructor
    public Word(String miwokTranslation, String defaultTranslation, int miwokAudioResourceId){

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mMiwokAudioResourceId = miwokAudioResourceId;

    }

    //constructor
    public Word(String miwokTranslation, String defaultTranslation, int miwokImageResourceId, int miwokAudioResourceId){

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mMiwokImageResource = miwokImageResourceId;
        mMiwokAudioResourceId = miwokAudioResourceId;

    }


    /**
     * get default translation of the word
     * @return
     */
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * get miwok translation of the word
     * @return
     */
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * get miwok ImageResourceId of the word
     * @return
     */

    public int getMiwokImageResourceId(){
        return mMiwokImageResource;
    }

    /**
     * returns that whther there is image for the word or not
     */
    public boolean hasImage(){
        return (mMiwokImageResource != NO_IMAGE_PROVIDED);
    }

    /**
     * To return the miwook pronunciation of colors, numbers, family members and phrases
     */
    public int getMiwokAudioResourceId(){
        return mMiwokAudioResourceId;
    }
}
