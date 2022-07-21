package com.evgeniy.files;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.TaskBoard;

import java.io.*;
import java.util.Optional;

public class WorkWithFiles {

    public void writeTaskIntoFile(Task task, String path) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(task);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Task> readTaskFromFile(String path) throws ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            Task task = (Task) objectInputStream.readObject();
            objectInputStream.close();
            return Optional.of(task);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void writeTaskBoardIntoFile(TaskBoard taskBoard, String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(taskBoard);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<TaskBoard> readTaskBoardFromFile(String path) throws ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            TaskBoard taskBoard = (TaskBoard) objectInputStream.readObject();
            objectInputStream.close();
            return Optional.of(taskBoard);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void deleteFile(String path) {
        File file = new File(path);
        System.out.println(file.delete());
    }
}
