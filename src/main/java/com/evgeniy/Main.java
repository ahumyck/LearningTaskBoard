package com.evgeniy;

import com.evgeniy.task.Status;
import com.evgeniy.task.Task;
import com.evgeniy.task.board.DefaultTaskBoard;
import com.evgeniy.task.board.TaskBoard;
import com.evgeniy.task.creation.TaskCreationService;

import java.io.IOException;

public class Main {

    /**
     * Запускать программу тут
     */
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        TaskBoard taskBoard = new DefaultTaskBoard();
        Task task1 = TaskCreationService.getInstance().createTask("Add tasks", "Add some tasks for test");
        Task task2 = TaskCreationService.getInstance().createTask("Show all tasks", "Show all added tasks for test");
        Task task3 = TaskCreationService.getInstance().createTask("Remove any task", "Remove some tasks for test");
        Task task4 = TaskCreationService.getInstance().createTask("Change task's status", "Change status of any task for test");
        Task task5 = TaskCreationService.getInstance().createTask("Show tasks by status", "Show all tasks with same status for test");
        System.out.println("Add.");
        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        taskBoard.addTask(task5);
        /*Task task6 = task1.clone();
        System.out.println(task1.equals(task6));*/
        /*TaskBoard cloneTaskBoard = taskBoard.clone();
        System.out.println(taskBoard.equals(cloneTaskBoard));
        for (int i = 0; i < taskBoard.getAllTask().size(); i++) {
            System.out.println(cloneTaskBoard.getAllTask().get(i));
        }*/
        for (int i = 0; i < taskBoard.getAllTask().size(); i++) {
            System.out.println(taskBoard.getAllTask().get(i));
        }
        System.out.println("Change status.");
        task1.setStatus(Status.CLOSED);
        task2.setStatus(Status.CLOSED);
        task5.setStatus(Status.EXPIRED);
        for (int i = 0; i < taskBoard.getAllTask().size(); i++) {
            System.out.println(taskBoard.getAllTask().get(i));
        }
        //System.out.println("Show tasks by status");
        System.out.println("Remove.");
        taskBoard.removeTask(task1);
        taskBoard.removeTask(1000002L);
        for (int i = 0; i < taskBoard.getAllTask().size(); i++) {
            System.out.println(taskBoard.getAllTask().get(i));
        }
    }
}

