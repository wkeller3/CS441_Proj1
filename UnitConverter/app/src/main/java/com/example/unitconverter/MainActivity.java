package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Editable value;
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
        String[] items = new String[]{"in","ft","mi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value = input.getText();
                answer.setText(value);
            }
        });

    }
}
