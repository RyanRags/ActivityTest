package com.example.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.BlockingDeque;

public class ActivityB extends AppCompatActivity {

    private static String TAG = "ActivityB";
    private String data;
    private TextView displayData;
    private Button openSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        displayData = findViewById(R.id.tvDisplayData);
        openSearch = findViewById(R.id.btnOpenSearch);
        Log.d(TAG, "onCreate: " + displayData.getText());
        Intent getData = getIntent();

        if(getData != null){
            data = getData.getStringExtra("DATA");
        }

        openSearch.setOnLongClickListener(view -> {
            // executed when user press button
            Intent openSearch = new Intent();
            openSearch.setClass(ActivityB.this, OpenSearch.class);
            startActivityForResult(openSearch, 28473);
            return true;
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        if (data != null && !data.isEmpty()) {
            displayData.setText(data);
            data = "";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 28473){
            if(resultCode == RESULT_OK){
                if(data != null){
                    //update data from Search Activity
                    String mdata = data.getStringExtra("DataBack");
                    String currentData = displayData.getText().toString();
                    displayData.setText(currentData + mdata);
                }
            }
        }
    }
}