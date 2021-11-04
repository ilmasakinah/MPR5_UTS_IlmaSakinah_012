package com.example.utslabmprilma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeretGanjil extends AppCompatActivity {

    EditText Awal, Akhir;
    Button buatDeret, kembali, hintGanjil, resetDeret;
    TextView tampilHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deret_ganjil);

        Awal = (EditText) findViewById(R.id.inputAwalGanjil);
        Akhir = (EditText) findViewById(R.id.inputAkhirGanjil);
        buatDeret = (Button) findViewById(R.id.buatDeretGanjil);
        tampilHasil = (TextView) findViewById(R.id.hasilDeret);
        kembali = (Button) findViewById(R.id.kembali);
        hintGanjil = (Button) findViewById(R.id.hintGanjil);
        resetDeret = (Button) findViewById(R.id.resetDeret);

        buatDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasilDeretGanjil();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        hintGanjil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        resetDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Awal.setText("");
                Akhir.setText("");
                tampilHasil.setText("Hasil Deret Ganjil");
            }
        });

    }

    public void Home (){
        Intent home = new Intent(DeretGanjil.this, MainActivity2.class);
        startActivity(home);
    }

    public void openDialog(){
        HintGanjil a = new HintGanjil();
        a.show(getSupportFragmentManager(),"Hint Deret Ganjil");
    }

    public void hasilDeretGanjil(){
        try {
            String awalDeret = Awal.getText().toString();
            String akhirDeret = Akhir.getText().toString();

            Integer a = Integer.parseInt(awalDeret);
            Integer b = Integer.parseInt(akhirDeret);

            String deret = hitungDeretGanjil(a,b);
            tampilHasil.setText("Deret Ganjil : "+ deret);
        }

        catch (NumberFormatException e){
            tampilHasil.setText("Masukkan Angka");
        }
    }

    public String hitungDeretGanjil(int awal, int akhir){
        String deret1 = "",deret = "";
        int i =0;

        for(i = awal; i<=akhir; i++){
            if (i%2 == 1) {
                deret1 += i + " ";
            }
        }

        deret = deret1;
        return deret;
    }
}