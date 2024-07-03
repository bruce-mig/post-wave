package com.github.bruce_mig.post_wave.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
        @Id
        @GeneratedValue
        private Integer id;
        private String username;
        private String description;
        private LocalDate targetDate;
        private boolean done;
}
