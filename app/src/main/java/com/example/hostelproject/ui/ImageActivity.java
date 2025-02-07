package com.example.hostelproject.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.hostelproject.R;
import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        imageView = findViewById(R.id.imageViewBig);
        Toolbar toolbar = findViewById(R.id.toolbar2);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar2));
        }
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            setTitle("");
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        Intent intent = getIntent();
        String profile = intent.getStringExtra("Image");
        String id = intent.getStringExtra("idImage");

        String setImage;

        if (profile != null && !profile.isEmpty()) {
            setImage = profile;
        } else {
            setImage = id;
        }
        Picasso.get()
                .load(setImage)
                .placeholder(R.drawable.loading)
                .fit()
                .centerInside()
                .into(imageView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
