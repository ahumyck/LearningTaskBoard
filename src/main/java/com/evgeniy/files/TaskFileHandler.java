package com.evgeniy.files;

import java.io.IOException;
import java.util.Optional;

public interface TaskFileHandler {
    <T> void writeIntoFile(String filename, T object) throws IOException;
    <T> Optional<T> readFromFile(String filename, Class<T> objectClass) throws IOException, ClassNotFoundException;

}
