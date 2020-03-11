package com.example.memorise.threads;

import android.media.MediaPlayer;

import java.io.IOException;

public class Play extends Thread {
    String vocab;

    public Play(String vocab){
        this.vocab = vocab;
    }
    @Override
    public void run() {
        super.run();
        String URL = "https://github.com/wcphaha/source/blob/master/dictvoice.mp3";
        System.out.println("!!!!!!!!!"+URL);
        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(URL);
        }catch (java.io.IOException IOException){
            System.out.println("播放音乐有IO问题1！");
        }

//        try {
//            mediaPlayer.prepare() ;
//        }catch (java.io.IOException IOException){
//            System.out.println("播放音乐有IO问题2！");
//        }
        mediaPlayer.start();
    }

}
