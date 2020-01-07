package ru.tests.techtracker.gui;

import ru.tests.techtracker.input.Input;

public class GuiInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 1 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public GuiInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String quastion) {
        return null;
    }

    @Override
    public int ask(String quastion, int[] range) {
        return 0;
    }
}
