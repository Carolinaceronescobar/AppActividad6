package com.example.appactividad6.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appactividad6.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegistroActivity extends AppCompatActivity {

    private TextInputEditText editTextName, editTextLastName, editTextEmail, editTextPassword;
    private MaterialButton buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Cambia a activity_registro.xml

        // Inicializar vistas
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

        // Manejar el clic en el botón Crear Cuenta
        buttonCreateAccount.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String lastName = editTextLastName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Validar si los campos están completos
            if (validateInputs(name, lastName, email, password)) {
                // Mostrar la ventana emergente de éxito
                new AlertDialog.Builder(RegistroActivity.this)
                        .setTitle("Registro exitoso")
                        .setMessage("Hola " + name + ", su cuenta ha sido creada con éxito.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                // Mostrar un mensaje de advertencia si los campos están vacíos
                Toast.makeText(RegistroActivity.this, "Por favor, complete todos los campos.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Método para validar si los campos están completos
    private boolean validateInputs(String name, String lastName, String email, String password) {
        return !TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }
}
