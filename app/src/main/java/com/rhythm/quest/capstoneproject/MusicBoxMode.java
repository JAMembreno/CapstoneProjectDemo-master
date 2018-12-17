package com.rhythm.quest.capstoneproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.RawRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MusicBoxMode extends AppCompatActivity {

    TextView songTextInfo;
    ImageView placeHolder;
    Button startGame;
    Button nextSong;
    int songPosition=0;
    int muting=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_box_mode);
        String songInfo[]=new String[]{getResources().getString(R.string.info1),getResources().getString(R.string.info2),getResources().getString(R.string.info3)};
        int image[]=new int[]{R.raw.image_holder,R.raw.music_background,R.raw.musicnotes};

        SharedPreferences sharedPref=getSharedPreferences("MusicMute", MODE_PRIVATE);
        muting = sharedPref.getInt("Mute",0);



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

        songTextInfo=findViewById(R.id.info);
        placeHolder=findViewById(R.id.placeHolder);

        nextSong=findViewById(R.id.next);
        nextSong.setOnClickListener(v->{
            if(songPosition>=songInfo.length-1)
            {
                songPosition=0;

            }

            else
            {
                songPosition++;
            }
            placeHolder.setImageResource(image[songPosition]);
            songTextInfo.setText(songInfo[songPosition]);


        });

        startGame=findViewById(R.id.start);
        startGame.setOnClickListener(v->{
            Intent intent=new Intent(this,Freeplay_Game.class);
            startActivity(intent);
            finish();
        });


        final ImageView back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(MusicBoxMode.this, SelectMode.class);
                startActivity(homeIntent);

                Intent svc = new Intent(MusicBoxMode.this, BackgroundSoundService.class);
                svc.setAction("com.example.BackgroundSoundService");
                if(muting==0)
                    startService(svc);
                finish();
            }
        });
    }
}
