package dk.mikkel.todotasksapp.domain.dto;

import dk.mikkel.todotasksapp.domain.entity.TaskPriority;
import dk.mikkel.todotasksapp.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String Title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
