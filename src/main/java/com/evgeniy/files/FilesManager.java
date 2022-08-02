package com.evgeniy.files;

import java.io.*;
import java.util.Optional;

public class FilesManager implements TaskFileHandler {

    public <T> void writeIntoFile(String path, T obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Optional<T> readFromFile(String path, Class<T> objectClass) throws ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            Optional<T> task = (Optional<T>) Optional.ofNullable(objectInputStream.readObject());
            return task;
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
