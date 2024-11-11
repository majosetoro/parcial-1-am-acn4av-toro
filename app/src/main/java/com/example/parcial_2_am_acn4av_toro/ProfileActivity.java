package com.example.parcial_2_am_acn4av_toro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ImageView;

public class ProfileActivity extends Activity {

    @SuppressLint("ResourceType")
    public void download(){
        ImageView imaveView = findViewById(R.id.girl_user_profile);
        ImageDownloader downloader = new ImageDownloader(imaveView);
        downloader.execute(getString(R.id.girl_user_profile));
    }

}
