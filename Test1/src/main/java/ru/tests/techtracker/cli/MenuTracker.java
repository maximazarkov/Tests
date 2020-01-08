package ru.tests.techtracker.cli;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input; // Для хранения ссылки на объект системы ввода
    private Tracker tracker; // ссылка на хранилище
    private List<UserAction> actions = new ArrayList<>(); // массив возможных дейсвий пользователя

    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * длинна массива меню
     * @return - количество пунктов меню
     * @since 0.1 08.01.2020
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new ExitProgram(0, "Exit"));
        this.actions.add(new AddItem(1, "Add new Item"));
        this.actions.add(new DropItem(2, "Drop Item"));
    }

    /**
     * выполнение необходимого действия в зависимости от ключа
     * @param key
     * @since 0.1 08.01.2020
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, this.output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
