package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    private static <T extends Long> String getStringFromValue (T value) {
        return String.format ("%64s", T.toBinaryString(value)).replace(' ', '0');
    }

    private static int getPositionFromShot (String shot) {
        int column = shot.charAt(0) - 64; // A = код 65, а нам нужно обратно число
        int row = shot.charAt(1) - 49; // "1" = код 49
        return (column - 1) + (row * 8); // По column 1 позиция будет всегда лишняя. По row - у нас 8 линий
    }

    private void writeShot (int shotPosition) {
       // Конвертируем номер в char array
        char [] shotsArray = getStringFromValue(shots).toCharArray();
       // Записываем где он был произведен (выставляя '1')! В ВИДЕ СИМВОЛА!!
       shotsArray [shotPosition] = '1';
       // Возвращаем массив в номера
        shots = Long.parseUnsignedLong(new String (shotsArray), 2);
    }

    public boolean shoot(String shot) {
        // Показываем, где есть корабли
        String field = getStringFromValue (ships);
        // Делаем выстрел
        int shotPosition = getPositionFromShot (shot);
        // Проверяем на успешность попадания
        boolean hit = field.charAt(shotPosition) == '1';
        writeShot(shotPosition);
        return hit;
    }

    public String state() {
        // Делаем два массива с кораблями и выстрелами
        char [] field = getStringFromValue (ships).toCharArray();
        char [] shotsDone = getStringFromValue (shots).toCharArray();
        // Открываем StringBuilder, куда будем вносить данные и сравнивать 2 массива
        StringBuilder fieldAfterShooting = new StringBuilder ();
        // Указываем char, который будем переопределять и выводить ситуацию "в картинках"
        char symbol = '.';
        // Дальше гениальность - сравнение 2 массивов и вывод нужного символа - записывая все в String
        for (int i = 0; i < field.length ; i++) {
            if (field [i] == '0' && shotsDone [i] == '0') {
                symbol = '.';
            }
            if (field [i] == '0' && shotsDone [i] == '1') {
                symbol = '×';
            }
            if (field [i] == '1' && shotsDone [i] == '0') {
                symbol = '☐';
            }
            if (field [i] == '1' && shotsDone [i] == '1') {
                symbol = '☒';
            }
            // Последовательно добавляем в StringBuilder
            fieldAfterShooting.append(symbol);
            // Делаем прямоугольник
            if ((i+1)%8 == 0) {
                fieldAfterShooting.append("\n");
            }
        }
        return new String(fieldAfterShooting);
    }
}
