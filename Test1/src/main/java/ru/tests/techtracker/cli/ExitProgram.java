package ru.tests.techtracker.cli;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseActions {
    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        // хоть и в BaseActions нет действий ,все равно исключим эти действия и здесь. т.е. ничего не делаем
//        super.execute(input, tracker, output);
    }
}
