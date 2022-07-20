package com.evgeniy.files;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.TaskBoard;

import java.io.*;

public class WorkWithFiles {

    public static void WriteTaskIntoFile(Task task, String path) throws FileNotFoundException {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(task);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Task ReadTaskFromFile(String path) throws IOException, ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Task task = (Task) objectInputStream.readObject();
            objectInputStream.close();
            return task;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void WriteTaskBoardIntoFile(TaskBoard taskBoard, String path) throws FileNotFoundException {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(taskBoard);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TaskBoard ReadTaskBoardFromFile(String path) throws IOException, ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            TaskBoard taskBoard = (TaskBoard) objectInputStream.readObject();
            objectInputStream.close();
            return taskBoard;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
