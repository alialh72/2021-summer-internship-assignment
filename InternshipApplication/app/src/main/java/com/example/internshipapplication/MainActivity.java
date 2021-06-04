package com.example.internshipapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.internshipapplication.R;
import com.example.internshipapplication.RecyclerAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideStatusBar();
        findViews();

        // initialise arraylist containing image names
        ArrayList<String> imageNames = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            String imageName = "image"+i+".jpg";
            imageNames.add(imageName);
        }

        loadRecyclerView(imageNames);
    }

    private void loadRecyclerView(ArrayList<String> imageNames) {
        Log.d(TAG, "onCreate: imageNames:" +imageNames);
        RecyclerViewAdapter groupAdapter = new RecyclerViewAdapter(imageNames, this);
        recyclerView.setAdapter(groupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //insert divider between recycler items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recyclerView);
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