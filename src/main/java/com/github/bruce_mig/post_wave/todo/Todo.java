package com.github.bruce_mig.post_wave.todo;

import java.time.LocalDate;

public record Todo(
        int id,
        String username,
        String description,
        LocalDate targetDate,
        boolean done
) {
}
