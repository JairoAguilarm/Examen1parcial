package com.example.examen1parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    Spinner pais;
    EditText nombre;
    EditText telefono;
    TextView nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.salvar);
        pais = (Spinner) findViewById(R.id.pais);
        nombre = (EditText) findViewById(R.id.nombre);
        telefono = (EditText) findViewById(R.id.telefono);
        nota = (TextView) findViewById(R.id.nota);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregarcontacto();
            }
        });

        FloatingActionButton list2 = (FloatingActionButton) findViewById(R.id.list2);
        list2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void Agregarcontacto() {
        SQLconected conexion = new SQLconected(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.pais, pais.toString());
        valores.put(Transacciones.nombre, nombre.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.nota, nota.getText().toString());
        ;

        Long registro = db.insert(Transacciones.tablacontacto, Transacciones.id, valores);

        Toast.makeText(getApplicationContext(), " INSERCCION EXITOSA " + registro.toString(), Toast.LENGTH_LONG).show();

        db.close();

        //ClearScreen();

    }




}