package ru.tests.techtracker.cli;

import ru.tests.techtracker.cli.MenuOutException;
import ru.tests.techtracker.input.Input;

public class ValidateInput implements Input {
    /**
     * Композиция...
     * класс ValidateInput, реализующий интерфейс Input. В нем переопределен метод ask таким образом,
     * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
     */
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String quastion) {
        return this.input.ask(quastion);
    }
    public int ask(String quastion, int[] range) {

        /**
         * инициализируем условие выхода из цикла опроса клавиатуры. Если ошибок нет, то клавиатура опрашивается
         * без замечаний и возвращается номер нажато клавищи. Если допущен случай исключения, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(quastion, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        } while (invalid);
        return value;
    }
}
