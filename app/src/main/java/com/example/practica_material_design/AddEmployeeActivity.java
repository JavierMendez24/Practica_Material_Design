package com.example.practica_material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica_material_design.models.EmployeeModel;
import com.example.practica_material_design.utils.Utils;

import java.util.ArrayList;

public class AddEmployeeActivity extends AppCompatActivity {

    public static ArrayList<EmployeeModel> listaempleados = new ArrayList<>();
    private Button btnAdd;
    private EditText edtName, edtLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        btnAdd = findViewById(R.id.btnAdd);
        edtName = findViewById(R.id.edtName);
        edtLastName = findViewById(R.id.edtLastName);

        btnAdd.setOnClickListener( v -> {
            if(Utils.verifyEditText(edtName) && Utils.verifyEditText(edtLastName)) {
                try{
                    listaempleados.add(new EmployeeModel(R.drawable.android_kotlin, edtName.getText().toString(), edtLastName.getText().toString()));
                    Toast.makeText(AddEmployeeActivity.this, "Agregado", Toast.LENGTH_SHORT).show();
                    finish();
                }catch(Exception e){}

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(AddEmployeeActivity.this, "Abandonando", Toast.LENGTH_SHORT).show();
    }
}