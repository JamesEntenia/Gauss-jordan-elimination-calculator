package com.example.gjeliminationsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Solve;
    EditText FirstX,FirstY,FirstZ,FirstF,SecondX,SecondY,SecondZ,SecondF,ThirdX,ThirdY,ThirdZ,ThirdF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        FirstX = (EditText) findViewById(R.id.FirstX);
        FirstY = (EditText) findViewById(R.id.FirstY);
        FirstZ = (EditText) findViewById(R.id.FirstZ);
        FirstF = (EditText) findViewById(R.id.FirstEqual);
        SecondX = (EditText) findViewById(R.id.SecondX);
        SecondY = (EditText) findViewById(R.id.SecondY);
        SecondZ = (EditText) findViewById(R.id.SecondZ);
        SecondF = (EditText) findViewById(R.id.SecondF);
        ThirdX = (EditText) findViewById(R.id.ThirdXLV);
        ThirdY = (EditText) findViewById(R.id.ThirdY);
        ThirdZ = (EditText) findViewById(R.id.ThirdZ);
        ThirdF = (EditText) findViewById(R.id.ThirdF);
        Solve = (Button) findViewById(R.id.SolveBtn);




        CollectEquations();
    }


    public void CollectEquations(){

        Solve.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    double[] FirstEquation = {Double.parseDouble(FirstX.getText().toString()), Double.parseDouble(FirstY.getText().toString()), Double.parseDouble(FirstZ.getText().toString()), Double.parseDouble(FirstF.getText().toString())};
                    double[] SecondEquation = {Double.parseDouble(SecondX.getText().toString()), Double.parseDouble(SecondY.getText().toString()), Double.parseDouble(SecondZ.getText().toString()), Double.parseDouble(SecondF.getText().toString())};
                    double[] ThirdEquation = {Double.parseDouble(ThirdX.getText().toString()), Double.parseDouble(ThirdY.getText().toString()), Double.parseDouble(ThirdZ.getText().toString()), Double.parseDouble(ThirdF.getText().toString())};

                    Intent intent = new Intent(getApplicationContext(),Answer.class);
                    intent.putExtra("FirstEquation",FirstEquation);
                    intent.putExtra("SecondEquation",SecondEquation);
                    intent.putExtra("ThirdEquation",ThirdEquation);
                    startActivity(intent);

                }catch ( Exception e){
                    Toast.makeText(MainActivity.this,"Input must be number only",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
