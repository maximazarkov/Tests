@if not exist C:\projects\Tests\Test2_SortingMergeFile goto :error1
@if not exist C:\projects\tmp\resources goto :error2
@echo -------------
@echo Запуск программы без параметров (сработает Demo-версия. создадуться файлы out1.txt и out4.txt в директории C:\projects\tmp\resources)
java -Dfile.encoding=UTF-8 -classpath C:\projects\Tests\Test2_SortingMergeFile\target\classes ru.msf.SortIt
@call :dirtmp

@echo -------------
@echo Запуск программы с параметрами (создасться файл out.txt в директории C:\projects\tmp\resources)
java -Dfile.encoding=UTF-8 -classpath C:\projects\Tests\Test2_SortingMergeFile\target\classes ru.msf.SortIt -i -d out.txt in1.txt in2.txt
@call :dirtmp

:exit
@exit /b

:::::::::::::::::::::::::::::::
::  Выведем ресурсную папку для просмотра
:dirtmp
@dir  C:\projects\tmp\resources
@exit /b

:::::::::::::::::::::::::::::::
::Ошибка, ели не создана папка проекта
:error1
@echo Установка проекта:
@echo Проект клонитуется с GitHub в C:\projects\Tests в папку C:\projects\Tests. Собирается командой mvn clear comlile
@echo Затем необходимо в папке C:\projects\tmp\resources создать необходимые файлы. Данная операция необходима только при запуске программы из консоли.
@echo Файлы можно скопировать из директории C:\projects\Tests\Test2_SortingMergeFile\src\msin\java\resources. Данное расположение используется при проверке программы с помощью тестов JUnit.

@exit /b

:::::::::::::::::::::::::::::::
::  ошибка, если не создана ресурсная папака
:error2
@echo Создайте директорию C:\projects\tmp\resources и создайде файлы in*.txt для ввода данных в программу
@exit /b


