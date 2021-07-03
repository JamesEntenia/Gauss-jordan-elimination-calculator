package com.example.gjeliminationsolver;

import java.util.Scanner;

public class MainClass
{
        public static void main(String[] args){
                
        MainClass myclass = new MainClass();
        
                myclass.ThreeEquation();
                myclass.Calculator();
        }
        double[][] Equations = {{12,-34,8,0},
                                {1,-1,0,200},
                                {0,8,-11,0}};
        public void ThreeEquation(){
                
                Scanner input = new Scanner(System.in);
                
                System.out.println("First Equation:");
                System.out.print("x: ");
                Equations[0][0] = input.nextDouble();
                System.out.print("y: ");
                Equations[0][1] = input.nextDouble();
                System.out.print("z: ");
                Equations[0][2] = input.nextDouble();
                System.out.print("Equals to: ");
                Equations[0][3] = input.nextDouble();
                
                System.out.println("\nSecond Equation:");
                System.out.print("x: ");
                Equations[1][0] = input.nextDouble();
                System.out.print("y: ");
                Equations[1][1] = input.nextDouble();
                System.out.print("z: ");
                Equations[1][2] = input.nextDouble();
                System.out.print("Equals to: ");
                Equations[1][3] = input.nextDouble();
                
                System.out.println("\nThird Equation:");
                System.out.print("x: ");
                Equations[2][0] = input.nextDouble();
                System.out.print("y: ");
                Equations[2][1] = input.nextDouble();
                System.out.print("z: ");
                Equations[2][2] = input.nextDouble();
                System.out.print("Equals to: ");
                Equations[2][3] = input.nextDouble();
                                                                                                                                                                                                     
        }
        
        public void Display(){
                
                for(int Row = 0;Row < 3;Row++){
                        for(int Column = 0;Column < 4;Column++){
                                
                                if(Column == 2)
                                        System.out.print(Equations[Row][Column]+"   |   ");
                                else
                                        System.out.print(Equations[Row][Column]+"      ");
                        }
                        System.out.println();
                }
                System.out.println("----------------------------------------------------");
        }
        
        public void Calculator(){
                
                for(int Row = 0;Row < 3;Row++){
                        
                        double Original = Equations[Row][Row];
                        
                        for(int EachColumn = 0;EachColumn < 4;EachColumn++){
                                
                                Equations[Row][EachColumn] = round((1/Original)*(Equations[Row][EachColumn]),4);
                               
                        }
                        Display(); 
                        for(int RowP2 = 0;RowP2 < 3;RowP2++){
                                double OriginalP2 = -(Equations[RowP2][Row]);
                                for(int Column = 0; Column < 4;Column++){
                                        
                                        if(RowP2 != Row){
                                                Equations[RowP2][Column] = round(((OriginalP2) * Equations[Row][Column])+(Equations[RowP2][Column]),4);
                                        }
                                }
                                
                           Display();     
                           System.out.println(-(Equations[RowP2][Row])+" Row"+(RowP2+1)+"+");
                        }
                        
                }
                
                
                
        }
        
        public double round(double value,int places){
                if(places < 0) throw new IllegalArgumentException();
                
                long factor = (long) Math.pow(10, places);
                value = value * factor;
                long tmp = Math.round(value);
                return (double) tmp/factor;
        }
}
