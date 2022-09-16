package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    private UserStory [] dependsOn;
    private boolean dependencyStatus;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = new UserStory[dependsOn.length];

        this.dependsOn = dependsOn.clone(); // почему без этого клона не работает??
    }

    @Override
    public void complete() {  // разобраться подробней
        dependencyStatus = true;

        for (UserStory x: dependsOn) {
            if (!x.isCompleted()) {
                dependencyStatus = false;
                break;
            }
        }
        if (dependencyStatus) {
            super.complete();
        }
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();
    }


    @Override
    public String toString() {
        return "[US " + getId()+ "] " + getName();
    }
}
