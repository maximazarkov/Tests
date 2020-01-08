package ru.tests.techtracker.cli;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import java.util.function.Consumer;

public class BaseActions implements UserAction {

    private final int key;
    private final String name;

    protected BaseActions(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {

    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
