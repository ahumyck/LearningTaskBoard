package com.evgeniy.task.board;

import com.evgeniy.files.DefaultDeleter;
import com.evgeniy.files.FileDeleter;
import com.evgeniy.files.FilesManager;
import com.evgeniy.task.MockReward;
import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Supplier;


class ListTaskBoardTest {

    @Test
    void listBoardCloneEquals() throws CloneNotSupportedException {
        taskBoardCloneEquals(ListImplementationTaskBoard::new);
    }

    @Test
    void collectionBoardCloneEquals() throws CloneNotSupportedException {
        taskBoardCloneEquals(() -> new CollectionImplementationTaskBoard(new ArrayList<>()));
    }

    @Test
    void mapBoardCloneEquals() throws CloneNotSupportedException {
        taskBoardCloneEquals(() -> new MapImplementationTaskBoard(new HashMap<>()));
    }
    private void taskBoardCloneEquals(Supplier<CollectionTaskBoard> collectionTaskBoardSupplier) throws CloneNotSupportedException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        CollectionTaskBoard taskBoard = collectionTaskBoardSupplier.get();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        CollectionTaskBoard cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }

    @Test
    void listBoardWriteRead() throws ClassNotFoundException {
        taskBoardWriteRead(ListImplementationTaskBoard::new);
    }

    @Test
    void collectionBoardWriteRead() throws ClassNotFoundException {
        taskBoardWriteRead(() -> new CollectionImplementationTaskBoard(new ArrayList<>()));
    }

    @Test
    void mapBoardWriteRead() throws ClassNotFoundException {
        taskBoardWriteRead(() -> new MapImplementationTaskBoard(new HashMap<>()));
    }

    private void taskBoardWriteRead(Supplier<CollectionTaskBoard> collectionTaskBoardSupplier) throws ClassNotFoundException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        CollectionTaskBoard taskBoard = collectionTaskBoardSupplier.get();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        FilesManager fileCommands = new FilesManager();
        FileDeleter deleter = new DefaultDeleter();
        fileCommands.writeIntoFile("tmp.board", taskBoard);
        Optional<CollectionTaskBoard> readTaskBoard = fileCommands.readFromFile("tmp.board", CollectionTaskBoard.class);
        readTaskBoard.ifPresentOrElse((value) -> Assertions.assertEquals(taskBoard, value), Assertions::fail);
        deleter.deleteFile("tmp.board");
        Optional<CollectionTaskBoard> readAgain = fileCommands.readFromFile("tmp.board", CollectionTaskBoard.class);
        Assertions.assertEquals(Optional.empty(), readAgain);
    }

    @Test
    void listSortingTest() {
        sortingTest(ListImplementationTaskBoard::new);
    }

    @Test
    void collectionSortingTest() {
        sortingTest(() -> new CollectionImplementationTaskBoard(new ArrayList<>()));
    }

    @Test
    void mapSortingTest() {
        sortingTest(() -> new MapImplementationTaskBoard(new LinkedHashMap<>()));
    }

    private void sortingTest(Supplier<CollectionTaskBoard> collectionTaskBoardSupplier) {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        CollectionTaskBoard taskBoard = collectionTaskBoardSupplier.get();
        taskBoard.addTask(task4);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task1);
        taskBoard.sort();
        System.out.println(taskBoard);
        Assertions.assertTrue(Ordering.natural().isOrdered(taskBoard));
    }
}