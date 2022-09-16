package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Branch {

    private final String name;
    private Repository repository;
    public List<Commit> commitList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Commit> getCommitList() {
        return commitList;
    }

    public Branch(Repository repository, String name) {
        this(name);
        this.repository = repository;
    }

    public Branch(final String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Branch branch = (Branch) o;
        return name.equals(branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public Repository getRepository() {
        return repository;
    }
}
