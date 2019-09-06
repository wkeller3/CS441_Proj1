package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private double value;
    private double convertedVal;
    private TextView answer;
    private Button b;
    private Button add;
    private Button minus;
    private int count;
    private Spinner unit1;
    private Spinner unit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 2;
        input = (EditText)findViewById(R.id.box);
        answer = (TextView)findViewById(R.id.answer);
        b = (Button)findViewById(R.id.button);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        String[] items = new String[]{"in","ft","yd", "cm", "m"};
        String[] digits = new String[]{"1","2","3","4","5","6"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, digits);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    value = Double.parseDouble(input.getText().toString());
                } catch (Exception e){
                    return;
                }
                count = 2;
                String u1 = unit1.getSelectedItem().toString();
                String u2 = unit2.getSelectedItem().toString();

                if(u1.equals("in") && u2.equals("ft")){             //in -> ft

                    //answer.setText(Double.toString(value/12) + u2);
                    convertedVal = value/12;

                } else if(u1.equals("in") && u2.equals("yd")){      //in -> yd

                    //answer.setText(Double.toString(value/36) + u2);
                    convertedVal = value/36;

                } else if(u1.equals("in") && u2.equals("cm")){      //in -> cm

                    //answer.setText(Double.toString(value*2.54) + u2);
                    convertedVal = value*2.54;

                } else if(u1.equals("in") && u2.equals("m")){       //in -> m

                    //answer.setText(Double.toString(value/39.37) + u2);
                    convertedVal = value/39.37;

                } else if(u1.equals("ft") && u2.equals("in")){      //ft -> in

                    //answer.setText(Double.toString(value*12) + u2);
                    convertedVal = value*12;

                } else if(u1.equals("ft") && u2.equals("yd")){      //ft -> yd

                    //answer.setText(Double.toString(value/3) + u2);
                    convertedVal = value/3;

                } else if(u1.equals("ft") && u2.equals("cm")){      //ft -> cm

                    //answer.setText(Double.toString(value*30.48) + u2);
                    convertedVal = value*30.48;

                } else if(u1.equals("ft") && u2.equals("m")){       //ft -> m

                    //answer.setText(Double.toString(value/3.2808) + u2);
                    convertedVal = value/3.2808;

                } else if(u1.equals("yd") && u2.equals("in")){      //yd -> in

                    //answer.setText(Double.toString(value*36) + u2);
                    convertedVal = value*36;

                } else if(u1.equals("yd") && u2.equals("ft")){      //yd -> ft

                    //answer.setText(Double.toString(value*3) + u2);
                    convertedVal = value*3;

                } else if(u1.equals("yd") && u2.equals("cm")){        //yd -> cm

                    //answer.setText(Double.toString(value*91.44) + u2);
                    convertedVal = value*91.44;

                } else if(u1.equals("yd") && u2.equals("m")){        //yd -> m

                    //answer.setText(Double.toString(value/1.0936) + u2);
                    convertedVal = value/1.0936;

                } else if(u1.equals("cm") && u2.equals("in")){        //cm -> in

                    //answer.setText(Double.toString(value/2.54) + u2);
                    convertedVal = value/2.54;

                } else if(u1.equals("cm") && u2.equals("ft")){        //cm -> ft

                    //answer.setText(Double.toString(value/30.48) + u2);
                    convertedVal = value/30.48;

                } else if(u1.equals("cm") && u2.equals("yd")){        //cm -> yd

                    //answer.setText(Double.toString(value/91.44) + u2);
                    convertedVal = value/91.44;

                } else if(u1.equals("cm") && u2.equals("m")){        //cm -> m

                    //answer.setText(Double.toString(value/100) + u2);
                    convertedVal = value/100;

                } else if(u1.equals("m") && u2.equals("in")){        //m -> in

                    //answer.setText(Double.toString(value*39.37) + u2);
                    convertedVal = value*39.37;

                } else if(u1.equals("m") && u2.equals("ft")){        //m -> ft

                    //answer.setText(Double.toString(value*3.2808) + u2);
                    convertedVal = value*3.2808;

                } else if(u1.equals("m") && u2.equals("yd")){        //m -> yd

                    //answer.setText(Double.toString(value*1.0936) + u2);
                    convertedVal = value*1.0936;

                } else if(u1.equals("m") && u2.equals("cm")){        //m -> cm

                    //answer.setText(Double.toString(value*100) + u2);
                    convertedVal = value*100;

                } else{                                             //units equal, don't convert

                    //answer.setText(Double.toString(value) + u2);
                    convertedVal = value;

                }

                answer.setText(String.format("%.2f",convertedVal) + u2);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    value = Double.parseDouble(input.getText().toString());
                } catch (Exception e){
                    return;
                }
                count++;
                String u2 = unit2.getSelectedItem().toString();
                //String txt = ((String)answer.getText()).substring(0,answer.length()-2);

                if(1 == count){

                    answer.setText(String.format("%.1f",convertedVal) + u2);

                } else if(2 == count){

                    answer.setText(String.format("%.2f",convertedVal) + u2);

                } else if(3 == count){

                    answer.setText(String.format("%.3f",convertedVal) + u2);

                } else if(4 == count){

                    answer.setText(String.format("%.4f",convertedVal) + u2);

                } else if(5 == count){

                    answer.setText(String.format("%.5f",convertedVal) + u2);

                } else{

                    count = 6;
                    answer.setText(String.format("%.6f",convertedVal) + u2);

                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    value = Double.parseDouble(input.getText().toString());
                } catch (Exception e){
                    return;
                }
                count--;
                String u2 = unit2.getSelectedItem().toString();
                //String txt = ((String)answer.getText()).substring(0,answer.length()-2);

                if(1 == count){

                    answer.setText(String.format("%.1f",convertedVal) + u2);

                } else if(2 == count){

                    answer.setText(String.format("%.2f",convertedVal) + u2);

                } else if(3 == count){

                    answer.setText(String.format("%.3f",convertedVal) + u2);

                } else if(4 == count){

                    answer.setText(String.format("%.4f",convertedVal) + u2);

                } else if(5 == count){

                    answer.setText(String.format("%.5f",convertedVal) + u2);

                } else{

                    count = 0;
                    answer.setText(String.format("%.0f",convertedVal) + u2);

                }

            }
        });
    }
}
