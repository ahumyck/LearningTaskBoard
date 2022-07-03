package com.evgeniy.task.creation;

import com.evgeniy.task.Task;
import com.evgeniy.task.DefaultTask;

/**
 * Сервис для создания задач
 */
public class TaskCreationService {

    private long idCounter = 999_999;

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

    public Task createTask(String name, String description) {
        return new DefaultTask(idCounter++, name, description);
    }

}
