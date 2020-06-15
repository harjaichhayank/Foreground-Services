package com.example.foregroundServices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditTextId);
    }

    public void StartService(View view) {
        String input = editText.getText().toString();

        Intent intent = new Intent(this,ExampleService.class);
        intent.putExtra("input",input);
        startService(intent);
    }

    public void StopService(View view) {
        Intent intent = new Intent(this,ExampleService.class);
        startService(intent);
        //startForegroundService(serviceIntent); -> to start a service when app is not in the foreground
    }
}
