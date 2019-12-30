package ru.tests.techtracker;

import org.junit.Before;
import org.junit.Test;
import ru.tests.techtracker.tracker.Item;
import ru.tests.techtracker.tracker.Tracker;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    /*
     *  добавление заявок - public Item add(Item item);
     *  редактирование заявок - public boolean replace(String id, Item item);
     *  удаление заявок - public boolean delete(String id);
     *  получение списка всех заявок - public Item[] findAll();
     *  получение списка по имени - public Item[] findByName(String key);
     *  получение заявки по id - public Item findById(String id);
     */

    Tracker tracker;

    @Before
    public void loadOutputBefore() {
        tracker = new Tracker();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("установить программу", "Установка программы Х", System.currentTimeMillis());
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("установить программу", "Установка программы Х", System.currentTimeMillis());
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("удалить программу", "Удаление программы Х", System.currentTimeMillis());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("удалить программу"));
    }

    @Test
    public void whenDelete2ndItemNameThenReturn1stAnd3rdItem() {
        Item item = new Item("установить программу Х1", "установить программу Х1", System.currentTimeMillis());
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item);
        // Создаем еще пару заявок.
        item = new Item("установить программу Х2", "tустановить программу Х2", System.currentTimeMillis());
        tracker.add(item);
        String idForDelete = item.getId();
        item = new Item("установить программу Х3", "установить программу Х3", System.currentTimeMillis());
        tracker.add(item);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.delete(idForDelete), is(true));
    }

    @Test
    public void whenFindAllThenAllItems() {
        Item item = new Item("установить программу Х1", "установить программу Х1", System.currentTimeMillis());
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item);
        // Создаем еще пару заявок.
        item = new Item("установить программу Х2", "tустановить программу Х2", System.currentTimeMillis());
        tracker.add(item);
        item = new Item("установить программу Х3", "установить программу Х3", System.currentTimeMillis());
        tracker.add(item);
        List<Item> result  = tracker.findAll();
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenFindByNameThenReturn2Items() {
        Item item = new Item("установить программу Х1", "установить программу Х1", System.currentTimeMillis());
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item);
        // Создаем еще пару заявок.
        item = new Item("установить программу Х2", "tустановить программу Х2", System.currentTimeMillis());
        tracker.add(item);
        item = new Item("установить программу Х1", "установить дополнительный модуль к программе Х1", System.currentTimeMillis());
        tracker.add(item);
        ArrayList<Item> allItem  = tracker.findByName("установить программу Х1");
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findByName("установить программу Х1"), is(allItem));
    }

    @Test
    public void whenFindByIdThenReturn2Items() {
        Item item = new Item("установить программу Х1", "установить программу Х1", System.currentTimeMillis());
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item);
        // Создаем еще пару заявок.
        item = new Item("установить программу Х2", "tустановить программу Х2", System.currentTimeMillis());
        tracker.add(item);
        String idForFindId = item.getId();
        item = new Item("установить программу Х1", "установить дополнительный модуль к программе Х1", System.currentTimeMillis());
        tracker.add(item);
        Item result  = tracker.findById(idForFindId);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(idForFindId), is(result));
    }
}
