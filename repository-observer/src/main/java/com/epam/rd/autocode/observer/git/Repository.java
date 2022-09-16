package com.epam.rd.autocode.observer.git;

import java.util.List;

public interface Repository {
    Branch getBranch(String name);
    Branch newBranch(Branch sourceBranch, String name);

    Commit commit(Branch branch, String author, String[] changes);
    void merge(Branch sourceBranch, Branch targetBranch);

    void addWebHook(WebHook webHook);

    List<Event> events();
}