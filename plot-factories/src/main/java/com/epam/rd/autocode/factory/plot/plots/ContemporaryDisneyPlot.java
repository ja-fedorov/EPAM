package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;

public class ContemporaryDisneyPlot implements Plot {


    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlot(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;

    asText();
    }

    @Override
    public String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append("In the beginning, ");
        sb.append(hero.name());
        sb.append(" feels a bit awkward and uncomfortable. But personal issue fades, when a big trouble comes - ");
        sb.append(epicCrisis.name());
        sb.append(". ");
        sb.append(hero.name());
        sb.append(" stands up against it, but with no success at first. But then, by putting self together and with the help of friends, including spectacular, funny ");
        sb.append(funnyFriend.name());
        sb.append(", ");
        sb.append(hero.name());
        sb.append(" restores the spirit, overcomes the crisis and gains gratitude and respect.");

        return sb.toString();
    }
}
