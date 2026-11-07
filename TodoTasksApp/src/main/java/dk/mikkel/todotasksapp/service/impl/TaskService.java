package dk.mikkel.todotasksapp.service.impl;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.entity.Task;
import dk.mikkel.todotasksapp.domain.entity.TaskStatus;
import dk.mikkel.todotasksapp.repository.ITaskRepository;
import dk.mikkel.todotasksapp.service.ITaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request){
        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );

        return taskRepository.save(task);
    }
}
