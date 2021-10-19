package com.example.mpc;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.mpc.databinding.ActivityMainBinding;

import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public void theMath(View view){

        Button button_send;
        setContentView(R.layout.activity_main);
        button_send = (Button) findViewById(R.id.calculateButton);


        EditText mort_text = (EditText)  findViewById(R.id.mortText);
        String mort = mort_text.getText().toString();
        Double dblMort = Double.parseDouble(mort);

        EditText int_text = (EditText) findViewById(R.id.InterestText);
        String interestVal = int_text.getText().toString();
        Double dblInter = Double.parseDouble(interestVal);

        EditText auth_text = (EditText) findViewById(R.id.authperText);
        String authValue = auth_text.getText().toString();
        Double dblAuth = Double.parseDouble(authValue);



        double interest = dblInter;
        double period = dblAuth;
        double money = dblMort;

        double c = ((interest/100)/12);
        double n = 12*period;
        double top = c*Math.pow(1+c,n);
        double bottom = Math.pow(1+c,n)-1;

        double calculation = money*(top/bottom);

        String Foutput = Double.toString(calculation);


        String outp = getString(R.string.outp, Foutput);


        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your payment is " + calculation, Toast.LENGTH_LONG).show();

                EditText e = (EditText) findViewById(R.id.my_edt_text);
                e.setText(outp);
            }
        });
    }



    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }


    @Override
    public void onClick(View v) {

    }


}