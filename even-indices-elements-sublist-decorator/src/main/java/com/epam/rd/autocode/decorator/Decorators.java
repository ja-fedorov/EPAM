package com.epam.rd.autocode.decorator;

import java.util.*;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
       // throw new UnsupportedOperationException();
        EvenIndexElementsSubList result = new EvenIndexElementsSubList(sourceList);
        return result;
    }

}
