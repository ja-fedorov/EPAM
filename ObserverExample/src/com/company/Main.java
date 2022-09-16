package com.company;

public class Main {

    public static void main(String[] args) {

        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("Junior Java Developer");
        jobSite.addVacancy("Middle Java Developer");


        Observer firstSub = new Subscriber("Maksim Krivonos - 1");
        Observer secondSub = new Subscriber("Roman Kilimov - 2");

        jobSite.addObserver(firstSub);
        jobSite.addObserver(secondSub);

        jobSite.addVacancy("Senior Java Developer");

        jobSite.removeObserver(firstSub);

        jobSite.removeVacancy("Middle Java Developer");


    }
}
