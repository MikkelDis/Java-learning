package dk.mikkel.todotasksapp.mapper.impl;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.dto.CreateTaskRequestDto;
import dk.mikkel.todotasksapp.domain.dto.TaskDto;
import dk.mikkel.todotasksapp.domain.entity.Task;
import dk.mikkel.todotasksapp.mapper.ITaskMapper;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaskMapper implements ITaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
