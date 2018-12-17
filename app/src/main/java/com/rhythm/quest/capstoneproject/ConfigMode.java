package com.rhythm.quest.capstoneproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConfigMode extends AppCompatActivity {

    Button pauseMusic;
    Button rateUs;
    int muting=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_mode);
        SharedPreferences sharedPref=getSharedPreferences("MusicMute", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        muting = sharedPref.getInt("Mute",0);

        pauseMusic=findViewById(R.id.sound);
        rateUs=findViewById(R.id.rate_us);


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        Intent svc = new Intent(this, BackgroundSoundService.class);
        svc.setAction("com.example.BackgroundSoundService");
        stopService(svc);

        MediaPlayer config_background_music = MediaPlayer.create(ConfigMode.this, R.raw.config_background_music);
        config_background_music.start();
        if(muting==1)
        {
            config_background_music.pause();
            pauseMusic.setText("Sound: Off");
        }

        final ImageView back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(ConfigMode.this, SelectMode.class);
                startActivity(homeIntent);
                Intent svc = new Intent(ConfigMode.this, BackgroundSoundService.class);
                svc.setAction("com.example.BackgroundSoundService");
                if(muting==0)
                    startService(svc);

                config_background_music.stop();
            }
        });

        pauseMusic.setOnClickListener(v->{
            if(muting==0)
            {
                pauseMusic.setText("Sound: Off");
                muting=1;
                editor.putInt("Mute", 1);
                editor.apply();
                config_background_music.pause();
            }
            else
            {
                pauseMusic.setText("Sound: On");
                muting=0;
                config_background_music.start();
                editor.putInt("Mute", 0);
                editor.apply();
            }

        });

        rateUs.setOnClickListener(v->{
                Intent i=new Intent(this,RateUs.class);
                startActivity(i);
        });

    }
}
