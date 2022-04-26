package com.example.tan_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText InsertName, WorkedHours;
    RadioButton btnSelected;
    RadioGroup employeeTypes;
    Button CalculateWage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Edit Text
        InsertName = findViewById(R.id.InsertName);
        WorkedHours = findViewById(R.id.WorkedHours);

        //RadioGroup
        employeeTypes = findViewById(R.id.employeeTypes);

        //Button
        CalculateWage = findViewById(R.id.CalculateWage);

        //Button On Click Listener
        //CalculateWage.setOnClickListener(this);
        //InsertName.setOnClickListener(this);
        //WorkedHours.setOnClickListener(this);
        //FullTime.setOnClickListener(this);
        //PartTime.setOnClickListener(this);
        //Probationary.setOnClickListener(this);
        CalculateWage.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CalculateWage:
                int SelectedEmployeeType = employeeTypes.getCheckedRadioButtonId();

               btnSelected = findViewById(SelectedEmployeeType);

                String type = (btnSelected.getText().toString());
                String name = (InsertName.getText().toString());
                String totalHours = WorkedHours.getText().toString();



                Intent intent = new Intent(this, Display.class);


                intent.putExtra("empName", name);
                intent.putExtra("hours", totalHours);
                intent.putExtra("type",type);
                startActivity(intent);

                break;
        }
    }}




