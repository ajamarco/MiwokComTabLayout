package com.example.jamarco.miwokcomtabs;

/**
 * Created by Jamarco on 8/16/2017.
 */

public class Word {

    //2 Strings that represents the default and Miwok words that will be stored in the object
    private String defaultWord;
    private String miwokWord;
    private int mResourceImageID = NO_IMAGE_PROVIDED;
    private int mResourceSoundID = 0;

    public static final int NO_IMAGE_PROVIDED = -1;

    //Constructor which take 2 parameters that will set the default and Miwok words
    public Word (String defaultTranslation, String miwokTranslation, int resourceSoundID){
        defaultWord = defaultTranslation;
        miwokWord = miwokTranslation;
        mResourceSoundID = resourceSoundID;
    }

    //Constructor which take 3 parameters that will set the default and Miwok words, as well the image
    //for each word
    public Word (String defaultTranslation, String miwokTranslation, int resourceImageID, int resourceSoundID){
        defaultWord = defaultTranslation;
        miwokWord = miwokTranslation;
        mResourceImageID = resourceImageID;
        mResourceSoundID = resourceSoundID;
    }


    public String getDefaultWord() {
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }


    public int getResourceImageID() {
        return mResourceImageID;
    }

    public boolean hasImage(){
        return mResourceImageID != NO_IMAGE_PROVIDED;
    }


    public int getResourceSoundID() {
        return mResourceSoundID;
    }
}
