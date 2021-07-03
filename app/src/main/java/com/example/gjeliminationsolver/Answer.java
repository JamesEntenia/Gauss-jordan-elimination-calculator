package com.example.gjeliminationsolver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Answer extends AppCompatActivity {

    ListView AnswerIV;
    double[][] Equations;
    double[][]OriginalEquation = new double[3][4];
    ArrayList<String> MultipliedRow = new ArrayList<>();
    TextView Ans;
    EditText Equation1,Equation2,Equation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        getSupportActionBar().hide();

        Equation1 = (EditText) findViewById(R.id.Equation1);
        Equation2 = (EditText) findViewById(R.id.Equation2);
        Equation3 = (EditText) findViewById(R.id.Equation3);
        AnswerIV = (ListView) findViewById(R.id.Answer_ListView);
        Ans = (TextView) findViewById(R.id.Answer);


        CollectEquation();
        Calculator();
        Correction();

        Equation_adapter EQAdapter = new Equation_adapter(Answer.this, Display,MultipliedRow);
        AnswerIV.setAdapter(EQAdapter);

    }

    public void Correction(){
        try {
            Counter--;
            Equation1.setText(OriginalEquation[0][0] + "(" + Display[Counter][0][3] + ")" + PorN(OriginalEquation[0][1]) + "(" + Display[Counter][1][3] + ")" + PorN(OriginalEquation[0][2]) + "(" + Display[Counter][2][3] + ") = " + OriginalEquation[0][3] +
                    "\n     " + round((OriginalEquation[0][0] * Display[Counter][0][3]) + (OriginalEquation[0][1] * Display[Counter][1][3]) + (OriginalEquation[0][2] * Display[Counter][2][3]),2) + " = " + OriginalEquation[0][3]);

            Equation2.setText(OriginalEquation[1][0] + "(" + Display[Counter][0][3] + ")" + PorN(OriginalEquation[1][1]) + "(" + Display[Counter][1][3] + ")" + PorN(OriginalEquation[1][2]) + "(" + Display[Counter][2][3] + ") = " + OriginalEquation[1][3] +
                    "\n     " + round((OriginalEquation[1][0] * Display[Counter][0][3]) + (OriginalEquation[1][1] * Display[Counter][1][3]) + (OriginalEquation[1][2] * Display[Counter][2][3]),2) + " = " + OriginalEquation[1][3]);

            Equation3.setText(OriginalEquation[2][0] + "(" + Display[Counter][0][3] + ")" + PorN(OriginalEquation[2][1]) + "(" + Display[Counter][1][3] + ")" + PorN(OriginalEquation[2][2]) + "(" + Display[Counter][2][3] + ") = " + OriginalEquation[2][3] +
                    "\n     " + round((OriginalEquation[2][0] * Display[Counter][0][3]) + (OriginalEquation[2][1] * Display[Counter][1][3]) + (OriginalEquation[2][2] * Display[Counter][2][3]),2) + " = " + OriginalEquation[2][3]);
        }catch (Exception e){
            Toast.makeText(Answer.this,e.toString(),Toast.LENGTH_LONG).show();
        }

    }

    public String PorN(double a){
        if(a >= 0)
            return "+"+a;
        else
            return ""+a;
    }

    double[][][] Display = new double[9][3][4];
    int Counter = 0;
    public void Calculator(){



        for(int Row = 0;Row < 3;Row++){

            double Original = Equations[Row][Row];

            //Loop to make 100,010,001
            copy();
            for(int EachColumn = 0;EachColumn < 4;EachColumn++){

                Equations[Row][EachColumn] = round((1/Original)*(Equations[Row][EachColumn]),2);
                Display[Counter][Row][EachColumn] = Equations[Row][EachColumn];
            }
            Counter++;
            MultipliedRow.add(round(1/Original,2)+" * Row"+((int) Row+1));
            //Loop to make 0

            for(int RowP2 = 0;RowP2 < 3;RowP2++){

                double OriginalP2 = -(Equations[RowP2][Row]);
                if(RowP2 != Row){
                    copy();
                }
                for(int Column = 0; Column < 4;Column++){

                    if(RowP2 != Row){
                        Equations[RowP2][Column] = round(((OriginalP2) * Equations[Row][Column])+(Equations[RowP2][Column]),2);
                        Display[Counter][RowP2][Column] = Equations[RowP2][Column];
                    }
                }

                if(RowP2 != Row){
                    Counter++;
                    MultipliedRow.add(round(OriginalP2,2)+" * Row"+((int) Row+1)+" + Row"+((int) RowP2+1) );
                }
            }

        }
    }

    public void CollectEquation(){

        Intent intent = getIntent();
        double[][] Collector = {intent.getDoubleArrayExtra("FirstEquation"),
                intent.getDoubleArrayExtra("SecondEquation"),
                intent.getDoubleArrayExtra("ThirdEquation")};
        Equations = Collector;
    }

    public double round(double value,int places){
        if(places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp/factor;
    }


    public void copy(){
        for(int RowP3 = 0; RowP3 < 3;RowP3++){

            for(int Column = 0;Column < 4;Column++) {
                Display[Counter][RowP3][Column] = Equations[RowP3][Column];

                if(Counter == 0){
                    OriginalEquation[RowP3][Column] = Equations[RowP3][Column];
                }

            }
        }
    }

}
