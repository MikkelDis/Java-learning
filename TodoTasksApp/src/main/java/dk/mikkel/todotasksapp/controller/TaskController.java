package dk.mikkel.todotasksapp.controller;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.dto.CreateTaskRequestDto;
import dk.mikkel.todotasksapp.domain.dto.TaskDto;
import dk.mikkel.todotasksapp.domain.entity.Task;
import dk.mikkel.todotasksapp.mapper.ITaskMapper;
import dk.mikkel.todotasksapp.service.ITaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final ITaskService taskService;
    private final ITaskMapper taskMapper;


    public TaskController(ITaskService taskService, ITaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
           @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);
    }
}
