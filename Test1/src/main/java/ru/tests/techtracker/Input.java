package ru.tests.techtracker;

/**
 * Определим контракт (interface) для ввсех вариантов модулей ввода/вывода
 */
public interface Input {
    /**
     * метод проверки введенного значени меню на вхождение его в диапазоно допустимых значений
     * @param quastion - пункт меню
     * @return - ответ, String
     * @since 0.1 29.12.2019
     */
    String ask(String quastion);

    /**
     * метод проверки введенного значени меню на вхождение его в диапазоно допустимых значений
     * @param quastion - пункт меню
     * @param range    - диапазон допустимых занчений меню
     * @return - возвращаем числовое значение меню
     * @since 0.1 29.12.2019
     */
    int ask(String quastion, int[] range);
}
