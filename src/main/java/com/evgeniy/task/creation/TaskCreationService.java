package com.evgeniy.task.creation;

import com.evgeniy.task.Status;
import com.evgeniy.task.Task;
import com.evgeniy.task.TaskImpl;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Сервис для создания задач
 */
public class TaskCreationService {

    /*
     * На это не обращай внимания особо, потом расскажу зачем это
     */
    private static class InnerHolder {
        public static final TaskCreationService TASK_CREATION_SERVICE = new TaskCreationService();
    }

    /**
     * Если где-то необходимо использовать TaskCreationService, то необходимо воспользоваться этим методом
     */
    public static TaskCreationService getInstance() {
        return InnerHolder.TASK_CREATION_SERVICE;
    }

    public Task createTask(Long id, String name, String description, Status status, Date ctime) {
        //Реализовать самому

        return new TaskImpl(id, name, description, status, ctime);
    }

}
