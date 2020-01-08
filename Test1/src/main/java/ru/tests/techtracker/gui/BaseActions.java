package ru.tests.techtracker.gui;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

public class BaseActions implements UserAction {
    private final int key;
    private final String name;

    public BaseActions(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
            return String.format("%s. %s", this.key, this.name);
    }
}
