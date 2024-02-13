package org.adaschool.Seguridad.API.REST.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record userDto(
        String id,
        String firstName,
        String lastName,
        Integer age,
        String email
) {
}
