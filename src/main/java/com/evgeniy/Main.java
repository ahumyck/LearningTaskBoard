package com.evgeniy;

import com.evgeniy.task.Status;
import com.evgeniy.task.board.TaskBoard;

import com.evgeniy.task.Task;

import java.util.Date;
import java.util.List;

public class Main {

    /**
     * Запускать программу тут
     */
    public static void main(String[] args) {


        /*
            Сначала полностью прочитай!!!
            0. Посмотри видосы (можешь на 1.5х - 2х поставить скорость)
            0.1 https://www.youtube.com/watch?v=ayUbY2sB-IU&ab_channel=alishev
            0.2 https://www.youtube.com/watch?v=wEewTdZEWPY&ab_channel=alishev
            0.3 https://www.youtube.com/watch?v=J8ZLRvOO6vk&ab_channel=alishev
            0.4 https://www.youtube.com/watch?v=zf3lDojNxlA&ab_channel=alishev
            0.5 https://www.youtube.com/watch?v=sPPaDe_5fcQ&ab_channel=alishev
            0.6 https://www.youtube.com/watch?v=KEQ043yT3F4&ab_channel=alishev
            0.7 https://www.youtube.com/watch?v=Muytoo-x-KM&ab_channel=alishev
            0.8 https://www.youtube.com/watch?v=GOzNp1YAm5w&ab_channel=alishev

            1. Делать коммиты в main ветку нельзя: сначала создаешь свою ветку, потом делаешь туда коммит и пуш,
            а после этого мердж реквест в main.  Я делаю апрув, что всё ок, тогда мердж идет в мейн,
            а ты удаляешь свою ветку (ну и создаешь новую соответственно). Если я не делаю апрув, то исправляешь все
            замечания и пробуем ещё раз. Коммиты и пуши, а соотвественно и мердж реквесты лучше всего делать по задачам.
            Сделал первое задание => сделал коммит + пуш, и создал мердж реквест и т.д.


            Общий ход выполнения программы:
            1.1 Реализовать и создать доску объявлений. Например:
            TaskBoard taskBoard = new TaskBoard();
            1.2 Попробовать вывести на консоль все задания из TaskBoard'-a, т.к. она ещё пустая
            можно написать сообщение "Task board is empty" или типа того.

            2.1 Добавить в доску объявлений несколько объявлений через TaskCreationService
            Task task = TaskCreationService.getInstance().createTask(name, description);
            taskBoard.addTask(task);
            2.2 Вывести на консоль красиво все задания из TaskBoard'-a
            Можно просто с помощью System.out.println(...)

            3.1 Удалить несколько любых заданий из таскборада
            3.2 "Выполнить" несколько любых заданий из таскборада (поменять статус)
            3.3 "Провалить" несколько любых заданий (кроме выполненых) из таскборада
            3.4. Вывести на консоль красиво все задания из TaskBoard'-a

            4.1. Вывести на консоль красиво все "Выполненные" задания из TaskBoard'-a
            4.2. Вывести на консоль красиво все "Не выполненные" задания из TaskBoard'-a
            4.3. Вывести на консоль красиво все "Проваленные" задания из TaskBoard'-a


            Если не хватает каких-то классов/интерфейсов/реализаций/методов в классе/интерфейсе -
            надо всё доделать самому, тут я только базу сделал

            Кроме общего выполнения программы также нужно сделать:
            1. Реализовать юнит тесты: (некоторые классы уже есть в src/test/java/...)
                1.1. Написать юнит тест для TaskCreationService:
                     правильно ли он создаёт таски (статус, время создания и т.п.)
                1.2. Написать юнит тест для TaskBoard: проверить удаление, добавление и т.п.

            2. Придумаем что-нибудь, если это норм и быстро сделаешь

         */
    }
}

