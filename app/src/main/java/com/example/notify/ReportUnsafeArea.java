package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
public class ReportUnsafeArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_report_unsafe_area);
        Button submitButton;


        submitButton = (Button)findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final EditText location= (EditText)findViewById(R.id.editText);
                String locationValue = (String)location.getText().toString();
                Spinner threatenedGender = (Spinner)findViewById(R.id.spinner2);
                String genderThreatened = threatenedGender.getSelectedItem().toString();
                final EditText radiusOfThreat = (EditText)findViewById(R.id.editText2);
                String threatRadius = (String)radiusOfThreat .getText().toString();
                String typeOfIncident = new String();
                int ageGroup = 0;
                String timeOfThreat = new String();
                CheckBox iter;
                int i;
                iter = (CheckBox)findViewById(R.id.checkBox);
                if(iter.isChecked()){
                    typeOfIncident += "1";
                }
                else{
                    typeOfIncident += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox2);
                if(iter.isChecked()){
                    typeOfIncident += "1";
                }
                else{
                    typeOfIncident += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox3);
                if(iter.isChecked()){
                    typeOfIncident += "1";
                }
                else{
                    typeOfIncident += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox4);
                if(iter.isChecked()){
                    typeOfIncident += "1";
                }
                else{
                    typeOfIncident += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox5);
                if(iter.isChecked()){
                    typeOfIncident += "1";
                }
                else{
                    typeOfIncident += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox6);
                if(iter.isChecked()){
                    ageGroup += 1;
                }
                iter = (CheckBox)findViewById(R.id.checkBox7);
                if(iter.isChecked()){
                    ageGroup += 2;
                }
                iter = (CheckBox)findViewById(R.id.checkBox8);
                if(iter.isChecked()){
                    ageGroup += 4;
                }
                iter = (CheckBox)findViewById(R.id.checkBox9);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox10);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox11);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox12);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox13);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }
                iter = (CheckBox)findViewById(R.id.checkBox14);
                if(iter.isChecked()){
                    timeOfThreat += "1";
                }
                else{
                    timeOfThreat += "0";
                }

                String Tag = "My Checks";
                Log.i(Tag,locationValue);
                Log.i(Tag,typeOfIncident);
                Log.i(Tag,genderThreatened);
                Log.i(Tag,threatRadius);
                Log.i(Tag,Integer.toString(ageGroup));
                Log.i(Tag,timeOfThreat);
                int j;
                String[] communicateString = new String[6];
                communicateString[0] = locationValue;
                communicateString[1] = typeOfIncident;
                communicateString[2] = genderThreatened;
                communicateString[3] = threatRadius;
                communicateString[4] = Integer.toString(ageGroup);
                communicateString[5] = timeOfThreat;

                Intent in = new Intent(ReportUnsafeArea.this,MapsReporter.class);
                in.putExtra("communicator",communicateString);
                startActivity(in);
            }

        });

    }

}
