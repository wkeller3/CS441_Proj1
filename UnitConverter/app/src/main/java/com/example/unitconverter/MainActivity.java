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

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private double value;
    private TextView answer;
    private Button b;
    private Spinner unit1;
    private Spinner unit2;
    private Spinner numDigits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.box);
        answer = (TextView)findViewById(R.id.answer);
        b = (Button)findViewById(R.id.button);
        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        numDigits = findViewById(R.id.numDigits);
        String[] items = new String[]{"in","ft","yd", "cm", "m"};
        String[] digits = new String[]{"1","2","3","4","5","6"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, digits);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        numDigits.setAdapter(adapt);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value = Double.parseDouble(input.getText().toString());
                String u1 = unit1.getSelectedItem().toString();
                String u2 = unit2.getSelectedItem().toString();
                String d = numDigits.getSelectedItem().toString();
                double txt;

                if(u1.equals("in") && u2.equals("ft")){             //in -> ft

                    //answer.setText(Double.toString(value/12) + u2);
                    txt = value/12;

                } else if(u1.equals("in") && u2.equals("yd")){      //in -> yd

                    //answer.setText(Double.toString(value/36) + u2);
                    txt = value/36;

                } else if(u1.equals("in") && u2.equals("cm")){      //in -> cm

                    //answer.setText(Double.toString(value*2.54) + u2);
                    txt = value*2.54;

                } else if(u1.equals("in") && u2.equals("m")){       //in -> m

                    //answer.setText(Double.toString(value/39.37) + u2);
                    txt = value/39.37;

                } else if(u1.equals("ft") && u2.equals("in")){      //ft -> in

                    //answer.setText(Double.toString(value*12) + u2);
                    txt = value*12;

                } else if(u1.equals("ft") && u2.equals("yd")){      //ft -> yd

                    //answer.setText(Double.toString(value/3) + u2);
                    txt = value/3;

                } else if(u1.equals("ft") && u2.equals("cm")){      //ft -> cm

                    //answer.setText(Double.toString(value*30.48) + u2);
                    txt = value*30.48;

                } else if(u1.equals("ft") && u2.equals("m")){       //ft -> m

                    //answer.setText(Double.toString(value/3.2808) + u2);
                    txt = value/3.2808;

                } else if(u1.equals("yd") && u2.equals("in")){      //yd -> in

                    //answer.setText(Double.toString(value*36) + u2);
                    txt = value*36;

                } else if(u1.equals("yd") && u2.equals("ft")){      //yd -> ft

                    //answer.setText(Double.toString(value*3) + u2);
                    txt = value*3;

                } else if(u1.equals("yd") && u2.equals("cm")){        //yd -> cm

                    //answer.setText(Double.toString(value*91.44) + u2);
                    txt = value*91.44;

                } else if(u1.equals("yd") && u2.equals("m")){        //yd -> m

                    //answer.setText(Double.toString(value/1.0936) + u2);
                    txt = value/1.0936;

                } else if(u1.equals("cm") && u2.equals("in")){        //cm -> in

                    //answer.setText(Double.toString(value/2.54) + u2);
                    txt = value/2.54;

                } else if(u1.equals("cm") && u2.equals("ft")){        //cm -> ft

                    //answer.setText(Double.toString(value/30.48) + u2);
                    txt = value/30.48;

                } else if(u1.equals("cm") && u2.equals("yd")){        //cm -> yd

                    //answer.setText(Double.toString(value/91.44) + u2);
                    txt = value/91.44;

                } else if(u1.equals("cm") && u2.equals("m")){        //cm -> m

                    //answer.setText(Double.toString(value/100) + u2);
                    txt = value/100;

                } else if(u1.equals("m") && u2.equals("in")){        //m -> in

                    //answer.setText(Double.toString(value*39.37) + u2);
                    txt = value*39.37;

                } else if(u1.equals("m") && u2.equals("ft")){        //m -> ft

                    //answer.setText(Double.toString(value*3.2808) + u2);
                    txt = value*3.2808;

                } else if(u1.equals("m") && u2.equals("yd")){        //m -> yd

                    //answer.setText(Double.toString(value*1.0936) + u2);
                    txt = value*1.0936;

                } else if(u1.equals("m") && u2.equals("cm")){        //m -> cm

                    //answer.setText(Double.toString(value*100) + u2);
                    txt = value*100;

                } else{                                             //units equal, don't convert

                    //answer.setText(Double.toString(value) + u2);
                    txt = value;

                }

                if(d.equals("1")){

                    answer.setText(String.format("%.1f",txt) + u2);

                } else if(d.equals("2")){

                    answer.setText(String.format("%.2f",txt) + u2);

                } else if(d.equals("3")){

                    answer.setText(String.format("%.3f",txt) + u2);

                } else if(d.equals("4")){

                    answer.setText(String.format("%.4f",txt) + u2);

                } else if(d.equals("5")){

                    answer.setText(String.format("%.5f",txt) + u2);

                } else{

                    answer.setText(String.format("%.6f",txt) + u2);

                }

            }
        });
    }
}
