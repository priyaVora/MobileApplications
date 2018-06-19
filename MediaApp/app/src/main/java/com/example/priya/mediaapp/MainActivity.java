package com.example.priya.mediaapp;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer;
    private ImageView artistImage;
    private TextView artist_name;
    private TextView song_name;
    private Button playButton;
    private Button prevButton;
    private Button nextButton;
    private TextView startTimeView;
    private TextView endTimeView;
    private SeekBar mSeekbar;

    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setUpUI();
        mSeekbar.setMax(mediaPlayer.getDuration());
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                mediaPlayer.seekTo(progress);
                }

                SimpleDateFormat format = new SimpleDateFormat("mm:ss");
                int currentPos = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();

                startTimeView.setText(format.format(new Date(currentPos)));
                endTimeView.setText(format.format(new Date(duration- currentPos)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {
                    //stop and give option to start again
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });
    }




    public void setUpUI() {

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chunar);



        artistImage = findViewById(R.id.imageView);
        song_name = findViewById(R.id.song_nameID);
        artist_name = findViewById(R.id.artist_name);
        mSeekbar = findViewById(R.id.mSeekbar);
        playButton = findViewById(R.id.playButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        startTimeView = findViewById(R.id.startTimeView);
        endTimeView = findViewById(R.id.endTimeView);


        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    public void updateThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while(mediaPlayer != null && mediaPlayer.isPlaying()) {
                        Thread.sleep(50);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int newPosition = mediaPlayer.getCurrentPosition();
                                int newMax = mediaPlayer.getDuration();

                                mSeekbar.setMax(newMax);
                                mSeekbar.setProgress(newPosition);

                                startTimeView.setText(String.valueOf(new SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getCurrentPosition()))));
                                endTimeView.setText(String.valueOf(new SimpleDateFormat("mm:ss").format(new Date(newMax - newPosition))));
                            }
                        });
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void backMusic() {
        if(mediaPlayer != null) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(0);
            }
        }
    }

    public void nextMusic() {
        if(mediaPlayer != null) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.prevButton:
                backMusic();
                break;
            case R.id.playButton:
                if(mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else  {
                    startMusic();
                }
                break;
            case R.id.nextButton:
                nextMusic();
                break;
        }
    }


//
//
//
//
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                int duration = mediaPlayer.getDuration();
//                String mDuration = String.valueOf(duration/1000);
//                endTimeView.setText(mDuration);
//                Toast.makeText(getApplicationContext(),"duration " + mDuration, Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//    }
//
    public void pauseMusic() {
        if(mediaPlayer !=null) {
            mediaPlayer.pause();
            playButton.setBackgroundResource(android.R.drawable.ic_media_play);
        }
    }

    public void startMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.start();
            updateThread();
            playButton.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
    }
//
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();
    }
}
