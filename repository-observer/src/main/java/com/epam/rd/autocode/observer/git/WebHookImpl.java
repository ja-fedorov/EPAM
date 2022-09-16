package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class WebHookImpl implements WebHook{

    private String branchName;
    private Branch branch;
    private Event.Type type;
    private List<Event>caughtEvents = new ArrayList<>();
    private List<Event> previousEvents = new ArrayList<>();

    public WebHookImpl(String branchName, Event.Type type) {
        this.branchName = branchName;
        this.type = type;
    }

    @Override
    public String branch() {
        return branchName;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {

        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        if (!caughtEvents.contains(event)) {
            caughtEvents.add(event);
            if (branch == null)
                branch = event.getBranch();
        }
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public List<Event> previousEvents() {
        return previousEvents;
    }
}
