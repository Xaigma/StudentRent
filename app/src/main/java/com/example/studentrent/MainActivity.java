package com.example.studentrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUser, editTextPassword;
    AdminSQLiteOpenHelper admin;
    User user1 = new User();
    String aux="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        admin = new AdminSQLiteOpenHelper(this, "bd1", null, 1);

    }
    public void login(View view) {
        SQLiteDatabase db = admin.getWritableDatabase();
        //Obtemos un par de variables do usuario e contrasinal para comprar coa base de datos
        String userEdit = editTextUser.getText().toString();
        String passwordEdit = editTextPassword.getText().toString();
        Cursor fila = db.rawQuery("SELECT email, phoneNumber FROM account WHERE user='" + userEdit + "' AND password='" + passwordEdit + "'", null);
        if (fila.moveToFirst()) {
            aux = String.valueOf(editTextUser.getText());
            //En caso de que coincida, accedemos ao menú da aplicación

        } else {
            //en caso contrario amosamos un toast
            Toast.makeText(this, "Non existe unha conta asociada con este usuario", Toast.LENGTH_LONG).show();
            //Cerramos o SQLiteDatabase
            db.close();
        }
        //poñemos os campos en blanco e accedemos ao menú
        aux = String.valueOf(editTextUser.getText());
        editTextUser.setText("");
        editTextPassword.setText("");
        //Este intent accederia ao menú en caso de que o usuario sexa correcto
        Intent intent = new Intent(this, MainActivityNavigationView.class);
        intent.putExtra(aux, user1);
        startActivity(intent);
    }
    public void goRegister(View view){
        Intent intent1 = new Intent(this, MainRegister.class);
        startActivity(intent1);
    }
}