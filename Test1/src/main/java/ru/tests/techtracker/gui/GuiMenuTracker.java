package ru.tests.techtracker.gui;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiMenuTracker {
    private Input input; // Для хранения ссылки на объект системы ввода
    private Tracker tracker; // ссылка на хранилище
    private List<UserAction> actions = new ArrayList<>(); // массив возможных дейсвий пользователя

    public GuiMenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
//        this.actions.add(new AddItem(1, "Add new Item"));
//        this.actions.add(new DropItem(2, "Drop Item"));
    }

    public JMenuBar createGuiMenu(Font font) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);

        JMenu itemMenu = new JMenu("Item");
        itemMenu.setFont(font);
        fileMenu.add(itemMenu);

        JMenuItem addItemMenu = new JMenuItem("Add Item");
        addItemMenu.setFont(font);
        itemMenu.add(addItemMenu);

        JMenuItem dropItemMenu = new JMenuItem("Drop Item");
        dropItemMenu.setFont(font);
        itemMenu.add(dropItemMenu);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        fileMenu.add(exitItem);
//        exitItem.addActionListener(actionEvent -> dispose());
        exitItem.addActionListener(actionEvent -> System.exit(0));

        menuBar.add(fileMenu);
        return menuBar;
    }

    /**
     * выполнение необходимого действия в зависимости от ключа
     * @param key
     * @since 0.1 08.01.2020
     */
//    public void select(int key) {
//        this.actions.get(key).execute(this.input, this.tracker);
//    }

    /**
     * Метод выводит на экран меню.
     */
//    public void show() {
//        for (UserAction action : this.actions) {
//            if (action != null) {
//                System.out.println(action.info());
//            }
//        }
//    }
}
