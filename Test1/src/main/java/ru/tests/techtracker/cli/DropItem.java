package ru.tests.techtracker.cli;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import java.util.function.Consumer;

public class DropItem extends BaseActions {
    public DropItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("----------------- Удаление заявки -----------------");
        String id = input.ask("Введите Id заявки, для ее удаления :");
        if (tracker.delete(id)) {
            System.out.println("--------------- Заявка удалена ----------------");
        } else {
            System.out.println("-------------- Заявка НЕ УДАЛЕНА!--------------");
        }
    }
}
