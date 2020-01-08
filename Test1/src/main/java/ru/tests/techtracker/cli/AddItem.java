package ru.tests.techtracker.cli;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Item;
import ru.tests.techtracker.tracker.Tracker;

import java.util.function.Consumer;

public class AddItem extends BaseActions {
    public AddItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
//        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}
