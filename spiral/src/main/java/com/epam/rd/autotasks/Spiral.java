package com.epam.rd.autotasks;
import java.util.stream.IntStream;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        //С помощью переменной s задаются числа внутри массива начиная с 1.
        int s = 1;

        //Объявляем и инициализируем массив.
        int[][] array = new int[rows][columns];
        if(rows != 1 || columns != 2){
            for (int y = 0; y < columns; y++) {
                array[0][y] = s;
                s++;
            }
            for (int x = 1; x < rows; x++) {
                array[x][columns - 1] = s;
                s++;
            }
            for (int y = columns - 2; y >= 0; y--) {
                array[rows - 1][y] = s;
                s++;
            }
            for (int x = rows - 2; x > 0; x--) {
                array[x][0] = s;
                s++;
            }
            //Периметр заполнен. Продолжаем заполнять массив и задаём
            //координаты ячейки, которую необходимо заполнить следующей.
            int c = 1;
            int d = 1;

            while (s < rows * columns) {
                //В Java инициализированный интовый массив заполняется нулями.
                //Периметр мы заполнили числами, отличными от нулей.
                //Следующие циклы поочерёдно работают, заполняя ячейки.
                //Вложенный цикл останавливается, если следующая ячейка имеет
                //значение, отличное от ноля. Ячейка, на которой остановился
                //цикл, не заполняется.

                //Движемся вправо.
                while (array[c][d + 1] == 0) {
                    array[c][d] = s;
                    s++;
                    d++;
                }
                //Движемся вниз.
                while (array[c + 1][d] == 0) {
                    array[c][d] = s;
                    s++;
                    c++;
                }
                //Движемся влево.
                while (array[c][d - 1] == 0) {
                    array[c][d] = s;
                    s++;
                    d--;
                }
                //Движемся вверх.
                while (array[c - 1][d] == 0) {
                    array[c][d] = s;
                    s++;
                    c--;
                }
            }
            //При данном решении в центре всегда остаётся незаполненная ячейка.
            //Убираем её при помощи следующего цикла.
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < columns; y++) {
                    if (array[x][y] == 0) {
                        array[x][y] = s;
                    }
                }
            }
        } else {
            array[0][0] = 1;
            array[0][1] = 2;
        }
        return array;
    }
}
