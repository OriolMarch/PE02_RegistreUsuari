package com.example.pe02_registreusuari_oriolmarch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNom, edtCognoms, edtEdat;
    RadioButton rbSi;
    TextView txtPolitica;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNom = findViewById(R.id.edtNom);
        edtCognoms = findViewById(R.id.edtCognoms);
        edtEdat = findViewById(R.id.edtEdat);
        rbSi = findViewById(R.id.rbSi);
        txtPolitica = findViewById(R.id.txtPolitica);
        btnValidar = findViewById(R.id.btnValidar);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = edtNom.getText().toString();
                String cognoms = edtCognoms.getText().toString();
                String edat = edtEdat.getText().toString();

                if (nom.isEmpty() || cognoms.isEmpty() || edat.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_camps, Toast.LENGTH_LONG).show();
                } else {
                    Persona p = new Persona(nom, cognoms, Integer.parseInt(edat), rbSi.isChecked());

                    Intent i = new Intent(MainActivity.this, Activity2.class);
                    Bundle container = new Bundle();
                    container.putSerializable("persona", p);
                    i.putExtras(container);
                    startActivityForResult(i, 123);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            boolean acceptat = data.getBooleanExtra("acceptat", false);
            if (acceptat) {
                txtPolitica.setText(R.string.politica_acceptada);
            } else {
                txtPolitica.setText(R.string.politica_no_acceptada);
            }
        }
    }
}
