package com.evgeniy;

import com.evgeniy.files.WorkWithFiles;
import com.evgeniy.task.Task;
import com.evgeniy.task.board.DefaultTaskBoard;
import com.evgeniy.task.board.TaskBoard;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import com.evgeniy.task.reward.PromiseReward;
import com.evgeniy.files.WorkWithFiles.*;
import com.evgeniy.task.reward.Reward;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

public class Main {

    /**
     * Запускать программу тут
     */
    public static void main(String[] args) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        TaskBoard taskBoard = new DefaultTaskBoard();
        /*Reward reward1 = new DefaultReward<>(1000L);
        Reward reward2 = new DefaultReward<>(1500L);
        Reward reward3 = new DefaultReward<>(2000L);
        Reward reward4 = new DefaultReward<>(2500L);
        Reward reward5 = new DefaultReward<>(3000L);*/
        Task task1 = TaskCreationService.getInstance().createTask("Add tasks", "Add some tasks for test", new MoneyReward(1000L));
        Task task2 = TaskCreationService.getInstance().createTask("Show all tasks", "Show all added tasks for test", new BadgeReward("Gold badge"));
        Task task3 = TaskCreationService.getInstance().createTask("Remove any task", "Remove some tasks for test", new PromiseReward("Reward next week"));
        Task task4 = TaskCreationService.getInstance().createTask("Change task's status", "Change status of any task for test", new MoneyReward(2000L));
        Task task5 = TaskCreationService.getInstance().createTask("Show tasks by status", "Show all tasks with same status for test", new MoneyReward(3000L));
        WorkWithFiles.WriteTaskIntoFile(task1, "E:/intellijfiles/task1.txt");
        Task fileTask = WorkWithFiles.ReadTaskFromFile("E:/intellijfiles/task1.txt");
        System.out.println(fileTask);
        System.out.println("Add.");
        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        taskBoard.addTask(task5);

        taskBoard.sort(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                int res = Long.signum(t1.getId() - t2.getId());
                if (res == 0) {
                    return t1.getName().compareTo(t2.getName());
                }
                return res;
            }
        });


        System.out.println(task1.getReward(BadgeReward.class));
        System.out.println(task1.getReward(PromiseReward.class));
        System.out.println(task1.getReward(MoneyReward.class));

        /*Task task6 = task1.clone();
        System.out.println(task1.equals(task6));*/
        /*TaskBoard cloneTaskBoard = taskBoard.clone();
        System.out.println(taskBoard.equals(cloneTaskBoard));
        for (int i = 0; i < taskBoard.getAllTask().size(); i++) {
            System.out.println(cloneTaskBoard.getAllTask().get(i));
        }*/
        for (Task task : taskBoard) {
            System.out.println(task);
        }

        Optional<Task> taskGet = taskBoard.getTaskById(1000002L);
        taskGet.ifPresent(task -> System.out.println(task.getStatus()));

        System.out.println("Write/read task board.");
        WorkWithFiles.WriteTaskBoardIntoFile(taskBoard, "E:/intellijfiles/taskboard1.txt");
        TaskBoard fileTaskBoard = WorkWithFiles.ReadTaskBoardFromFile("E:/intellijfiles/taskboard1.txt");
        if (fileTaskBoard != null) {
            for (Task task : fileTaskBoard) {
                System.out.println(task);
            }
        } else {
            System.out.println("Task board from file is empty!");
        }
        /*System.out.println("Change status.");
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
        }*/
    }
}

