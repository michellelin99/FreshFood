package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText eItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize member variables
        eItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        eItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //when edit has been confirmed by clicking button return data back to main
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent containg result
                Intent intent = new Intent();

                // pass the data (results of string)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, eItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set results in intent
                setResult(RESULT_OK, intent);

                //finish activity
                finish();
            }
        });
    }
}
