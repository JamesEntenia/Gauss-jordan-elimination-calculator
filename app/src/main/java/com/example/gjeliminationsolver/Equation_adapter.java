package com.example.gjeliminationsolver;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Equation_adapter extends BaseAdapter {

    Context cont;
    double[][][] Equations;
    LayoutInflater mInflater;
    TextView FirstXeq,FirstYeq,FirstZeq,FirstFeq,SecondXeq,SecondYeq,SecondZeq,SecondFeq,ThirdXeq,ThirdYeq,ThirdZeq,ThirdFeq,Row;
    ArrayList<String> MultipliedRow = new ArrayList<>();
    Equation_adapter(Context c, double[][][] e,ArrayList<String> m){
        cont = c;
        Equations = e;
        MultipliedRow = m;

    }
    @Override
    public int getCount() {
        return Equations.length;
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

        if(mInflater == null) {
            mInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(v == null) {
            v = mInflater.inflate(R.layout.each_listview, null);
        }

        FirstXeq = (TextView) v.findViewById(R.id.firstEachLVX);
        FirstYeq = (TextView) v.findViewById(R.id.firstEachLVY);
        FirstZeq = (TextView) v.findViewById(R.id.firstEachLVZ);
        FirstFeq = (TextView) v.findViewById(R.id.firstEachLVF);
        SecondXeq = (TextView) v.findViewById(R.id.SecondEachLVX);
        SecondYeq = (TextView) v.findViewById(R.id.SecondEachLVY);
        SecondZeq = (TextView) v.findViewById(R.id.SecondEachLVZ);
        SecondFeq = (TextView) v.findViewById(R.id.SecondEachLVF);
        ThirdXeq = (TextView) v.findViewById(R.id.ThirdEachLVX);
        ThirdYeq = (TextView) v.findViewById(R.id.ThirdEachLVY);
        ThirdZeq = (TextView) v.findViewById(R.id.ThirdEachLVZ);
        ThirdFeq = (TextView) v.findViewById(R.id.ThirdEachLVF);
        Row = (TextView) v.findViewById(R.id.Row);

        FirstXeq.setText(Equations[position][0][0]+"");
        FirstYeq.setText(Equations[position][0][1]+"");
        FirstZeq.setText(Equations[position][0][2]+"");
        FirstFeq.setText(Equations[position][0][3]+"");
        SecondXeq.setText(Equations[position][1][0]+"");
        SecondYeq.setText(Equations[position][1][1]+"");
        SecondZeq.setText(Equations[position][1][2]+"");
        SecondFeq.setText(Equations[position][1][3]+"");
        ThirdXeq.setText(Equations[position][2][0]+"");
        ThirdYeq.setText(Equations[position][2][1]+"");
        ThirdZeq.setText(Equations[position][2][2]+"");
        ThirdFeq.setText(Equations[position][2][3]+"");
        Row.setText(MultipliedRow.get(position));
        //Row.setText(position+"");

        return v;
    }
}
