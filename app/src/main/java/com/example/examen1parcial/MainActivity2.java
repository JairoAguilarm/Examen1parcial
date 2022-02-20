package com.example.examen1parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    SQLconected conexion;
    ListView listacontacto;
    ArrayList<Contactos> lista;
    ArrayList<String> ArregloContacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        conexion = new SQLconected(this, Transacciones.NameDataBase, null, 1);
        listacontacto = (ListView) findViewById(R.id.listacontacto);

        ObtenerListaContactos();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloContacto);
        listacontacto.setAdapter(adp);

        listacontacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
             /*   String informacion = "ID: " + lista.get(position).getId() + "\n";
                informacion += "Nombre: " + lista.get(position).getNombre();

                Toast.makeText(getApplicationContext(), informacion,Toast.LENGTH_LONG).show();

                Intent Compartir = new Intent();
                Compartir.setAction(Intent.ACTION_SEND);
                Compartir.putExtra(Intent.EXTRA_TEXT, informacion);
                Compartir.setType("text/plain");*/

              //  Intent share = Intent.createChooser(Compartir, null);
                //startActivity(share);

            }
        });
        Button regresa = (Button) findViewById(R.id.btvolver);
        regresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button compar = (Button) findViewById(R.id.btcompatir);
        compar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });


    }

    private void ObtenerListaContactos(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Contactos listCont = null;
        lista = new ArrayList<Contactos>();
        ArregloContacto= new ArrayList<String>();
        String itemarreglo ="";

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablacontacto, null);
        Toast.makeText(getApplicationContext(), "SELECT * FROM " + Transacciones.tablacontacto,Toast.LENGTH_LONG).show();
        while (cursor.moveToNext()){
            listCont = new Contactos();
            listCont.setId(cursor.getInt(0));
            listCont.setPais(cursor.getString(1));
            listCont.setNombre(cursor.getString(2));
            listCont.setTelefono(cursor.getString(3));
            listCont.setNota(cursor.getString(4));
            itemarreglo = listCont.getId()+" "+ listCont.getNombre();
            Toast.makeText(getApplicationContext(), itemarreglo,Toast.LENGTH_LONG).show();

            lista.add(listCont);
            ArregloContacto.add(itemarreglo);

        }
    }

}