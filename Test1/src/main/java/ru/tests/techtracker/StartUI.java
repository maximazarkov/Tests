package ru.tests.techtracker;

import ru.tests.techtracker.input.ConsoleInput;
import ru.tests.techtracker.input.Input;

/**
 * Основной модуль приложения
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1 29.12.2019
 */
public class StartUI {
    private static final int EXIT = 0; //Константа для выхода из прогграммы (цикла).
    private final Input input; //  Получение данных от пользователя.
 //   private final Tracker tracker; // Хранилище заявок

//    public StartUI(Input input, Tracker tracker) {
public StartUI(Input input) {
        this.input = input;
 //       this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            int select = Integer.valueOf(this.input.ask("Выберите действие: "));
            if (select == EXIT) {
                exit = true;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню:");

    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
//        Input input = new StubInput(new String[] {"add task"});
        new StartUI(input).init();
    }

}
