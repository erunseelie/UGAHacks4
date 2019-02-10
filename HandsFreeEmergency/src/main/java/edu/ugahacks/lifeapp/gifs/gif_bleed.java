package edu.ugahacks.lifeapp.gifs;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import edu.ugahacks.lifeapp.R;

public class gif_bleed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_bleed);


        ImageView i = findViewById(R.id.gif_bleed);
        Uri path = Uri.parse("android.resource://edu.ugahacks.lifeapp/drawable/tourniquet");
        Glide.with(getApplicationContext()).load(path).into(i);
    }
}
