package com.example.tan_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.zip.Checksum;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText InsertName, WorkedHours;
    RadioButton fullTime, partTime, probationary;
    RadioGroup empTypes;
    Button CalculateWage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Edit Text
        InsertName = findViewById(R.id.InsertName);
        WorkedHours = findViewById(R.id.WorkedHours);

        //RadioGroup
        fullTime = findViewById(R.id.fullTime);
        partTime = findViewById(R.id.partTime);
        probationary = findViewById(R.id.probationary);


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
                int selectedEmployeeType = empTypes.getCheckedRadioButtonId();

                fullTime = findViewById(selectedEmployeeType);
                partTime = findViewById(selectedEmployeeType);
                probationary = findViewById(selectedEmployeeType);


                String type1= fullTime.getText().toString();
                String type2= partTime.getText().toString();
                String type3=probationary.getText().toString();
                String name = InsertName.getText().toString();
                String totalHours =WorkedHours.getText().toString();



                Intent intent = new Intent(this, Display.class);


                intent.putExtra("empName", name);
                intent.putExtra("hours", totalHours);
                intent.putExtra("fullTime",type1);
                intent.putExtra("partTime",type2);
                intent.putExtra("probationary",type3);
                startActivity(intent);

                break;
        }
    }}




