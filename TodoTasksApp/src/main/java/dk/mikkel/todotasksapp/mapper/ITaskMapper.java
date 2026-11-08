package dk.mikkel.todotasksapp.mapper;

import dk.mikkel.todotasksapp.domain.CreateTaskRequest;
import dk.mikkel.todotasksapp.domain.dto.CreateTaskRequestDto;
import dk.mikkel.todotasksapp.domain.dto.TaskDto;
import dk.mikkel.todotasksapp.domain.entity.Task;

public interface ITaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
