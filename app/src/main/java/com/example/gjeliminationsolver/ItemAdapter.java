package com.example.gjeliminationsolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater Minflater;
    TextView FirstX,FirstY,FirstZ,SecondX,SecondY,SecondZ,ThirdX,ThirdY,ThirdZ,FirstF,SecondF,ThirdF;
    ArrayList<double[][]> Equations;
    Context context;
    public ItemAdapter(Context c, ArrayList<double[][]> e){
        Equations = e;
        context = c;
    }

    @Override
    public int getCount() {
        return Equations.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if(Minflater == null) {
            Minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(v == null) {
            v = Minflater.inflate(R.layout.each_listview, null);
        }

        //FirstX = (TextView) v.findViewById(R.id.LVFirstX);
        //FirstX.setText("Oppasdasdasdasdfsdfadsfasdfasdfasdf");
        /*FirstY = (TextView) v.findViewById(R.id.LVFirstY);
        FirstZ = (TextView) v.findViewById(R.id.LVFirstZ);
        FirstF = (TextView) v.findViewById(R.id.LVFirstF);
        SecondX = (TextView) v.findViewById(R.id.LVSecondX);
        SecondY = (TextView) v.findViewById(R.id.LVSecondY);
        SecondZ = (TextView) v.findViewById(R.id.LVSecondZ);
        SecondF = (TextView) v.findViewById(R.id.LVSecondF);
        ThirdX = (TextView) v.findViewById(R.id.LVThirdX);
        ThirdY = (TextView) v.findViewById(R.id.LVThirdY);
        ThirdZ = (TextView) v.findViewById(R.id.LVThirdF);
        ThirdF = (TextView) v.findViewById(R.id.LVThirdF);

        double[][] Equation = Equations.get(position);

        FirstX.setText(Equation[0][0]+"sdafasdf");
        FirstY.setText(Equation[0][1]+"sdf");
        FirstZ.setText(Equation[0][2]+"asdfsadf");
        FirstF.setText(Equation[0][3]+"sdfsdf");
        SecondX.setText(Equation[1][0]+"sdfsadf");
        SecondY.setText(Equation[1][1]+"sadfsdfa");
        SecondZ.setText(Equation[1][2]+"sdfsdf");
        SecondF.setText(Equation[1][3]+"sdfsadf");
        ThirdX.setText(Equation[2][0]+"sdfasdf");
        ThirdX.setText(Equation[2][1]+"asdfasdf");
        ThirdX.setText(Equation[2][2]+"sadfsadf");
        ThirdF.setText(Equation[2][3]+"sadfsdf");*/

        return v;
    }
}
