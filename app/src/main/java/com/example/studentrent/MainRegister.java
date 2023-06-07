
package com.example.studentrent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainRegister extends AppCompatActivity {
    EditText editTextUserR, editTextPasswordR, editTextEmailR, editTextPhoneR;
    AdminSQLiteOpenHelper admin;
    User user1 = new User();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserR = findViewById(R.id.editTextUserR);
        editTextPasswordR = findViewById(R.id.editTextPasswordR);
        editTextEmailR = findViewById(R.id.editTextEmailR);
        editTextPhoneR = findViewById(R.id.editTextPhoneR);
        Intent intent = getIntent();
        admin = new AdminSQLiteOpenHelper(this, "bd1", null, 1);

    }
    public void register(View view) {
        //inicializamos o SQLiteDatabase
        SQLiteDatabase db = admin.getWritableDatabase();
        String user1 = editTextUserR.getText().toString();
        ContentValues cuenta = new ContentValues();
        //Obtemos os valores de cada campo para crear a tabla
        cuenta.put("usuario", editTextUserR.getText().toString());
        cuenta.put("contrasinal", editTextPasswordR.getText().toString());
        cuenta.put("correo", editTextEmailR.getText().toString());
        cuenta.put("telefono", editTextPhoneR.getText().toString());
        Cursor fila = db.rawQuery("SELECT email, phoneNumber FROM account WHERE user='" + user1 + "'", null);
        if (!fila.moveToFirst()) {
            db.insert("conta", null, cuenta);
            //un toast de que se creou a conta
            Toast.makeText(this, "Conta creada", Toast.LENGTH_LONG).show();
        }else{
            //Un toast o cal avisa que a conta xa existe
            Toast.makeText(this, "Conta xa existe", Toast.LENGTH_LONG).show();
        }
        //ao crear a conta our se da erro, poñemos os campos en branco
        editTextUserR.setText("");
        editTextPasswordR.setText("");
        editTextEmailR.setText("");
        editTextPhoneR.setText("");
        //cerramos a base de datos
        db.close();
    }
}