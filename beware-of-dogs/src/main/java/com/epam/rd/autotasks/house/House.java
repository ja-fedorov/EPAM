package com.epam.rd.autotasks.house;

import java.util.ArrayList;
import java.util.List;

public class House <Animal> {

    private final List <Animal> residents = new ArrayList <> ();

    public void enter(Animal resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Animal resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
