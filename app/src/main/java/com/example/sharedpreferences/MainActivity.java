package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.txtEmail);

        //creaando objeto de la clase shared preferences
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        /* el metodo getSharedPreferences obtiene las preferencias guardadas en la app.
         los parametros que recibe son

         1- el nombre del archivo de texto donde se van a guardar las preferencias
         2- el contexto del archivo, privado publico, etc
        */

        //para motrar la preferencia guardada en una caja de texto  o en otro control:

        email.setText(preferences.getString("mail",""));
        /*
        en el metodo getString los parametros son:

        1- un nombre para identificar el parametro que se va a guardar
        2- el valor por defecto al iniciar la app (cuando no existan datos guardados)
        */
    }

    //metodo para el boton guardar
    public void Guardar(View v){
//crear otro objeto sharePreferences  | los mismos parametros: nombre del archivo credo anterirmente y el contexto igual que se declaro antes
        SharedPreferences preferences2 = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences2.edit();
        /*
            ahi se esta creando un objeto de tipo Editor para usar el objeto 'preferences2 y
            editarlo con el metrodo .edit() de la clase Editor
        */

        edit.putString("mail", email.getText().toString());
        /*
        ahi se esta usando el objeto edit y usando en el el metodo putString
        que lo que hace es setear la referencia que se quiere guardar(previamente creada) y asignarla
        a el control donde se quiere mostrar
         */

        //confirmar para guardar preferencias
        edit.commit();
    }

}































