package ru.tests.techtracker.gui;

import java.awt.*;

/**
 * Простейший тест для модуля графического отображения программы:
 * Пока выделенна отдельным main классом, т.к. с графикой еще не работал и как привязать к StartUI пока не знаю.
 * @version 0.1 30.12.2019
 * @author Azarkov Maxim
 */
public class MainTrackerJFrameTest {
    public static void main(String[] args) {
        //Запустим компоненты Swing в потоке диспетчерезации событий, т.е. в том потоке управления,
        // который перейдет компонентам пользовательского интерфейса событий вроде щелчков кнопками
        // мыши или нажатием клавишь: EventQueue.invokeLater(new Runnable()) {public void run() {...}}
        // или javax.swing.SwingUtilites.invokeLater(new Runnable()) {public void run() {...}}
        EventQueue.invokeLater(() -> {
            MainTrackerJFrame frame = new MainTrackerJFrame();
//            frame.setContentPane(new ExamplePaintFrame());
            frame.setVisible(true);
        });
    }
}
