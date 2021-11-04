package com.example.utslabmprilma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeretPersegi extends AppCompatActivity {

    EditText Awal, Akhir;
    Button buatDeret, kembali, hintKuadrat, resetDeret;
    TextView tampilHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deret_persegi);

        Awal = (EditText) findViewById(R.id.inputAwalKuadrat);
        Akhir = (EditText) findViewById(R.id.inputAkhirKuadrat);
        buatDeret = (Button) findViewById(R.id.buatDeretPersegi);
        tampilHasil = (TextView) findViewById(R.id.hasilDeret);
        kembali = (Button) findViewById(R.id.kembali);
        hintKuadrat = (Button) findViewById(R.id.hintKuadrat);
        resetDeret = (Button) findViewById(R.id.resetDeret);

        buatDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasilDeretKuadrat();
            }
        });

        resetDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Awal.setText("");
                Akhir.setText("");
                tampilHasil.setText("Hasil Deret Kuadrat");
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home3();
            }
        });

        hintKuadrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void Home3 (){
        Intent home3 = new Intent(DeretPersegi.this, MainActivity2.class);
        startActivity(home3);
    }

    public void openDialog(){
        HintKuadrat a = new HintKuadrat();
        a.show(getSupportFragmentManager(),"Hint Deret Kuadrat");
    }

    public void hasilDeretKuadrat(){
        try {
            String awalDeret = Awal.getText().toString();
            String akhirDeret = Akhir.getText().toString();

            Integer a = Integer.parseInt(awalDeret);
            Integer b = Integer.parseInt(akhirDeret);

            String deret = hitungDeretKuadrat(a,b);
            tampilHasil.setText("Deret Kuadrat : "+ deret);
        }

        catch (NumberFormatException e){
            tampilHasil.setText("Masukkan Angka");
        }
    }

    public String hitungDeretKuadrat(int awal, int akhir){
        String deret1 = "",deret = "";
        int i =0;

        for(i = awal; i<=akhir; i++){
            deret1 += i*i + " ";
        }

        deret = deret1;
        return deret;
    }
}