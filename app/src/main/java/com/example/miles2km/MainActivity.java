package com.example.miles2km;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonGoClick(View view) {
        EditText editTextMinutesMile = findViewById(R.id.editTextMinutesMile);
        String stringMinutesMiles = editTextMinutesMile.getText().toString();

        int intColonPos = stringMinutesMiles.indexOf(':');
        String stringMinutes = stringMinutesMiles.substring(0,intColonPos);
        String stringSeconds = stringMinutesMiles.substring(intColonPos+1);
        int intTotalSeconds =  (Integer.parseInt( stringMinutes ) * 60 ) + Integer.parseInt(stringSeconds);

        double doubleMetersPerSecond = 1609.34 / intTotalSeconds;

        double doubleSecondsPerKilometer = 1000.00 / doubleMetersPerSecond;

        double doubleMinutesPerKilometer = doubleSecondsPerKilometer / 60;

        int intMinutesPerKilometer = (int) doubleMinutesPerKilometer;

        doubleSecondsPerKilometer = doubleMinutesPerKilometer - intMinutesPerKilometer;

        //doubleSecondsPerKilometer = 60 * (doubleSecondsPerKilometer *100);

        doubleSecondsPerKilometer = doubleSecondsPerKilometer * 60;

        String sSecondsPerKilometer = String.valueOf((int)doubleSecondsPerKilometer);

        if ( sSecondsPerKilometer.length() == 1 ) {
            sSecondsPerKilometer = "0" + sSecondsPerKilometer;
        }

        String stringMinutesPerKilometer = String.valueOf( intMinutesPerKilometer ) + ":" + sSecondsPerKilometer;

        EditText editTextMinutesKilometer = findViewById(R.id.editTextMinutesKilometer);

        editTextMinutesKilometer.setText(stringMinutesPerKilometer);

    }
}