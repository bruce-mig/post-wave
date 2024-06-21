package com.github.bruce_mig.post_wave.user;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
