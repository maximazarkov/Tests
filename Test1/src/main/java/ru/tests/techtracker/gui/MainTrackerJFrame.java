package ru.tests.techtracker.gui;

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
//    private static final int DEFAULT_WIDTH = 300;
//    private static final int DEFAULT_HEIGHT = 200;

    public MainTrackerJFrame() {
        // заголовок.
        // setTitle("Трекер (тестовое окно)")
        super("Трекер (тестовое окно)");

        // установим стандартный внешний вид. метод статический, м.б.вызван до создания фрейма MaintrackerFrame frame
        setDefaultLookAndFeelDecorated(true);

        //операция, которая будет выполнена при выходе из программы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // зададим шрифт
        Font font = new Font("Verdana", Font.PLAIN, 11);

        // получаем размер экрана
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = kit.getScreenSize();
//        int screenHeight = screenSize.height;
//        int screenWidth = screenSize.width;
//
//        // Устанавливает положение фрейма
////        int locationFrameX = screenWidth / 2 - DEFAULT_WIDTH / 2;
////        int locationFrameY = screenHeight / 2 - DEFAULT_HEIGHT / 2;
//        int locationFrameX = screenWidth / 4;
//        int locationFrameY = screenHeight / 4;
////        setLocation(locationFrameX, locationFrameY);

        //задаем ширину и высоту фрейма
//        setSize(screenWidth / 2, screenHeight / 2);
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // отступ внутри окна от компонетнов.
        setPreferredSize(new Dimension(270, 225));

        // Подберем оптимальный размер окна с компонентами и т.д.
        pack();

        // закрепляем окно, в нашем слкчае по центру экрана, по кординатам, определенноым выше
//        setLocationByPlatform(true);
        // Окно по центру экрана можно расположить так
        setLocationRelativeTo(null);

        // Устанавливает положение фрейма и его размер
//        setBounds(locationFrameX, locationFrameY, screenWidth / 2, screenHeight / 2);

        // запрещаем изменение программы
        setResizable(false);

        //зададим пинтограмму для фрейма
//        Image img = new ImageIcon("icon.gif").getImage();
//        setIconImage(img);

        // работа с панелями
//        MainPaint paint = new MainPaint("Example Paint in JFrame (2020)");
        // заменим панель MainPaint paint extends JPanel на
        JPanel panel = new JPanel();
        // укажем построчное рамположение
        panel.setLayout(new FlowLayout());

        // добавим кнопки (пока вручную, затем нужно реализовать вариант автоматического создания кномок
        // или меню, напримере ConsoleInput. рассмотреть вариант создания кнопок или меню фабричным методом
        JButton btnAddItem = new JButton("Добавить заявку");
        panel.add(btnAddItem);

        JButton btnDropItem = new JButton("Удалить заявку");
        panel.add(btnDropItem);

        JButton btnExit = new JButton("Выход");
        panel.add(btnExit);

        add(panel);

        // работа с меню
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
        exitItem.addActionListener(actionEvent -> dispose());

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // добавим слушателей на мышь
        btnAddItem.addActionListener(actionEvent -> {

        });

        btnDropItem.addActionListener(actionEvent -> {

        });

//        btnExit.addActionListener(actionEvent -> System.exit(0));
        // dispose() - Закрывает окно и освобождает все систмные ресурсы, использованные при его сосздании.
        // Обычно применятеся при выходе из меню
        btnExit.addActionListener(actionEvent -> dispose());

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
