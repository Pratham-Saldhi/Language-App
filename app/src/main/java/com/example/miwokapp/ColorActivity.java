package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;


    protected void onStop() {
        super.onStop();
        // When the app is stopped release the media player resources
        // as they are no longer needed.
        releaseMediaPlayer();
    }
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //Creating an ArrayList for Word objects
        final ArrayList<Word> words = new ArrayList<Word>();
        //Creating an object instance and adding in ArrayList
        words.add(new Word("Red", "weṭeṭṭi",R.drawable.color_red ,R.raw.color_red));
        words.add(new Word("Green", "chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("Brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("Gray",   "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("Black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("White", "kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("Dusty-Yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("Musturd-yellow", "chiwiiṭә",R.drawable.color_dusty_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words) ;

        ListView listView = (ListView) findViewById(R.id.lvList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word w = words.get(i);
                Log.v("ColorActivity","Current Word" + w);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorActivity.this, w.getmAudioResourceId());
                mediaPlayer.start();
               mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
}