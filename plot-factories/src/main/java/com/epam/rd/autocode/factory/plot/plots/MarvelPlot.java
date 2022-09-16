package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarvelPlot implements Plot {

    private final Character [] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
   asText();
    }

    private String getNamesOFHeroes() {
        String stream;
        if(heroes.length <= 1) {
            stream = Stream.of(heroes)
                    .map(x -> "the brave " + x.name())
                    .collect(Collectors.joining(", "));
        }
        else {
            String stream1 = Stream.of(heroes)
                    .map(x -> "the brave " + x.name())
                    .limit(heroes.length - 1)
                    .collect(Collectors.joining(", "));
            String stream2 = " and the brave " + heroes[heroes.length-1].name();

            stream = stream1 + stream2;
        }

        return stream;
    }

    @Override
    public String asText() {
        StringBuilder sb = new StringBuilder();

        if(heroes.length <= 1 ) {
            sb.append(epicCrisis.name());
            sb.append(" threatens the world. But ");
            sb.append(getNamesOFHeroes());
            sb.append(" is on guard. So, no way that intrigues of ");
            sb.append(villain.name());
            sb.append(" will bend the willpower of the inflexible hero.");
        }
        else {
            sb.append(epicCrisis.name());
            sb.append(" threatens the world. But ");
            sb.append(getNamesOFHeroes());
            sb.append(" are on guard. So, no way that intrigues of ");
            sb.append(villain.name());
            sb.append(" will bend the willpower of inflexible heroes.");
        }

        return sb.toString();
    }
}
