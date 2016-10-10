package com.example.galpa_mobile1.tarea2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    int month;
    private TextInputEditText et_Nombre;
    private TextInputEditText et_Correo;
    private TextInputEditText et_Descripcion;
    private TextInputEditText et_Telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.datePicker);

        et_Nombre = (TextInputEditText)findViewById(R.id.campo_nombre);
        et_Correo = (TextInputEditText)findViewById(R.id.campo_correo);
        et_Telefono = (TextInputEditText)findViewById(R.id.campo_telefono);
        et_Descripcion = (TextInputEditText)findViewById(R.id.campo_descripcion);

        Bundle parametros = getIntent().getExtras();

        if(parametros != null ){
            String nombre = parametros.getString(getResources().getString(R.string.p_nombre));
            String fnacimiento = parametros.getString(getResources().getString(R.string.p_fnacimiento));
            String telefono = parametros.getString(getResources().getString(R.string.p_telefono));
            String correo = parametros.getString(getResources().getString(R.string.p_correo));
            String descripcion = parametros.getString(getResources().getString(R.string.p_descripcion));

            System.out.println("p_nombreM:"+nombre);
            System.out.println("p_fnacimientoM:"+fnacimiento);
            System.out.println("p_telefonoM:"+telefono);
            System.out.println("p_correoM:"+correo);
            System.out.println("p_descripcionM:"+descripcion);

    /*    tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvTelefono = (TextView) findViewById(R.id.tv_telefono);
        tvFNacimiento = (TextView) findViewById(R.id.tv_fnacimiento);
        tvDescripcion = (TextView) findViewById(R.id.tv_descripcion);
        tvCorreo = (TextView) findViewById(R.id.tv_correo);
*/
            et_Nombre.setText(nombre);
            et_Telefono.setText(telefono.toString());
            setDate(fnacimiento.toString());//tvFNacimiento.setText(fnacimiento);
            et_Descripcion.setText(descripcion.toString());
            et_Correo.setText(correo.toString());
        }
    }

    public String getSelectedDate() {
        StringBuilder mcurrentDate = new StringBuilder();
        month = datePicker.getMonth() + 1;
        mcurrentDate.append(datePicker.getDayOfMonth()  + "/" + month+ "/" + datePicker.getYear());
        return mcurrentDate.toString();
    }

    public void setDate(String cadena){
        String[] separated = cadena.split("/");
        System.out.println("separated[1]:"+separated[1]);

        datePicker.init(Integer.parseInt(separated[2]),Integer.parseInt(separated[1])-1,Integer.parseInt(separated[0]),null);

    }

    public void goToConfirmar(View v){
        Intent intent = new Intent(MainActivity.this, ConfirmContact.class);

        intent.putExtra(getResources().getString(R.string.p_nombre), et_Nombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_telefono), et_Telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_correo),et_Correo.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_descripcion), et_Descripcion.getText().toString());
        intent.putExtra(getResources().getString(R.string.p_fnacimiento), getSelectedDate().toString());

        startActivity(intent);

        finish();
    }
}
