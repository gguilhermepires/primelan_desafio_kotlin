package com.example.desafiokotlin

import android.content.ContentResolver
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.io.File

class SplashScreenActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        playSound()

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.release()
            }
        },5000)

    }
    private fun playSound() {
        var soundurl = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE +
                    File.pathSeparator + File.separator + File.separator + packageName + "/raw/tense")

        mediaPlayer = MediaPlayer.create(this, soundurl)
        mediaPlayer.setOnCompletionListener {
            finish()
        }
        mediaPlayer.start()
    }
}
