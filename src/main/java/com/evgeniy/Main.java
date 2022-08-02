package com.evgeniy;

import com.evgeniy.files.FilesManager;
import com.evgeniy.task.DefaultTask;
import com.evgeniy.task.Task;
import com.evgeniy.task.board.ListImplementationTaskBoard;
import com.evgeniy.task.board.ListTaskBoard;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import com.evgeniy.task.reward.PromiseReward;
import com.evgeniy.task.reward.Reward;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class Main {

    /**
     * Запускать программу тут
     */
    public static void main(String[] args) {

        ListTaskBoard taskBoard = new ListImplementationTaskBoard();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Task task1 = TaskCreationService.getInstance().createTask("Add tasks", "Add some tasks for test", new MoneyReward(1000L));
        try (FileWriter writer = new FileWriter("task.json")) {
            gson.toJson(task1, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("task.json")) {
            DefaultTask taskReader = gson.fromJson(reader, DefaultTask.class);
            System.out.println(taskReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Task task2 = TaskCreationService.getInstance().createTask("Show all tasks", "Show all added tasks for test", new BadgeReward("Gold badge"));
        Task task3 = TaskCreationService.getInstance().createTask("Remove any task", "Remove some tasks for test", new PromiseReward("Reward next week"));
        Task task4 = TaskCreationService.getInstance().createTask("Change task's status", "Change status of any task for test", new MoneyReward(2000L));
        Task task5 = TaskCreationService.getInstance().createTask("Show tasks by status", "Show all tasks with same status for test", new MoneyReward(3000L));
        System.out.println("Add.");
        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        taskBoard.addTask(task5);
        System.out.println(taskBoard);

        try (FileWriter writer = new FileWriter("taskBoard.json")) {
            gson.toJson(taskBoard, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("taskBoard.json")) {
            ListImplementationTaskBoard taskBoardReader = gson.fromJson(reader, ListImplementationTaskBoard.class);
            System.out.println(taskBoardReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //filesManager.writeIntoFile("taskboard.json", gson.toJson(taskBoard));
        //Optional<ListTaskBoard> boardReader = filesManager.readFromFile("taskboard.json",ListTaskBoard.class);
        //System.out.println(boardReader.get());
        /*taskBoard.sort(new Comparator<Task>() {
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
        /*for (Task task : taskBoard) {
            System.out.println(task);
        }

        Optional<Task> taskGet = taskBoard.getTaskById(1000002L);
        taskGet.ifPresent(task -> System.out.println(task.getStatus()));

        System.out.println("Write/read task board.");
        fileCommands.writeIntoFile("E:/intellijfiles/taskboard1.txt", taskBoard);
        Optional<ListTaskBoard> fileTaskBoard = fileCommands.readFromFile("E:/intellijfiles/taskboard1.txt", ListTaskBoard.class);
        fileTaskBoard.ifPresent(taskBoard1 -> {
            for (Task task : taskBoard1) {
                System.out.println(task);
            }
        });
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

