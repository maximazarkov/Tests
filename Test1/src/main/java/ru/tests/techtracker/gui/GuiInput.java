package ru.tests.techtracker.gui;

import ru.tests.techtracker.exceptions.MenuOutException;
import ru.tests.techtracker.input.Input;

public class GuiInput implements Input {

    /**
     * @deprecated
     * @param quastion - пункт меню
     * @return
     */
    @Override
    public String ask(String quastion) {
        return null;
    }

    @Override
    public int ask(String quastion, int[] range) {

        int key = Integer.valueOf(this.ask(quastion));
        // провгоним значние через диапазон меню
        for (int value : range) {
            if (value == key) {
                break;
            }
        }
        return key;
    }
}
