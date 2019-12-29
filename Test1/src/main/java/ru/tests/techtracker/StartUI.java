package ru.tests.techtracker;

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
        ConsoleInput input = new ConsoleInput();
        String name = input.ask("");
        Tracker tracker = new Tracker();
    }

    public static void main(String[] args) {
//        Input input = new ConsoleInput(new String[] {"add task"});
        Input input = new StubInput(new String[] {"add task"});
        new StartUI(input).init();
    }

}
