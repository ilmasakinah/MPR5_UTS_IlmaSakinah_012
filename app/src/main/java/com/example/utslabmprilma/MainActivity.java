package com.example.utslabmprilma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nama, umur;
    Button mulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nama = (EditText) findViewById(R.id.inputNama);
        umur = (EditText) findViewById(R.id.inputUmur);
        mulai = (Button) findViewById(R.id.tomboMulai);

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                Bundle b = new Bundle();

                b.putString("nama", nama.getText().toString());
                b.putString("umur", umur.getText().toString());

                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}