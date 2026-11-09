package com.example.pe02_registreusuari_oriolmarch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Persona p = (Persona) getIntent().getSerializableExtra("persona");

        TextView txtNom = findViewById(R.id.txtNom);
        TextView txtCognoms = findViewById(R.id.txtCognoms);
        TextView txtEdat = findViewById(R.id.txtEdat);
        TextView txtMatriculat = findViewById(R.id.txtMatriculat);
        CheckBox chkPolitica = findViewById(R.id.chkPolitica);
        Button btnSortir = findViewById(R.id.btnSortir);

        txtNom.setText(p.getNom());
        txtCognoms.setText(p.getCognoms());
        txtEdat.setText(String.valueOf(p.getEdat()));
        if (p.isMatriculat()) {
            txtMatriculat.setText(R.string.si);
        } else {
            txtMatriculat.setText(R.string.no);
        }

        btnSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("acceptat", chkPolitica.isChecked());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
