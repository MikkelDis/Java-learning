package dk.mikkel.todotasksapp.service.impl;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.UpdateTaskRequest;
import dk.mikkel.todotasksapp.domain.entity.Task;
import dk.mikkel.todotasksapp.domain.entity.TaskStatus;
import dk.mikkel.todotasksapp.exception.TaskNotFoundException;
import dk.mikkel.todotasksapp.repository.ITaskRepository;
import dk.mikkel.todotasksapp.service.ITaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest updateTaskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));

        task.setTitle(updateTaskRequest.title());
        task.setDescription(updateTaskRequest.description());
        task.setDueDate(updateTaskRequest.dueDate());
        task.setStatus(updateTaskRequest.status());
        task.setPriority(updateTaskRequest.priority());
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
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
