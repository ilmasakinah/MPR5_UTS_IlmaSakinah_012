package com.example.utslabmprilma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeretGenap extends AppCompatActivity {

    EditText Awal, Akhir;
    Button buatDeret, kembali, hintGenap, resetDeret;
    TextView tampilHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deret_genap);

        Awal = (EditText) findViewById(R.id.inputAwalGenap);
        Akhir = (EditText) findViewById(R.id.inputAkhirGenap);
        buatDeret = (Button) findViewById(R.id.buatDeretGenap);
        tampilHasil = (TextView) findViewById(R.id.hasilDeret);
        kembali = (Button) findViewById(R.id.kembali);
        hintGenap = (Button) findViewById(R.id.hintGenap);
        resetDeret = (Button) findViewById(R.id.resetDeret);

        buatDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasilDeretGenap();
            }
        });

        resetDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Awal.setText("");
                Akhir.setText("");
                tampilHasil.setText("Hasil Deret Genap");
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home2();
            }
        });

        hintGenap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void Home2 (){
        Intent home2 = new Intent(DeretGenap.this, MainActivity2.class);
        startActivity(home2);
    }

    public void openDialog(){
        HintGenap a = new HintGenap();
        a.show(getSupportFragmentManager(),"Hint Deret Genap");
    }

    public void hasilDeretGenap(){
        try {
            String awalDeret = Awal.getText().toString();
            String akhirDeret = Akhir.getText().toString();

            Integer a = Integer.parseInt(awalDeret);
            Integer b = Integer.parseInt(akhirDeret);

            String deret = hitungDeretGenap(a,b);
            tampilHasil.setText("Deret Genap : "+ deret);
        }

        catch (NumberFormatException e){
            tampilHasil.setText("Masukkan Angka");
        }
    }

    public String hitungDeretGenap(int awal, int akhir){
        String deret1 = "",deret = "";
        int i =0;

        for(i = awal; i<=akhir; i++){
            if (i%2 == 0) {
                deret1 += i + " ";
            }
        }

        deret = deret1;
        return deret;
    }
}