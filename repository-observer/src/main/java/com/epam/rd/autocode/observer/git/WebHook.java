package com.epam.rd.autocode.observer.git;

import java.util.List;

public interface WebHook {
    String branch();
    Event.Type type();
    List<Event> caughtEvents();
    List<Event> previousEvents();
    Branch getBranch();
    void setBranch(Branch branch);
    void onEvent(Event event);
}
