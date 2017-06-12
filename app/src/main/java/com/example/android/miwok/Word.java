package com.example.android.miwok;

/**
 * Created by vonkr on 9/06/2017.
 */

public class Word {
    /**
     * {@link Word} represents a vocabulary word that users want to learn.
     * It contains an image, a default translation and a Miwok translation for that word
     */

// used by the adapter to check if an image has been loaded
    private static final int NO_IMAGE_PROVIDED = -1;

    //image to be diplayed with the translation
    private int mImageResourceId = NO_IMAGE_PROVIDED;




    //default translation for the word
    private String mDefaultTranslation;

    //Mewok translation for the word
    private String mMiwokTranslation;

    //Constructors

    /**
     * Create a new word object
     *
     * @param defaultTranslation is the word in the language that the user uses, such as english
     * @param miwokTranslation   is the word in the Miwok language
     *
     */

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    /**
     * Create a new word object
     *
     * @param defaultTranslation is the word in the language that the user uses, such as english
     * @param miwokTranslation   is the word in the Miwok language
     * @param imageResourceId   is the drawable resource id of the image associated with the word
     *
     */

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }


    /**
     * Get the default translation of the word
     *
     * @return String
     */
    public int getImage() {
        return mImageResourceId;
    }

    /**
     * Get the default translation of the word
     *
     * @return String
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word
     *
     * @return String
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * return a boolean to say if an image has been loaded in the class
     *
     * @return boolean
     */
    public boolean isImageLoaded() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
