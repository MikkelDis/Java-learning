package dk.mikkel.todotasksapp.domain;

import dk.mikkel.todotasksapp.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {
}
