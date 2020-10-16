package com.example.lactemperature;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class NewReleveActivity extends Activity {
    Button selectDate2;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreleve);

        selectDate2 = findViewById(R.id.btnDateNewR);
        date = findViewById(R.id.editTextDate);

        Button btnAnnuler = (Button) findViewById(R.id.btnAnnulerNewR);
        //on va créer un écouteur pour un groupe de boutons
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAnnulerNewR:
                        finish();
                        break;
                    case R.id.btnDateNewR:
                        calendar = Calendar.getInstance();
                        year = calendar.get(Calendar.YEAR);
                        month = calendar.get(Calendar.MONTH);
                        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                        datePickerDialog = new DatePickerDialog(NewReleveActivity.this,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                        date.setText(day + "/" + (month + 1) + "/" + year);
                                    }
                                }, year, month, dayOfMonth);
                        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                        datePickerDialog.show();
                }
            }
        };
        selectDate2.setOnClickListener(ecouteur);
        btnAnnuler.setOnClickListener(ecouteur);

    }
}