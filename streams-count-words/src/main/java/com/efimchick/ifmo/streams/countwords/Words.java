package com.efimchick.ifmo.streams.countwords;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Words {

    // Условия:
    // 1) Формат записи слов:  «котик - 23\n».
//    "\\P{javaLetter}+"
    // 2) Пропустить слова до 4 символов
    // 3) Пропустить слова встречающиеся менее 10 раз
    // 4) Отсортировать по сумме
    // 5) Отсортировать в алфавитном порядке

    private final int MIN_SIZE_OF_WORDS = 4;
    private final int MIN_AMOUNT_OF_WORDS = 10;
    private final String REGEX = "\\P{javaLetter}+";


    public String countWords(List<String> lines) {
            String string = lines.stream()
                    .flatMap(line -> Arrays.stream(line.split(REGEX)).map(String::toLowerCase))
                    .filter(x -> x.length() >= MIN_SIZE_OF_WORDS)
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                    // collect(Collector collector) – метод собирает все элементы в список,
                    // множество или другую коллекцию, сгруппировывает элементы по какому-нибудь
                    // критерию, объединяет всё в строку и т.д.:
                    .entrySet()
                    //Метод entrySet(), объявленный интерфейсом Map, возвращает Set,
                    // содержащий записи Map. Каждый из этих элементов является
                    // объектом Map. Entry.
                    .stream()
                    .filter(collectorListEntry -> collectorListEntry.getValue() >= MIN_AMOUNT_OF_WORDS)
                    .sorted(Map.Entry.comparingByKey())
                    .sorted((o1,o2) -> o2.getValue().compareTo(o1.getValue()))
                    .map(stringLongEntry -> String.format("%s - %d\n", stringLongEntry.getKey(), stringLongEntry.getValue()))
                    .collect(Collectors.joining());

            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }


}
