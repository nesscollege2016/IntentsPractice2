package ness.tomerbu.edu.intentspractice;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    EditText etQuery;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etQuery = (EditText) findViewById(R.id.etQuery);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
    }


    public void searchGoogle(String query){
        //with What - Uri
        Uri searchUri = Uri.parse("https://www.google.co.il/search?q=" + query);

        //Intent with ACTION(String, What do we wan't to do)
        Intent webIntent = new Intent(Intent.ACTION_VIEW, searchUri);


        startActivity(webIntent);
    }

    void setAlarm(){

    }





    public void searchGoogle(View view) {
        String query = etQuery.getText().toString();
        searchGoogle(query);
    }

    public void setAlarm(View view) {
        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);

        int hour = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();

        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, min);
        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Call Mom!");

        startActivity(alarmIntent);
    }
 
}
