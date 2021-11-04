package com.example.utslabmprilma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        TextView nama = (TextView) findViewById(R.id.namaValue);
        TextView umur = (TextView) findViewById(R.id.umurValue);

        nama.setText("Nama: "+b.getCharSequence("nama"));
        umur.setText("Umur : "+b.getCharSequence("umur")+" Tahun");

        Button ganjil, genap, persegi;
        ganjil = (Button) findViewById(R.id.deretGanjil);
        genap = (Button) findViewById(R.id.deretGenap);
        persegi = (Button) findViewById(R.id.deretPersegi);

        ganjil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ganjil();
            }
        });

        genap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Genap();
            }
        });

        persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persegi();
            }
        });

    }

    public void Ganjil (){
        Intent ganjil = new Intent(MainActivity2.this, DeretGanjil.class);
        startActivity(ganjil);
    }

    public void Genap (){
        Intent genap = new Intent(MainActivity2.this, DeretGenap.class);
        startActivity(genap);
    }

    public void Persegi (){
        Intent persegi = new Intent(MainActivity2.this, DeretPersegi.class);
        startActivity(persegi);
    }
}

