package com.example.sqltestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button storeBtn = (Button) findViewById(R.id.storeBtn);

        dbManager = new DBManager(this);
        dbManager.open();
        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numRecords = (TextView) findViewById(R.id.numRecords);
                EditText inputText = (EditText) findViewById(R.id.inputText);

                String text = inputText.getText().toString();
                dbManager.insert(text);

                int numberOfRecs = Integer.parseInt(numRecords.getText().toString());
                numberOfRecs = numberOfRecs + 1;
                numRecords.setText(String .valueOf(numberOfRecs));
            }
        });

    }
}
