package com.improve10x.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MemeActivity extends AppCompatActivity {

    static final String URL_EXTRA = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        String imageUrl = getIntent().getStringExtra(URL_EXTRA);
        showImage(imageUrl);
    }

    private void showImage(String imageUrl) {
        ImageView previewImg = findViewById(R.id.previewImg);
        Picasso.get().load(imageUrl).into(previewImg);
    }
}