package com.rhythm.quest.capstoneproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);


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

        final TextView Free_Dance_TV = findViewById(R.id.free_dance_tv);
        final TextView Tutorial_TV = findViewById(R.id.tutorial_tv);
        final TextView leaderbaord_TV = findViewById(R.id.leaderboard_tv);
        final TextView Music_Box_TV = findViewById(R.id.music_box_tv);
        final TextView Config_TV = findViewById(R.id.config_tv);

        Free_Dance_TV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectMode.this,Freeplay_Game.class);
                //FreeDance
                SelectMode.this.startActivity(registerIntent);
                
            }
        });

        Tutorial_TV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectMode.this, TutorialMode.class);
                SelectMode.this.startActivity(registerIntent);
            }
        });

        leaderbaord_TV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectMode.this, LeaderboardMode.class);
                SelectMode.this.startActivity(registerIntent);
            }
        });

        Music_Box_TV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectMode.this, MusicBoxMode.class);
                SelectMode.this.startActivity(registerIntent);
            }
        });

        Config_TV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectMode.this, ConfigMode.class);
                SelectMode.this.startActivity(registerIntent);
            }
        });

        final ImageView back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SelectMode.this, MainMenu.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
