# Репозиторий Максима Азаркова для обучения в выполнения разного рода тестовых задач.

# ВНИМАНИЕ! НА ТЕКУЩИЙ МОМЕТ РАБОТА НАД ДАННОЙ ЗАДАЧЕЙ ПРИОСТАНОВЛЕНА

### Оглавление проекта
**Основные разделы проекты**
+ [Test1. Трекер технической поддержки](#Тест1-Трекер-технической-поддержки)


***
+ [Контакты](#Контакты)
***

## Основные разделы проекта
### Test1. Трекер технической поддержки
Тестовое задание
Вам предлагается написать программу для работы с БД. Все вопросы по заданию можно задавать своему HR-менеджеру.
Ниже описаны требования к программе. Выполнение одного или нескольких необязательных требований оценивается отдельно и будет считаться плюсом в вашу пользу.

Обязательные требования:
1. Программа должна иметь прикладной характер. Например, приложение для автоматизации регистрации постояльцев гостиницы или продажа авиабилетов. Лучше
придумать свою тему.
2. Программа должна сопровождаться четким словесным описанием того, что и в каких объемах она делает.
3. Не нужно создавать супер приложение, достаточно придумать и реализовать небольшой набор функциональности. Но сделать это необходимо качественно.
4. Данные для приложения должны храниться в БД (например HSQLDB).
5. Доступ к БД осуществляется через JPA. Библиотека любая (например, Hibernate).
6. Код должен быть написан на Java 8
7. Интерфейс взаимодействия с пользователем выполнен с помощью SWT.
8. Программа должна работать!

Необязательные требования:
1. Интерфейс разработать в виде RCP приложения, либо через плагин к Eclipse.
2. Код программы покрыт юнит-тестами.

### Описание проблемы (краткий план):
Задачу необходимо решить за 12 дней.
За это время необходимо понять интерфейс клиента с парой функций.
Быбрать и реализовать простуйшу работу с БД. Для начала возможно придется хардкордно.
Если время останется, БД перекрутить на JPA.
И финальной стадией, если опять же останется время, прикрутить графический интерфейс.

### Описание выбранной темы:
Есть клиентское приложение с помощью которого можно сделать заявку на установку и удаление какого-то программного продукта, возможно его модуля. Через эту же оболочку есть возможность связаться с тех. Поддержкой. В будущем, к этой программе можно прикрутить алгоритмы автоматизации обновления.

Есть ещё одно приложение, которое на стороне тех.поддержки позволяет настраивать клиента. Т.е. в ней можно прописать, какие модули удалить, какие поставить, какие особонности в настройках

Все настройки хранятся на сервере. Взаимодействие так же происходит через бд сервера

### Описание работы:
1. При запуске клиентской программы выводится меню (1. Установить программу Х, 2. Удалить программу Х, 3. Обновить статус заявки, 0. Выход) и выводится статус запросов на установку/удаление программного обеспечение Х.
2. Клиент выбирает пункт "1. Установить программу". Запрос отправляется в БД. Возвращается статус выполнения запроса.
3. Администратор запускает свою программу. Загружает список запросов из БД, выполняет настройки и установку или удалени программного обеспечения Х. обновляется статут соотвествующего запроса.
4. У пользователя обновляется по запросу обновляется статус обработки заявки
5. Пункт "2. Удалить программу Х" - отправляет заявку на удаление программы, обновляет статус запросов
6. пункт "3. Обновить статус заявки" делает запрос в БД и получает актуальную информацию по статусам на все заявки. Так же стату обновляется при запуске программы и при отправке любого из запросов.
7. Пункт "0. Выход"


### Описание реализации (подробрый план):
1. Создать описание проекта, базовой функциональность программы (описание работы), сформировать структуру папок [OK]
2. Набросать первый UML [OK]
3. Набросок бизнесс-модели заявки - Item [OK]
4. Набросок модуля для хранения заявок - Tracker и тест для него [OK]
5. Разработать CLI-интерфейс пользователя. 
- Разработать прототип интерфейса для консольного ввода [OK]
- Разработать аналог инферфеса консольного ввода, который имитурует консолный ввода данных пользователей [OK]
- Исправить UML [OK]
- Создать прототип будущего меню. Добавить пункты установить, удалить, обновить статус и выйти. [выполнено частично].
6. На основе интерфеса пользователя разработать CLI-интерфейс админа. Добавить пункты установить, удалить, проверить заявки и выйти.
7. Разработать инферфейс для работы с внешними источниками, будь-то БД или поток IO.
8. Перевести работу с БД на JPA (Hibernate)
9. Заменить Cli-интерфейс на графическую оболочку через интерфес Input [OK].
- Создал в ознакомительных целях первый JFrame [OK]
- подключение тестового интерфейса к проекту [OK]
- адаптация меню под механизм автоматического формирователя, взятого из массива List<UserAction> actions 

### UML проекта:
![UML](/images/Test1/Test1.PNG)

[к оглавлению](#Оглавление-проекта)


### Контакты
Если Вас что-то заинтересовало и у Вас есть вопросы по данному проекту, обращайтесь:
+ Email: aza-maxim@yandex.ru
+ Telegram: @azamaxim

[к оглавлению](#Оглавление-проекта)
