package com.enriquebarragan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record SoftwareEngineerDTO (
        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String name,
        @NotEmpty(message = "El techStack no puede estar vacío")
        @Size(max = 10, message = "No puede haber más de 10 tecnologías")
        List<@NotBlank(message = "Una tecnología no puede ser un texto vacío")
             @Size(max = 20, message = "El nombre de la tecnología no puede superar 20 caracteres")
             String> techStack) {
}
