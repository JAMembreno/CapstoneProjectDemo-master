package com.rhythm.quest.capstoneproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Freeplay_Game extends AppCompatActivity {

    ConstraintLayout constraintLayout;


    TextView hit;
    TextView missed;
    ImageView singleNote;
    TextView score;
    TextView misses;
    ImageView tlc;
    ImageView trc;
    ImageView blc;
    ImageView brc;
    ImageView centerc;
    long timedelay=2000;
    long speed=1000;
    int color[]=new int[]{R.drawable.ic_baseline_music_note_24px,R.drawable.red_note,R.drawable.blue_note,R.drawable.green_note};
    Random r = new Random();
    int randomNum;
    int currentScore=0;
    boolean clicked=true;
    ImageView pic;
    AnimatorSet animSetXY;
    int miss=0;
    ImageView heart1;
    ImageView heart2;
    ImageView heart3;
    ImageView heart4;
    ImageView heart5;
    ImageView heart6;
    ImageView heart7;
    ImageView heart8;
    ImageView heart9;
    ImageView heart10;
    ImageView heart[]=new ImageView[10];
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView star4;
    ImageView star5;
    ImageView star[]=new ImageView[5];
    int heartNum=9;
    boolean endSequenceStart=false;
   //boolean skip=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freeplay__game);

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

        Dialog dialog1=new Dialog(this);
        dialog1.setContentView(R.layout.before_game_start);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.setCancelable(false);
        Button startGame=dialog1.findViewById(R.id.yes);
        Button exitGame=dialog1.findViewById(R.id.no);
        startGame.setOnClickListener(v1->{
            dialog1.dismiss();
            MediaPlayer track1 = MediaPlayer.create(Freeplay_Game.this, R.raw.track4);
            track1.start();
            constraintLayout=findViewById(R.id.gamelayout);
            singleNote=findViewById(R.id.singleNote);
            int noteWidth=singleNote.getWidth();
            int noteHeight=singleNote.getHeight();
            missed=findViewById(R.id.missed);
            hit=findViewById(R.id.hit);
            misses=findViewById(R.id.miss);
            score=findViewById(R.id.score);
            tlc=findViewById(R.id.topLeft_circle);
            trc=findViewById(R.id.topRight_circle);
            blc=findViewById(R.id.bottomLeft_circle);
            brc=findViewById(R.id.bottomRight_circle);
            centerc=findViewById(R.id.center_circle);
            heart1=findViewById(R.id.heart1);
            heart2=findViewById(R.id.heart2);
            heart3=findViewById(R.id.heart3);
            heart4=findViewById(R.id.heart4);
            heart5=findViewById(R.id.heart5);
            heart6=findViewById(R.id.heart6);
            heart7=findViewById(R.id.heart7);
            heart8=findViewById(R.id.heart8);
            heart9=findViewById(R.id.heart9);
            heart10=findViewById(R.id.heart10);
            heart[0]=heart1;
            heart[1]=heart2;
            heart[2]=heart3;
            heart[3]=heart4;
            heart[4]=heart5;
            heart[5]=heart6;
            heart[6]=heart7;
            heart[7]=heart8;
            heart[8]=heart9;
            heart[9]=heart10;


            float YLocation[]=new float[]{0,0,brc.getY(),blc.getY()};
            float XLocation[]=new float[]{trc.getX(),0,brc.getX(),0};


            //makes a note at the Top Right position
            ImageView pictr=new ImageView(this);
            pictr.setImageResource(R.drawable.ic_baseline_music_note_24px);
            pictr.setLayoutParams(new ConstraintLayout.LayoutParams(noteWidth,noteHeight));
            pictr.setY(YLocation[0]);
            pictr.setX(XLocation[0]);
            constraintLayout.addView(pictr);

            //makes a note at the Top Left position
            ImageView pictl=new ImageView(this);
            pictl.setImageResource(R.drawable.red_note);
            pictl.setLayoutParams(new ConstraintLayout.LayoutParams(noteWidth,noteHeight));
            pictl.setY(YLocation[1]);
            pictl.setX(XLocation[1]);
            constraintLayout.addView(pictl);


            //makes a note at the Bottom Right position
            ImageView picbr=new ImageView(this);
            picbr.setImageResource(R.drawable.blue_note);
            picbr.setLayoutParams(new ConstraintLayout.LayoutParams(noteWidth,noteHeight));
            picbr.setY(YLocation[2]);
            picbr.setX(XLocation[2]);
            constraintLayout.addView(picbr);

            //makes a note at the Bottom Left position
            ImageView picbl=new ImageView(this);
            picbl.setImageResource(R.drawable.green_note);
            picbl.setLayoutParams(new ConstraintLayout.LayoutParams(noteWidth,noteHeight));
            picbl.setY(YLocation[3]);
            picbl.setX(XLocation[3]);
            constraintLayout.addView(picbl);

            //Click Listener for all buttons
            tlc.setOnClickListener(v-> click(tlc));
            trc.setOnClickListener(v-> click(trc));
            blc.setOnClickListener(v-> click(blc));
            brc.setOnClickListener(v-> click(brc));

            pic = new ImageView(Freeplay_Game.this);
            pic.setX(0);
            pic.setY(0);

            final ImageView back_btn = findViewById(R.id.back_btn);
            back_btn.setOnClickListener(view -> {
                Intent homeIntent = new Intent(Freeplay_Game.this, SelectMode.class);
                startActivity(homeIntent);

                Intent background_music = new Intent(Freeplay_Game.this, BackgroundSoundService.class);
                background_music.setAction("com.example.BackgroundSoundService");
                startService(background_music);

                track1.stop();
            });

            //handles the looping of notes
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        missed.setVisibility(View.INVISIBLE);
                        hit.setVisibility(View.INVISIBLE);
                       // if(!skip) {
                            if (clicked)
                                clicked = false;
                            else {
                                missed.setVisibility(View.VISIBLE);
                                if (heartNum >= 0)
                                    heart[heartNum].setImageResource(R.drawable.heart_empty);
                                heartNum--;
                            }
                            //skip=false;
                        //}
                        //else
                            //skip=false;

                        if(heartNum<0 && endSequenceStart==false)
                        {
                            endSequenceStart=true;
                            endSequence();
                        }

                        randomNum = r.nextInt(4);//gets new random number between 0 and 3

                        //makes a note at the position specified by random
                        pic = new ImageView(Freeplay_Game.this);
                        pic.setImageResource(color[randomNum]);
                        pic.setLayoutParams(new ConstraintLayout.LayoutParams(noteWidth,noteHeight));
                        pic.setY(YLocation[randomNum]);
                        pic.setX(XLocation[randomNum]);
                        constraintLayout.addView(pic);

                        animateDiagonalPan(pic,centerc);//makes the note move to the center

                    }
                };

                Handler handler2 = new Handler();
                Runnable runnable2 = new Runnable() {
                    @Override
                    public void run() {
                        if(pic.getY()==centerc.getY() && pic.getX()==centerc.getX())
                        {
                            constraintLayout.removeView(pic);
                        }
                        handler.postDelayed(runnable,0);


                        handler2.postDelayed(this, timedelay);
                    }
                };
                handler2.postDelayed(runnable2, timedelay);

                });
        exitGame.setOnClickListener(v2->{
            dialog1.dismiss();
            finish();
        });

        dialog1.show();
    }



        //function for moving v to position v2
        private void animateDiagonalPan(View v,View v2) {

            animSetXY = new AnimatorSet();
            float Py=v.getY();
            float Px=v.getX();

            ObjectAnimator y = ObjectAnimator.ofFloat(v,
                    "translationY",Py, v2.getY());

            ObjectAnimator x = ObjectAnimator.ofFloat(v,
                    "translationX", Px, v2.getX());

            animSetXY.playTogether(x, y);
            animSetXY.setInterpolator(new LinearInterpolator());
            animSetXY.setDuration(speed);
            animSetXY.start();

            if(timedelay>300)
                timedelay=timedelay-50;
            if(speed>=550)
                speed=speed-50;
        }

        private void endSequence()
        {
            //finish();
            Dialog dialog2=new Dialog(this);
            dialog2.setContentView(R.layout.after_game_ends);
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog2.setCancelable(false);
            star1=dialog2.findViewById(R.id.star1);
            star2=dialog2.findViewById(R.id.star2);
            star3=dialog2.findViewById(R.id.star3);
            star4=dialog2.findViewById(R.id.star4);
            star5=dialog2.findViewById(R.id.star5);
            TextView finalScore=dialog2.findViewById(R.id.finalScore);
            finalScore.setText(String.valueOf(currentScore));
            if(currentScore>=20)
                star1.setVisibility(View.VISIBLE);
            if(currentScore>=40)
                star2.setVisibility(View.VISIBLE);
            if(currentScore>=80)
                star3.setVisibility(View.VISIBLE);
            if(currentScore>=100)
                star4.setVisibility(View.VISIBLE);
            if(currentScore>=120)
                star5.setVisibility(View.VISIBLE);
            Button retry=dialog2.findViewById(R.id.retry);
            retry.setOnClickListener(v3->{
                dialog2.dismiss();
                finish();
                Intent intent=new Intent(this,Freeplay_Game.class);
                startActivity(intent);
            });
            Button continueOn=dialog2.findViewById(R.id.continueGame);
            continueOn.setOnClickListener(v4->{
                dialog2.dismiss();
                finish();
            });
            dialog2.show();
        }


        private void click(View v)
        {
            switch (v.getId())
            {
                case R.id.topLeft_circle:
                    clicked=true;
                    if(randomNum==1) {
                        score.setText("Score: " + String.valueOf(++currentScore));
                        animSetXY.end();
                        constraintLayout.removeView(pic);
                        hit.setVisibility(View.VISIBLE);
                        missed.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        hit.setVisibility(View.INVISIBLE);
                        missed.setVisibility(View.VISIBLE);
                        if(heartNum>=0)
                            heart[heartNum].setImageResource(R.drawable.heart_empty);
                        heartNum--;
                        if(heartNum==0)
                        {
                            endSequenceStart=true;
                            endSequence();
                        }

                        //skip=true;
                    }
                    break;
                case R.id.topRight_circle:
                    clicked=true;
                    if(randomNum==0) {
                        score.setText("Score: " + String.valueOf(++currentScore));
                        animSetXY.end();
                        constraintLayout.removeView(pic);
                        hit.setVisibility(View.VISIBLE);
                        missed.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        hit.setVisibility(View.INVISIBLE);
                        missed.setVisibility(View.VISIBLE);
                        if(heartNum>=0)
                            heart[heartNum].setImageResource(R.drawable.heart_empty);
                        heartNum--;
                        if(heartNum==0)
                        {
                            endSequenceStart=true;
                            endSequence();
                        }

                        //skip=true;
                    }
                    break;
                case R.id.bottomLeft_circle:
                    clicked=true;
                    if(randomNum==3) {
                        score.setText("Score: " + String.valueOf(++currentScore));
                        animSetXY.end();
                        constraintLayout.removeView(pic);
                        hit.setVisibility(View.VISIBLE);
                        missed.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        hit.setVisibility(View.INVISIBLE);
                        missed.setVisibility(View.VISIBLE);
                        if(heartNum>=0)
                            heart[heartNum].setImageResource(R.drawable.heart_empty);
                        heartNum--;
                        if(heartNum==0)
                        {
                            endSequenceStart=true;
                            endSequence();
                        }

                        //skip=true;
                    }
                    break;
                case R.id.bottomRight_circle:
                    clicked=true;
                    if(randomNum==2) {
                        score.setText("Score: " + String.valueOf(++currentScore));
                        animSetXY.end();
                        constraintLayout.removeView(pic);
                        hit.setVisibility(View.VISIBLE);
                        missed.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        hit.setVisibility(View.INVISIBLE);
                        missed.setVisibility(View.VISIBLE);
                        if(heartNum>=0)
                            heart[heartNum].setImageResource(R.drawable.heart_empty);
                        heartNum--;
                        if(heartNum==0)
                        {
                            endSequenceStart=true;
                            endSequence();
                        }

                        //skip=true;
                    }
                    break;
            }


        }
}
