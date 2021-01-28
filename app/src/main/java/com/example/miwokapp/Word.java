package com.example.miwokapp;

/**
 * Creating my first CUSTOM CLASS
 * A Word Class for both Default number
 * and the Miwok Number
 */
public class Word {

    //number in a language user knows
    private String mDefaultTranslation;

    //number in a miwok language
    private String mMiwoktranslation;

    // imageresource id number
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // Audio resource id
    private int mAudioResourceId;
    private static  final int NO_IMAGE_PROVIDED = -1;


    public Word(String mDefaultTranslation, String mMiwoktranslation, int mImageResourceId,int mAudioResourceId){
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwoktranslation = mMiwoktranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwoktranslation, int mAudioResourceId){
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwoktranslation = mMiwoktranslation;
        this.mAudioResourceId = mAudioResourceId;
    }
    public String getmDefaultTranslation(){
        return this.mDefaultTranslation;
    }
    public String getmMiwoktranslation(){
        return this.mMiwoktranslation;
    }
    public int getmImageResourceId(){ return this.mImageResourceId; }
    public int getmAudioResourceId(){return mAudioResourceId;}
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    // Overriding the toString method for the purpose fof logCat
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwoktranslation='" + mMiwoktranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
