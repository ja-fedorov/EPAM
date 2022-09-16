package com.epam.rd.autocode.observer.git;

import java.util.*;

public class RepositoryImpl implements Repository {

    private Map<String, Branch> branchMap = new HashMap<>();
    private List<WebHook> webHooks = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    public RepositoryImpl() {
        branchMap.put("main", new Branch("main"));
    }

    public Branch getBranch(String name) {
        if (!branchMap.containsKey(name)){
            return null;
        }
        if(branchMap.containsKey("main")){

        }
        return branchMap.get(name);
    }

    @Override
    public Branch newBranch(Branch sourceBranch, String name) {

        if(branchMap.containsKey(name) || !branchMap.containsKey(sourceBranch.getName())){
            throw new IllegalArgumentException();
        }

        Branch branch = new Branch(name);
        branch.getCommitList().addAll(sourceBranch.getCommitList());
        branchMap.put(name, branch);

        return branch;
    }

    @Override
    public Commit commit(Branch branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        branch.getCommitList().add(commit);

        Event event = new Event(Event.Type.COMMIT, branch, Collections.singletonList(commit));
        events.add(event);

        notifyWebHooks();

        return commit;
    }

    @Override
    public void merge(Branch sourceBranch, Branch targetBranch) {
        List<Commit> commits = new ArrayList<>();

        sourceBranch.getCommitList().forEach(
                commit -> {
                    if (!targetBranch.getCommitList().contains(commit)) {
                        commits.add(commit);
                        targetBranch.getCommitList().add(commit);
                    }
                }
        );

        if (!commits.isEmpty()) {
            Event event = new Event(Event.Type.MERGE, targetBranch, commits);
            events.add(event);

            notifyWebHooks();
        }

    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
        webHook.previousEvents().addAll(events);
    }

    private void notifyWebHooks() {
        webHooks.forEach(
                webHook -> {
                    events.forEach(
                            event -> {
                                if (event.type() == webHook.type() && webHook.branch().equals(event.branch().getName())
                                        && !webHook.previousEvents().contains(event)) {
                                    webHook.onEvent(event);
                                }
                            }
                    );
                }
        );
    }

    @Override
    public List<Event> events() {
        return events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
