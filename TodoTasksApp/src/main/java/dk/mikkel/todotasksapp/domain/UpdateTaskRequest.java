package dk.mikkel.todotasksapp.domain;

import dk.mikkel.todotasksapp.domain.entity.TaskPriority;
import dk.mikkel.todotasksapp.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
