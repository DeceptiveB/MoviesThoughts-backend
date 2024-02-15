package com.deceptiveb.movies.payload.movie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @NotBlank
        String name,
        @NotBlank
        String argument,
        @NotBlank
        String director,
        @NotNull
        List<Integer> genres,
        @DateTimeFormat
        LocalDate releaseDate
) {
}
