package dk.mikkel.todotasksapp.service;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.UpdateTaskRequest;
import dk.mikkel.todotasksapp.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface ITaskService {

    /*
    Could return a CreateTaskResponse object containing all the details
    of the created task, but it would not be the task entity, which
    would create more seperation between the layers, and thereby a bit more decoubling
    since it then would not rely on returning an entity, which is owned by the peristence layer
    */
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest updateTaskRequest);
}
