# 2022-05-otus-spring-Kordyukova
<br>
Первое задание
<br>
Реализовать приложение с помощью Spring IoC. Результат: простое приложение, сконфигурированное XML-контекстом.
<br>
Описание/Пошаговая инструкция выполнения домашнего задания:
<br>
Описание задания:
<br>
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
<br>
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
<br>
Приложение должна просто вывести вопросы теста из CSV-файла с возможными вариантами ответа (если имеются).
<br>
Требования:
<br>
1.В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).
<br>
2.Все классы в приложении должны решать строго определённую задачу (см. п. 18-19 "Правила оформления кода.pdf", прикреплённые к материалам занятия).
<br> 
3.Контекст описывается XML-файлом.
<br> 
4.Все зависимости должны быть настроены в IoC контейнере.
<br> 
5.Имя ресурса с вопросами (CSV-файла) необходимо захардкодить строчкой в XML-файле с контекстом.
<br> 
6.CSV с вопросами читается именно как ресурс, а не как файл.
<br> 
7.Scanner, PrintStream и другие стандартные типы в контекст класть не нужно!
<br> 
8.Весь ввод-вывод осуществляется на английском языке.
<br> 
9.Крайне желательно написать юнит-тест какого-нибудь сервиса (оцениваться будет только попытка написать тест).
<br>
<br>
-------------------------------------------------------------------------------------------------------------

<br>
Второе задание
<br>
Новый функционал:
<br>
Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
<br>
Выполняется на основе предыдущего домашнего задания + , собственно, сам функционал тестирования.
<br>
Требования:
<br>
Переписать конфигурацию в виде Java + Annotation-based конфигурации.
<br>
Добавить функционал тестирования студента.
<br>
Добавьте файл настроек для приложения тестирования студентов.
<br>
В конфигурационный файл можно поместить путь до CSV-файла, количество правильных ответов для зачёта - на Ваше усмотрение.
<br>
Если Вы пишите интеграционные тесты, то не забудьте добавить аналогичный файл и для тестов.
<br>
Scanner, PrintStream и другие стандартные типы в контекст класть не нужно!
<br>
Ввод-вывод на английском языке.
<br>
<br>
-------------------------------------------------------------------------------------------------------------
<br>
Третье задание
<br>
Создать проект, используя Spring Boot Initializr (https://start.spring.io)
<br>
Перенести приложение проведения опросов из прошлого домашнего задания.
<br>
Перенести все свойства в application.yml
<br>
Локализовать выводимые сообщения и вопросы (в CSV-файле). MesageSource должен быть из автоконфигурации Spring Boot.
<br>
Сделать собственный баннер для приложения.
<br>
Перенести тесты и использовать spring-boot-test-starter для тестирования
<br>
*Опционально:
использовать ANSI-цвета для баннера. Если язык отличается от русского и английского - локализовать в нём.
<br>
<br>
-------------------------------------------------------------------------------------------------------------
<br>
Четвертое задание
<br>
1.Подключить Spring Shell, используя spring-starter.
<br>
2.Написать набор команд, позволяющий проводить опрос.
3.Написать Unit-тесты с помощью spring-boot-starter-test, учесть, что Spring Shell в тестах нужно отключить. Набор команд зависит только от Вашего желания. Вы можете сделать одну команду, запускающую Ваш Main, а можете построить полноценный интерфейс на Spring Shell.
<br>
<br>
<br> 
Автор: Кордюкова Галина Юрьевна, группа spring-2022-05
