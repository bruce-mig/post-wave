package com.github.bruce_mig.post_wave.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    @Size(min=2, message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
}
