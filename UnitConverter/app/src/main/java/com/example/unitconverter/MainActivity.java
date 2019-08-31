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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.box);
        answer = (TextView)findViewById(R.id.answer);
        b = (Button)findViewById(R.id.button);
        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        String[] items = new String[]{"in","ft","yd"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value = Double.parseDouble(input.getText().toString());
                //answer.setText(Double.toString(value));
                String u1 = unit1.getSelectedItem().toString();
                String u2 = unit2.getSelectedItem().toString();

                if(u1.equals("in") && u2.equals("ft")){             //in -> ft

                    answer.setText(Double.toString(value/12) + u2);

                } else if(u1.equals("in") && u2.equals("yd")){      //in -> yd

                    answer.setText(Double.toString(value/36) + u2);

                } else if(u1.equals("ft") && u2.equals("in")){      //ft -> in

                    answer.setText(Double.toString(value*12) + u2);

                } else if(u1.equals("ft") && u2.equals("yd")){      //ft -> yd

                    answer.setText(Double.toString(value/3) + u2);

                } else if(u1.equals("yd") && u2.equals("in")){      //yd -> in

                    answer.setText(Double.toString(value*36) + u2);

                } else if(u1.equals("yd") && u2.equals("ft")){      //yd -> ft

                    answer.setText(Double.toString(value*3) + u2);

                } else{                                             //units equal, don't convert

                    answer.setText(Double.toString(value) + u2);

                }
            }
        });

        /*unit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                unit1.getSelectedItem().toString()
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

    }
}
