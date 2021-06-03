package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewImageName;

    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        hideStatusBar();
        findViews();

        // get imageName from intent
        Intent intent = getIntent();
        imageName = intent.getStringExtra("IMAGENAME");

        // load views
        loadImageView();
        loadTextView();
    }

    private void loadImageView() {
        try {
            // load image from assets folder
            InputStream is = getAssets().open(imageName);  // get inputstream
            Drawable d = Drawable.createFromStream(is, null);  // load image as Drawable
            imageView.setImageDrawable(d);  // set image to ImageView
            is.close();  // close inputstream
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadTextView() {
        textViewImageName.setText(imageName);
    }

    public void goBack(View view) {
        finish();
    }

    private void findViews() {
        imageView = findViewById(R.id.imageView);
        textViewImageName = findViewById(R.id.textViewImageName);
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        // hide the status bar
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // status bar is hidden, so hide actionbar too
        getSupportActionBar().hide();
    }
}