package com.epam.rd.autotasks;

public class FunctionsTask4 {
    /**
     *
     Створіть функцію sumGeometricElements, що визначає суму перших додатних
     елементів геометричної прогресія дійсних чисел із заданим початковим
     елементом прогресії a1 і заданим кроком прогресії t, в той час як останній
     елемент має бути більшим за заданий alim. an обчислюється
     за формулою (an+1 = an * t), 0<t<1. Результат повинен бути заокруглений до цілого.

     */
    public static double sumGeometricElements(int a1, double t, int alim) {

        // a1 = 8
        // t = 0,5
        // alim = 1
        // a2 = a1 * t = 8 * 0,5 = 4;
        // a3 = a2 * t = 4 * 0,5 = 2
        // a4 = a3 * t = 2 * 0,5 = 1
        // (alim >= a4) =====> break;
        // return sum = a1 + a2 + a3 + a4;

        
    double a = a1;
    double x = a1;
    int sum = 0;

    while (a>= alim){

        a = x * t;
        sum +=a;
        x = a;

        }
    
    return sum;
    }
    
    
    
    
    
}





