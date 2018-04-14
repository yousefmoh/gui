package com.example.dexter.designinsurance;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dexter.designinsurance.Fragments.FragmentHome;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {
    public static final String API_KEY = "AIzaSyA7dBSqDVSSrKtCUd_hoV8ZGOj8BBczQYE";
    public static final String VIDEO_ID = "07gSogrxp_U";
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videohelp_fragment);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
        // Create new fragment and transaction

    }
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
        Toast.makeText(this, youTubeInitializationResult+"", Toast.LENGTH_LONG).show();

    }
}
