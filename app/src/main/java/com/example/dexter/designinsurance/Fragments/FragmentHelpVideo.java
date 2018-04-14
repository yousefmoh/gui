package com.example.dexter.designinsurance.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Created by dexter on 3/31/2018.
 */

class  HelpVideo   extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    View view;
    Toolbar toolbar;

    public static final String API_KEY = "AIzaSyA7dBSqDVSSrKtCUd_hoV8ZGOj8BBczQYE";
    public static final String VIDEO_ID = "EGy39OMyHzw";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   /*
     view =inflater.inflate(R.layout.videohelp_fragment, container, false);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);

        InitToolbar();
        return view;
    */







    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }

    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();

    }
}
