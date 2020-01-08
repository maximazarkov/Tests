package ru.tests.techtracker.gui;

import ru.tests.techtracker.input.Input;
import ru.tests.techtracker.tracker.Tracker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

/**
 * Тестовая версия фрейма для графического отображения программы:
 * На данный момент тестовый запуск окна выполняется из модуля MainTrackerJFrameTest().
 * C графикой еще не работал и как привязать к StartUI пока не знаю. Данный функционал будет реализован позднее
 * @version 0.1 30.12.2019
 * @author Azarkov Maxim
 */
public class MainTrackerJFrame extends JFrame {
    private Input input; // Для хранения ссылки на объект системы ввода
    private Tracker tracker; // ссылка на хранилище
//    private static final int DEFAULT_WIDTH = 300;
//    private static final int DEFAULT_HEIGHT = 200;

    public MainTrackerJFrame(Input input, Tracker tracker) {
        super("Трекер (тестовое окно)");
        this.input = input;
        this.tracker = tracker;

        // установим стандартный внешний вид. метод статический, м.б.вызван до создания фрейма MaintrackerFrame frame
        setDefaultLookAndFeelDecorated(true);

        //операция, которая будет выполнена при выходе из программы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // зададим шрифт
        Font font = new Font("Verdana", Font.PLAIN, 11);

        // отступ внутри окна от компонетнов.
        setPreferredSize(new Dimension(270, 225));

        // Подберем оптимальный размер окна с компонентами и т.д.
        pack();

        // Окно по центру экрана можно расположить так
        setLocationRelativeTo(null);

        // запрещаем изменение программы
        setResizable(false);

        //зададим пинтограмму для фрейма
//        Image img = new ImageIcon("icon.gif").getImage();
//        setIconImage(img);

        // main panel
        JPanel panel = new JPanel();
        // укажем построчное раcположение
        panel.setLayout(new FlowLayout());

        //***************//
        // необходимо изучить класс BOX и его методы по "склеиванию" элементов в окне
        //***************//

        // добавим кнопки (пока вручную, затем нужно реализовать вариант автоматического создания кномок
        // или меню, напримере ConsoleInput. рассмотреть вариант создания кнопок или меню фабричным методом
//        JButton btnAddItem = new JButton("Добавить заявку");
//        panel.add(btnAddItem);
//
//        JButton btnDropItem = new JButton("Удалить заявку");
//        panel.add(btnDropItem);
//
//        JButton btnExit = new JButton("Выход");
//        panel.add(btnExit);

        add(panel);

        // работа с меню

        setJMenuBar(new GuiMenuTracker(input, tracker).createGuiMenu(font));


//        // добавим слушателей на мышь
//        btnAddItem.addActionListener(actionEvent -> {
//
//        });
//
//        btnDropItem.addActionListener(actionEvent -> {
//
//        });
//
////        btnExit.addActionListener(actionEvent -> System.exit(0));
//        // dispose() - Закрывает окно и освобождает все систмные ресурсы, использованные при его сосздании.
//        // Обычно применятеся при выходе из меню
//        btnExit.addActionListener(actionEvent -> dispose());

        // добавим слушателей на изменение окна
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                Object[] options = { "Да", "Нет!" };
                int rc = JOptionPane.showOptionDialog(
                        windowEvent.getWindow(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (rc == 0) {
                    windowEvent.getWindow().setVisible(false);
                    System.exit(0);
                } else {
                    windowEvent.getWindow().setVisible(true);
                }
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
    }

    private class AddItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            MainPaint paint1 = new MainPaint("Тест", 100, 100);
            add(paint1);
        }
    }
}
