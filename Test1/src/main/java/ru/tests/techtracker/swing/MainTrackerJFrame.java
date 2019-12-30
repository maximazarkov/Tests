package ru.tests.techtracker.swing;

import java.awt.*;
import java.util.Map;
import javax.swing.*;

/**
 * Тестовая версия фрейма для графического отображения программы:
 * На данный момент тестовый запуск окна выполняется из модуля MainTrackerJFrameTest().
 * C графикой еще не работал и как привязать к StartUI пока не знаю. Данный функционал будет реализован позднее
 * @version 0.1 30.12.2019
 * @author Azarkov Maxim
 */
public class MainTrackerJFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public MainTrackerJFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Трекер (тестовое окно)");
//            setLocation(x, y);  // Устанавливает положение фрейма
//            setBounds(x, y, width, height);    // Устанавливает положение фрейма
//            dispose();      // Закрывает окно и освобождает все систмные ресурсы, использованные
//            при его сосздании. Понадобится при выходе из меню
        setResizable(false);
    }
}
