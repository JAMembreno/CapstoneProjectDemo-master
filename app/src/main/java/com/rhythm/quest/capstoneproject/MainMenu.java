package com.rhythm.quest.capstoneproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
    final int RC_SIGN_IN = 123, RC_PHOTO_PICKER = 12;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


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

      //  MediaPlayer background_music= MediaPlayer.create(MainMenu.this,R.raw.background_music);
      //  background_music.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        svc.setAction("com.example.BackgroundSoundService");
        startService(svc);


        final ImageView mainMenu = findViewById(R.id.main_menu);

        mainMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(MainMenu.this, SelectMode.class);
                startActivity(homeIntent);
            }
        });
    }

}
