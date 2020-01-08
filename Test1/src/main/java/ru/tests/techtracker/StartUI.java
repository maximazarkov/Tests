package ru.tests.techtracker;

import ru.tests.techtracker.cli.ConsoleInput;
import ru.tests.techtracker.cli.MenuTracker;
import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.cli.ValidateInput;
import ru.tests.techtracker.tracker.Tracker;

import java.util.function.Consumer;

/**
 * Основной модуль приложения
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1 29.12.2019
 */
public class StartUI {
    private static final int EXIT = 0; //Константа для выхода из прогграммы (цикла).
    private final Input input; //  Получение данных от пользователя.
    private final Tracker tracker; // Хранилище заявок

    /**
     * реализация вывода данных на консоль с помощью функционального интерфейса.
     * @since 0.1 08.01.2020
     */
    private final Consumer<String> output;

    /**
     * прикрутим новый конструктор
     * @param input
     * @param tracker
     * @param output
     */
    StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        init();
    }

    private void init() {
        boolean exit = false;
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker, this.output);
        menuTracker.fillActions();
        int[] range = new int[menuTracker.getActionsLength()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        while (!exit) {
            menuTracker.show();
            int answer = input.ask("Выберите действие: ", range);
            menuTracker.select(answer);
            if (answer == EXIT) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
//        Input input = new StubInput(new String[] {"add task"});
        new StartUI(new ValidateInput(input), new Tracker(), System.out::println).init();
    }

}
