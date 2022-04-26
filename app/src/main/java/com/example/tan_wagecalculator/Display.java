package com.example.tan_wagecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {


    TextView txtemployeeName,txtemployeeType,txthoursWorked,txtwageTotal,txttotalOTWage,txttotalOTHours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display);


        txtemployeeName= findViewById(R.id.InsertName);
        txtemployeeType = findViewById(R.id.empTypes);
        txthoursWorked = findViewById(R.id.WorkedHours);
        txtwageTotal = findViewById(R.id.CalculateWage);
        txttotalOTWage = findViewById(R.id.totalOTwage);
        txttotalOTHours = findViewById(R.id.totalOThours);


        Intent i = getIntent();

        String empTypes = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtemployeeName.setText("Employee Name: " +EmployeeName);
        txtemployeeType.setText("Employee Type: " + String.valueOf(empTypes));
        txthoursWorked.setText("Hours Rendered: "+ String.valueOf(EmployeeHours));

        calcWage (empTypes,EmployeeHours,txtwageTotal);

    } public void calcWage(String empTypes, Double WorkedHours, TextView txtWage){
            Double totalWage = 0.0;




            if(WorkedHours > 8.0){
                //overtime hours code
            }
            else{
                if(empTypes.equals("Full-time")){
                    totalWage = WorkedHours * 100;
                    txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                }
                else if(empTypes.equals("Part-time")){
                    totalWage = WorkedHours * 75;
                    txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                }
                else{
                    totalWage = WorkedHours * 90;
                    txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                }
            }
        }
    }
