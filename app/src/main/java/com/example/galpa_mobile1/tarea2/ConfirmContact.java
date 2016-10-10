package com.example.galpa_mobile1.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmContact extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvFNacimiento;
    private TextView tvDescripcion;
    private TextView tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_contact);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.p_nombre));
        String fnacimiento = parametros.getString(getResources().getString(R.string.p_fnacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.p_telefono));
        String correo = parametros.getString(getResources().getString(R.string.p_correo));
        String descripcion = parametros.getString(getResources().getString(R.string.p_descripcion));

        System.out.println("p_nombre:"+nombre);
        System.out.println("p_fnacimiento:"+fnacimiento);
        System.out.println("p_telefono:"+telefono);
        System.out.println("p_correo:"+correo);
        System.out.println("p_descripcion:"+descripcion);

        tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvTelefono = (TextView) findViewById(R.id.tv_telefono);
        tvFNacimiento = (TextView) findViewById(R.id.tv_fnacimiento);
        tvDescripcion = (TextView) findViewById(R.id.tv_descripcion);
        tvCorreo = (TextView) findViewById(R.id.tv_correo);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono.toString());
        tvFNacimiento.setText(fnacimiento);
        tvDescripcion.setText(descripcion);
        tvCorreo.setText(correo);
    }


    public void editData(View v){

        Intent intent = new Intent(ConfirmContact.this, MainActivity.class);

        intent.putExtra(getResources().getString(R.string.p_nombre), tvNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_telefono), tvTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_correo), tvCorreo.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_descripcion), tvDescripcion.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_fnacimiento), tvFNacimiento.getText().toString());

        startActivity(intent);

        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfirmContact.this, MainActivity.class);
            startActivity(intent);

            finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}
