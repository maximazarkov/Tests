package ru.tests.techtracker.gui;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

public interface UserAction {
    /**
     * метод, возвращающий ключ операции
     * @return key - ключ
     * @since 0.1 08.01.2020
     */
    int key();

    /**
     * основной метод выполняющий операцию над заявкой
     * @param input - система ввода
     * @param tracker - хранилище
     * @since 0.1 08.01.2020
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод, возвращающий информацию о данном пункте
     * @return - строка меню
     * @since 0.1 08.01.2020
     */
    String info();
}
