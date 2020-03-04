package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFecha, btnHora;
    EditText txtFecha , txtHora;
    int month, day, year, hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();

        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);

    }

    private void initialization() {
        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);

    }

    @Override
    public void onClick(View v) {

        if (v == btnFecha){
            Calendar calendar = Calendar.getInstance();
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH);
            year = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    txtFecha.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                }
            }
            ,day,month,year);
            datePickerDialog.show();
        }
        if (v == btnHora){

            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtHora.setText(hourOfDay+":"+minute);
                }
            },hour,minute,false);

            timePickerDialog.show();

        }

    }
}
